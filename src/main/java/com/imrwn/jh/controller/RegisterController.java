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
			attr.addFlashAttribute("msg", "�α��� �����߽��ϴ�.");
			return "redirect:/save";
		}

		return "redirect:/login";
	}

	private String makeNick() {
		// TODO Auto-generated method stub
		String[] adjective = {"�ູ��", "����", "������", "����ο�", "������", "�׸���", "������", "������", "�����", "��θ�",
				"����", "���", "�����ִ�", "���߶���"};
		String[] animals = {"ȣ����", "���", "������", "�ξ���", "����", "ġŸ", "����", "�����", "�̾�Ĺ", "�ٶ���"};
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
