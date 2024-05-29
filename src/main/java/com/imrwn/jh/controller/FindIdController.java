package com.imrwn.jh.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.imrwn.jh.dto.Member;
import com.imrwn.jh.service.MailService;
import com.imrwn.jh.service.MemberService;

@Controller
public class FindIdController {
	@Autowired
	MemberService memberService;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	private MailService mailService;

	@GetMapping("/findid")
	public String findId() {
		return "imrwnLogin/FindId";
	}

	@PostMapping("/findid")
	@ResponseBody
	public ResponseEntity<String> sendEmail(String id, String email, RedirectAttributes redatt) throws Exception {
		
		Member m = memberService.getSelectId(id);
		if(m.getEmail().equals(email)) {
			
			
			String uuid = UUID.randomUUID().toString().substring(0, 8);
			
			String addr = "imrwncs1@gmail.com";
			String subject = "IMRWN 인증키";
			String body = uuid + " 입니다";
	
			mailService.sendEmail(email, addr, subject, body);
			
	
			return new ResponseEntity<String>(uuid, HttpStatus.OK);
		}else return  new ResponseEntity<String>("err", HttpStatus.OK);
	}

	@PostMapping("/change")
	public String change(String id, Model model) throws Exception {
		model.addAttribute("id", id);
		return "imrwnLogin/changePwd";
	}

	@PostMapping("/changepwd")
	public String chagePwd(String id, String pwd, RedirectAttributes redatt) throws Exception {
		Member m = memberService.getSelectId(id);
		String Newpwd = passwordEncoder.encode(pwd);
		m.setPwd(Newpwd);
		
		int res = memberService.getUpdateMem(m);
		if(res != 1) {
			redatt.addFlashAttribute("msg", "err");
			return "redirect:/change";
		}
		redatt.addFlashAttribute("msg", "changeSuc");
		return "redirect:/login";
	}
}
