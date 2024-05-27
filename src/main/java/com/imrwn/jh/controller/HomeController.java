package com.imrwn.jh.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imrwn.jh.dto.Board;
import com.imrwn.jh.dto.Movie;
import com.imrwn.jh.service.BoardService;
import com.imrwn.jh.service.MovieService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	BoardService boardService;
	@Autowired
	MovieService movieService;
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		List<Board> bList = null;
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		try {
			bList = boardService.getSelectComment();
			model.addAttribute("comment", bList);
			bList = boardService.getSelectLike();
			model.addAttribute("like", bList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "imrwnMain/Main";
	}
	@GetMapping("/suggest")
	@ResponseBody
	public ResponseEntity<String> suggestMovie(String actors, String genre, float score) {
		String[] genreArr = genre.split(",");

		List<Movie> mList = new ArrayList<Movie>();
		List<Movie> check = null;
		try {
			for(int i = 0 ; i < genreArr.length ; i++) {
				check = movieService.getSelectRandom(actors, genreArr[i], score);
				if(!check.isEmpty()) {
					for(int j = 0 ; j < check.size() ; j++) {
					String[] poster = check.get(j).getPosters().split("\\|");
					check.get(j).setPosters(poster[0]);
					mList.add(check.get(j));
					}
				}
			}
			ObjectMapper objectMapper = new ObjectMapper();
			String ex = objectMapper.writeValueAsString(mList);
			
			return new ResponseEntity<String>(ex, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("err", HttpStatus.BAD_REQUEST);
		}
	}
	
}

