package com.imrwn.jh.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.imrwn.jh.dao.MemberDao;
import com.imrwn.jh.dto.Member;

@Controller
public class LoginController {
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/login")
	public String Login() {
		return "imrwnLogin/Login";
	}
	
	@PostMapping("/login")
	public String loginId(RedirectAttributes attr, String toURL, String id, String pwd, boolean rememberId, HttpServletResponse resp, HttpSession session, Model m) throws Exception {
		if(!loginCheck(id, pwd)) {
			attr.addFlashAttribute("msg", "logErr");
			return "redirect:/login";
		}
		if(rememberId) {
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(60*60*24);
			resp.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("id",id);
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
		}
		session.setAttribute("id", id);
		if(toURL == null || "".equals(toURL)) toURL="/";
		return "redirect:" + toURL;
	}

	private boolean loginCheck(String id, String pwd) throws Exception {
		Member m = memberDao.selectId(id);
		return m != null && m.getId().equals(id) && passwordEncoder.matches(pwd, m.getPwd());
	}
	@GetMapping("/logout")
	public String Logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}

	
}
