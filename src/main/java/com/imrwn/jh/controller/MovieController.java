package com.imrwn.jh.controller;

import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imrwn.jh.basic.MovPageHandler;
import com.imrwn.jh.basic.MovSearchCondition;
import com.imrwn.jh.dto.Like_M;
import com.imrwn.jh.dto.Member;
import com.imrwn.jh.dto.Movie;
import com.imrwn.jh.dto.Review_M;
import com.imrwn.jh.jackson.Actor;
import com.imrwn.jh.jackson.Director;
import com.imrwn.jh.jackson.Plot;
import com.imrwn.jh.service.Like_MService;
import com.imrwn.jh.service.MemberService;
import com.imrwn.jh.service.MovieService;
import com.imrwn.jh.service.Review_MService;

@Controller
@RequestMapping("/movie")
public class MovieController {
	@Autowired
	MovieService movieService;
	@Autowired
	MemberService memberService;
	@Autowired
	Review_MService reviewService;
	@Autowired
	Like_MService likeService;
	

	@RequestMapping(method = RequestMethod.POST, path ="/moviedb" , produces="application/text;charset=utf-8" )
	@ResponseBody
	public ResponseEntity<String> Movie(String movieArr, String arr) {

		movieArr = movieArr.replace("  !HS", "");
		movieArr = movieArr.replace(" !HE ", "");
		movieArr = movieArr.replace(" !HS ", "");
		movieArr = movieArr.trim();
		movieArr = movieArr.replace("'","@");		

		ObjectMapper objectMapper = new ObjectMapper();

		List<Movie> movies = null;
		Movie m = null;
		try {
			movies = objectMapper.readValue(movieArr, new TypeReference<>() {});
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0 ; i < movies.size(); i++) {
			String director = "";
			String actor = "";
			
			try {
				Map<String,List<Director>> directors = objectMapper.readValue(movies.get(i).getDirectors(), new TypeReference<>(){});
				for(int j = 0 ; j < directors.get("director").size() ; j++) {
					director += directors.get("director").get(j).getDirectorNm() + ", ";
				}

				movies.get(i).setDirectors(director.substring(0, director.length() -2).trim());
				
				Map<String,List<Actor>> actors = objectMapper.readValue(movies.get(i).getActors(), new TypeReference<>() {});
				
				for(int k = 0 ; k < actors.get("actor").size() ; k++) {
					actor += actors.get("actor").get(k).getActorNm() + ", "; 
				}

				movies.get(i).setActors(actor.substring(0, actor.length() -2).trim());
				
				Map<String,List<Plot>> plots = objectMapper.readValue(movies.get(i).getPlots(), new TypeReference<>() {});
				
				movies.get(i).setPlots(plots.get("plot").get(0).getPlotText());
				
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				 m = movieService.getSelectMovie(movies.get(i).getTitle(), movies.get(i).getDirectors());
				if(m == null || "null".equals(m.getTitle()) || "".equals(m.getTitle()) ) {
					int res = movieService.getSaveDB(movies.get(i));
					if (res != 1) System.out.println(movies.get(i) + " : 오류가 있습니다.");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			try {
				m = movieService.getSelectMovie(movies.get(0).getTitle(), movies.get(0).getDirectors());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String mov = objectMapper.writeValueAsString(m);

			return new ResponseEntity<String>(mov, HttpStatus.OK);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return new ResponseEntity<String>("no", HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/search")
	public String searchMovie (MovSearchCondition sc, Model m) {
		List<Movie> mList = null;
		if(sc.getSearchWord() == null) {
			sc.setSearchWord("");
		}
		try {
			int totalCnt = movieService.getSelectSearchCnt(sc);
			MovPageHandler ph = new MovPageHandler(totalCnt, sc);
			mList = movieService.getSelectSearch(sc);
			for(int i = 0 ; i < mList.size() ; i++) {
				if(mList.get(i).getPosters().contains("|")) {
					StringTokenizer st = new StringTokenizer(mList.get(i).getPosters(), "|");
					if(st.hasMoreTokens()){
						mList.get(i).setPosters(st.nextToken());
					}
				}
			}
			m.addAttribute("mList", mList);
			m.addAttribute("ph", ph);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "imrwnMovie/Movie";
	}
	@GetMapping("/view")
	public String movieView (Integer mno,HttpSession session, HttpServletRequest req, Model model) {
		Movie m;
		Member member;
		Review_M r;
		Like_M l;  //평점
		Like_M lm; //내가 준 평점
		String id = session.getAttribute("id")+"";
		
		if (!loginCheck(req)) {
			return "redirect:/login?toURL=" + req.getRequestURL() + "?mno=" + mno;
		}
		try {
			m = movieService.getSelectMno(mno);
			member = memberService.getSelectId(id);
			r = reviewService.getSelectId(id, mno);
			l = likeService.getSelectAvg(mno);
			lm = likeService.getSelect(mno, id);
		if(r != null) {
				r.setReview(r.getReview().replace("<br>", "\r\n"));
			}
			if(m.getPosters().contains("|")) {
				StringTokenizer sc = new StringTokenizer(m.getPosters(), "|");
				if(sc.hasMoreTokens()){
					m.setPosters(sc.nextToken());
				}
			}
			if (lm != null) {
				
				model.addAttribute("lm", lm);
				if (lm.getGood() == 1) {
					model.addAttribute("like","good");
				}
			}

			model.addAttribute("r", r);
			model.addAttribute("member" , member);
			model.addAttribute("m", m);
			model.addAttribute("l", l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "imrwnMovie/View";
	}
	private boolean loginCheck(HttpServletRequest req) {
		HttpSession session = req.getSession();

		return session.getAttribute("id") != null;
	}
}
