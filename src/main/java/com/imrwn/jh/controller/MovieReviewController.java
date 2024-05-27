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
import com.imrwn.jh.dto.Review_M;
import com.imrwn.jh.service.Review_MService;

@Controller
public class MovieReviewController {
	
	@Autowired
	Review_MService reviewService;
	
	@GetMapping("/review")
	@ResponseBody
	public ResponseEntity<List<Review_M>> list(Integer mno) {
		List<Review_M> rList = null;
		
		try {
			rList = reviewService.getSelectAll(mno);
			
			return new ResponseEntity<List<Review_M>>(rList, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<List<Review_M>>(rList, HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/review/{rno}")
	@ResponseBody
	public ResponseEntity<String> remove(@PathVariable Integer rno, Integer mno, HttpSession session) {
		String reviewer = session.getAttribute("id")+"";
		
		try {
			int res = reviewService.getRemove(rno, reviewer, mno);
			int count = reviewService.getCount(mno);
			if ( res != 1 ) throw new Exception("delete_failed");
			return new ResponseEntity<>(count+"", HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>("DEL_ERR", HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/review")
	@ResponseBody
	public ResponseEntity<String> write (@RequestBody Review_M r, HttpSession session ) {
		String reviewer = session.getAttribute("id") + "";
		r.setReviewer(reviewer);
		try {
			int cnt = reviewService.getWrite(r);
			if( cnt != 1) throw new Exception("write error");
			int count = reviewService.getCount(r.getMno());
			Review_M lm = reviewService.getSelectId(reviewer, r.getMno());
			Map map = new HashMap();
			map.put("count", count);
			map.put("modify", "modifyOk");
			map.put("rno", lm.getRno());
			
			ObjectMapper objectMapper = new ObjectMapper();
			String ex = objectMapper.writeValueAsString(map);
			
			return new ResponseEntity<String>(ex, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("WRITE_ERR", HttpStatus.BAD_REQUEST);
		}
	}
	@PatchMapping("/review/{rno}")
	@ResponseBody
	public ResponseEntity<String> modify(@PathVariable Integer rno, @RequestBody Review_M r, HttpSession session) {
		String reviewer = session.getAttribute("id") + "";
		r.setReviewer(reviewer);
		r.setRno(rno);
		
		int res;
		try {
			res = reviewService.getModify(r);
			if( res != 1 ) throw new Exception("Modify Error");
			return new ResponseEntity<String>("MODIFY_OK", HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("MODIFY_ERR", HttpStatus.BAD_REQUEST);
			
		}
	}
}
