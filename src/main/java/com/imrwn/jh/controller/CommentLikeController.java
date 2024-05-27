package com.imrwn.jh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imrwn.jh.dto.Comment_B;
import com.imrwn.jh.dto.Like_B;
import com.imrwn.jh.service.Comment_BService;
import com.imrwn.jh.service.Like_BService;

@Controller
public class CommentLikeController {
	
	@Autowired
	Comment_BService commentService;
	@Autowired
	Like_BService likeService;
	
	@GetMapping("/comments")
	@ResponseBody
	public ResponseEntity<List<Comment_B>> list(Integer bno) {
		List<Comment_B> cList = null;
		try {
			cList = commentService.getList(bno);
			
			return new ResponseEntity<List<Comment_B>>(cList, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<List<Comment_B>>(cList, HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/comments/{cno}")
	@ResponseBody
	public ResponseEntity<String> remove(@PathVariable Integer cno, Integer bno, HttpSession session) {
		String commenter = session.getAttribute("id") + "";
		
		try {
			int res = commentService.getRemove(cno, bno, commenter);
			int count = commentService.getCount(bno);
			if(res != 1) throw new Exception("delete_failed");
			return new ResponseEntity<>(count+"", HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>("DEL_ERR", HttpStatus.BAD_REQUEST);
		}	
	}
	@PostMapping("/comments")
	@ResponseBody
	public ResponseEntity<String> write (@RequestBody Comment_B c, HttpSession session) {
		String commenter = session.getAttribute("id") + "";
		c.setCommenter(commenter);
		
		try {
			int cnt = commentService.getWrite(c);
			if(cnt != 1) throw new Exception("write error");
			int count = commentService.getCount(c.getBno());
			Map map = new HashMap();
			map.put("count", count);
			map.put("modify", "modifyOk");
			ObjectMapper objectMapper = new ObjectMapper();
			String ex = objectMapper.writeValueAsString(map);
			
			return new ResponseEntity<String>(ex, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("WRITE_ERR", HttpStatus.BAD_REQUEST);
		}
		
	}
 	
	
	@PatchMapping("/comments/{cno}")
	@ResponseBody
	public ResponseEntity<String> modify(@PathVariable Integer cno, @RequestBody Comment_B c, HttpSession session) {
		String commenter = session.getAttribute("id") + "";
		c.setCommenter(commenter);
		c.setCno(cno);
		
		try {
			int res = commentService.getModify(c);
			if(res != 1) throw new Exception("Modify Error");
			return new ResponseEntity<String>("MODIFY_OK", HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("MODIFY_ERR", HttpStatus.BAD_REQUEST);
		}
		
	}
	@PostMapping("/like/{likeMode}")
	@ResponseBody
	public ResponseEntity<String> like(@RequestBody Like_B l, @PathVariable String likeMode,HttpSession session) {
		String id = session.getAttribute("id") + "";
		int res = 0;
		Map map = new HashMap();

		String ex = "";
		System.out.println(likeMode);
		String nextLikeMode = "";

		l.setId(id);
		System.out.println(l);
		try {

			if("nope".equals(likeMode)) {
				res = likeService.getDelete(id, l.getBno());
				if(res != 1) {throw new Exception("Like Error");}
				int count = likeService.getCount(l.getBno());
				map.put("nextLikeMode", "good");
				map.put("count", count);
				ObjectMapper objectMapper = new ObjectMapper();
				ex = objectMapper.writeValueAsString(map);

			}
			else if("good".equals(likeMode)) {
				res = likeService.getInsert(l);
				if(res != 1) {throw new Exception("Like Error");}
				int count = likeService.getCount(l.getBno());
				map.put("nextLikeMode", "nope");
				map.put("count", count);
				ObjectMapper objectMapper = new ObjectMapper();
				ex = objectMapper.writeValueAsString(map);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("Like_ERR", HttpStatus.BAD_REQUEST);
		}
		System.out.println("nextLikeMode : " + nextLikeMode);
		return new ResponseEntity<String>(ex, HttpStatus.OK);
		
	}
}
