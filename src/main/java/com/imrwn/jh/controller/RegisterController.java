package com.imrwn.jh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.imrwn.jh.dao.MemberDao;
import com.imrwn.jh.dto.Member;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	MemberDao memberDao;

	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/save")
	public String Register() {
		return "imrwnSignup/ImrwnSignup";
	}

	@PostMapping("/save")
	public String Save(RedirectAttributes attr, @ModelAttribute Member m) throws Exception {
		System.out.println(m.getId());
		String pwd = passwordEncoder.encode(m.getPwd());
		m.setPwd(pwd);
		String nickName = makeNick();
		System.out.println("nickName = " + nickName);
		m.setNickName(nickName);
		int res = memberDao.insertMem(m);

		if (res != 1) {
			attr.addFlashAttribute("msg", "로그인 실패했습니다.");
			return "redirect:/save";
		}

		return "redirect:/login";
	}

	private String makeNick() {
		// TODO Auto-generated method stub
		String[] adjective = {"행복한", "슬픈", "게으른", "슬기로운", "수줍은", "그리운", "더러운", "섹시한", "배고픈", "배부른",
				"부자", "재벌", "웃고있는", "깨발랄한"};
		String[] animals = {"호랑이", "비버", "강아지", "부엉이", "여우", "치타", "문어", "고양이", "미어캣", "다람쥐"};
		int tmp = (int) (Math.random()*adjective.length);
		String adj = adjective[tmp];
		System.out.println(tmp);
		tmp = (int)( Math.random()*animals.length);
		System.out.println(tmp);
		String animal = animals[tmp];

		return adj + " " + animal;
	}

	@PostMapping("/idCheck")
	@ResponseBody
	public int idCheck(String text) throws Exception {
		System.out.println(text);
		Member m = memberDao.selectId(text);
		if (m == null) {
			return 0;
		} else {
			return 1;
		}
	}
}
