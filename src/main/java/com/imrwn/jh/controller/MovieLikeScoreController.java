package com.imrwn.jh.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imrwn.jh.dto.Like_M;
import com.imrwn.jh.service.Like_MService;

@Controller
public class MovieLikeScoreController {
	
	@Autowired
	Like_MService likeService;
	
	@PostMapping("/score")
	@ResponseBody
	public ResponseEntity<Like_M> score (@RequestBody Like_M l, HttpSession session){
		String id = session.getAttribute("id") + "";
		l.setId(id);
		try {
			Like_M check = likeService.getSelect(l.getMno(), id);
			if( check == null ) {
				int res = likeService.getWriteScore(l);
				if (res == 1) {
				}
			}else {
				int res = likeService.getModifyScore(l.getScore(), l.getMno(), id);
				if (res == 1) {
				}
			}
			System.out.println("1 : " + check);

			return new ResponseEntity<Like_M>(l, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Like_M>(l, HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/mlike/{likeMode}")
	@ResponseBody
	public ResponseEntity<String> like(@RequestBody Like_M l, @PathVariable String likeMode, HttpSession session) {
		String id = session.getAttribute("id") + "";
		int res = 0;
		Map map = new HashMap();
		
		String ex = "";
		String nextLikeMode = "";
		l.setId(id);
		System.out.println(l);
		System.out.println(likeMode);
		try {
			Like_M check = likeService.getSelect(l.getMno(), id);
			if ( check == null) {
				res = likeService.getWriteGood(l);
			}
			if("nope".equals(likeMode)) {
				res = likeService.getModifyGood(1, l.getMno(), id);
				if (res != 1) {throw new Exception("like Error");}
				int count = likeService.getCount(l.getMno());
				map.put("nextLikeMode", "good");
				map.put("count", count);
				ObjectMapper objectMapper = new ObjectMapper();
				ex = objectMapper.writeValueAsString(map);
			}else if ("good".equals(likeMode)) {
				res = likeService.getModifyGood(-1, l.getMno(), id);
				if(res != 1) {throw new Exception("like Error");}
				int count = likeService.getCount(l.getMno());
				map.put("nextLikeMode", "nope");
				map.put("count", count);
				ObjectMapper objectMapper = new ObjectMapper();
				ex = objectMapper.writeValueAsString(map);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>(ex, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>(ex, HttpStatus.OK);
	}
	
}
