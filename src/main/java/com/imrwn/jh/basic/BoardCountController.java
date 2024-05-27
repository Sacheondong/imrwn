package com.imrwn.jh.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imrwn.jh.dao.BoardDao;
import com.imrwn.jh.dto.Board;

@Controller
@RequestMapping("board")
public class BoardCountController {
	@Autowired
	BoardDao dao;
	
	@GetMapping("/board1")
	public String board(Board dto) throws Exception {
		for(int i = 0 ; i <= 100 ; i++) {
		dto.setTitle("asdf" + 3*i);
		dto.setContent("asdf12" + 3*i);
		dto.setWriter("dlawjdgur94");
		dto.setMovieType("east");
		int res = dao.insert(dto);
		
		}
		System.out.println("¿Ï·á");
		
		return "imrwnMain/Main";
	}
}
