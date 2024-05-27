package com.imrwn.jh.controller;

import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.imrwn.jh.basic.MovPageHandler;
import com.imrwn.jh.basic.MovSearchCondition;
import com.imrwn.jh.dto.Board;
import com.imrwn.jh.dto.Comment_B;
import com.imrwn.jh.dto.Member;
import com.imrwn.jh.dto.Movie;
import com.imrwn.jh.dto.Review_M;
import com.imrwn.jh.service.BoardService;
import com.imrwn.jh.service.Comment_BService;
import com.imrwn.jh.service.MemberService;
import com.imrwn.jh.service.MovieService;
import com.imrwn.jh.service.Review_MService;

@Controller
public class MyInfoController {
	
	@Autowired
	MemberService memberService;
	@Autowired
	BoardService boardService;
	@Autowired
	Comment_BService commentService;
	@Autowired
	Review_MService reviewService;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MovieService movieService;
	
	@GetMapping("/myinfo")
	public String myInfo(HttpSession session, Model model) {
		String id = session.getAttribute("id")+"";
		List<Comment_B> cList = null;		
		List<Board> bList = null;
		List<Review_M> rList = null;
		
		try {
			Member m = memberService.getSelectId(id);
			cList = commentService.getSelectInfoId(id);
			bList = boardService.getSelectInfoId(id);
			rList = reviewService.getSelectInfoId(id);

			
			
			model.addAttribute("m", m);
			model.addAttribute("cList", cList);
			model.addAttribute("bList", bList);
			model.addAttribute("rList", rList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "imrwnReg_info/Myinfo";
	}
	@PostMapping("/myinfo")
	public String updateMem(Member m, RedirectAttributes attr ) {
		if (m.getPwd() != null && m.getPwd() != "" && m.getPwd() != "null") {
			String pwd = passwordEncoder.encode(m.getPwd());
			
			m.setPwd(pwd);
		}
		System.out.println(m);
		try {
			int res = memberService.getUpdateMem(m);
			if (res == 1) {
				attr.addFlashAttribute("msg", "ok");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attr.addFlashAttribute("msg", "no");
			return "redirect:/myinfo";
		}
		return "redirect:/myinfo";
	}
	@GetMapping("/mymovielist")
	public String mymovielist (MovSearchCondition sc, HttpSession session, Model model) {
		String id = session.getAttribute("id")+"";
		List<Movie> mList = null;
		sc.setSearchWord(id);
		if(sc.getSearchWord() == null) {
			sc.setSearchWord("");
		}
		int totalCnt;
		try {
			totalCnt = movieService.getSelectLikeCnt(sc);
			MovPageHandler ph = new MovPageHandler(totalCnt, sc);
			mList = movieService.getSelectLikeList(sc);
			for(int i = 0 ; i < mList.size() ; i++) {
				if(mList.get(i).getPosters().contains("|")) {
					StringTokenizer st = new StringTokenizer(mList.get(i).getPosters(), "|");
					if(st.hasMoreTokens()){
						mList.get(i).setPosters(st.nextToken());
					}
				}
			}
			model.addAttribute("mList", mList);
			model.addAttribute("ph", ph);
			model.addAttribute("like", "ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "imrwnMovie/Movie";
	}
}
