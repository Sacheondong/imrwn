package com.imrwn.jh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imrwn.jh.dto.Member;
import com.imrwn.jh.service.MemberService;

@Controller
@RequestMapping("/admin")
public class DBindexController {
	@Autowired
	MemberService memberService;
	
	
	@GetMapping("/dbindex")
	public String dbindex(Model model) {
		List<Member> mList = null;
		try {
			mList = memberService.getSelectAll();
			model.addAttribute("mList", mList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "imrwnReg_info/DBindex";
	}
	@GetMapping("/iddelete")
	public String idDelete(String id) {
		try {
			int res = memberService.getDeleteId(id);	
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/admin/dbindex";
	}
}
