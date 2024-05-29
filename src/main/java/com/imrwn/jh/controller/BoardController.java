package com.imrwn.jh.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.imrwn.jh.basic.PageHandler;
import com.imrwn.jh.basic.SearchCondition;
import com.imrwn.jh.dto.Board;
import com.imrwn.jh.dto.Like_B;
import com.imrwn.jh.service.BoardService;
import com.imrwn.jh.service.Like_BService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;
	@Autowired
	Like_BService likeService;
	
	@GetMapping("/kor")
	public String korboardList(SearchCondition sc, HttpServletRequest req, Model m) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String now = sdf.format(date);

		if (!loginCheck(req)) {
			return "redirect:/login?toURL=" + req.getRequestURL();
		}
		m.addAttribute("now", now);

		try {
			sc.setMovieType("kor");
			int totalCnt = boardService.getSearchResultCnt(sc);
			PageHandler ph = new PageHandler(totalCnt, sc);
			List<Board> list = boardService.getSearchResultPage(sc);
			m.addAttribute("list", list);
			m.addAttribute("ph", ph);
			m.addAttribute("movieType", sc.getMovieType());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/imrwnBoard/List";

	}

	@GetMapping("/eng")
	public String engboardList(SearchCondition sc, HttpServletRequest req, Model m) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String now = sdf.format(date);

		if (!loginCheck(req)) {
			return "redirect:/login?toURL=" + req.getRequestURL();
		}
		m.addAttribute("now", now);

		try {
			sc.setMovieType("eng");
			int totalCnt = boardService.getSearchResultCnt(sc);
			PageHandler ph = new PageHandler(totalCnt, sc);
			List<Board> list = boardService.getSearchResultPage(sc);
			m.addAttribute("list", list);
			m.addAttribute("ph", ph);
			m.addAttribute("movieType", sc.getMovieType());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/imrwnBoard/List";

	}

	@GetMapping("/jpn")
	public String jpnboardList(SearchCondition sc, HttpServletRequest req, Model m) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String now = sdf.format(date);

		if (!loginCheck(req)) {
			return "redirect:/login?toURL=" + req.getRequestURL();
		}
		m.addAttribute("now", now);

		try {
			sc.setMovieType("jpn");
			int totalCnt = boardService.getSearchResultCnt(sc);
			PageHandler ph = new PageHandler(totalCnt, sc);
			List<Board> list = boardService.getSearchResultPage(sc);
			m.addAttribute("list", list);
			m.addAttribute("ph", ph);
			m.addAttribute("movieType", sc.getMovieType());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/imrwnBoard/List";

	}

	@GetMapping("/eur")
	public String eurboardList(SearchCondition sc, HttpServletRequest req, Model m) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String now = sdf.format(date);

		if (!loginCheck(req)) {
			return "redirect:/login?toURL=" + req.getRequestURL();
		}
		m.addAttribute("now", now);
		try {
			sc.setMovieType("eur");
			int totalCnt = boardService.getSearchResultCnt(sc);
			PageHandler ph = new PageHandler(totalCnt, sc);
			List<Board> list = boardService.getSearchResultPage(sc);
			m.addAttribute("list", list);
			m.addAttribute("ph", ph);
			m.addAttribute("movieType", sc.getMovieType());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/imrwnBoard/List";

	}

	@GetMapping("/east")
	public String eastboardList(SearchCondition sc, HttpServletRequest req, Model m) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String now = sdf.format(date);

		if (!loginCheck(req)) {
			return "redirect:/login?toURL=" + req.getRequestURL();
		}
		m.addAttribute("now", now);
		try {
			sc.setMovieType("east");
			int totalCnt = boardService.getSearchResultCnt(sc);
			PageHandler ph = new PageHandler(totalCnt, sc);
			List<Board> list = boardService.getSearchResultPage(sc);
			m.addAttribute("list", list);
			m.addAttribute("ph", ph);
			m.addAttribute("movieType", sc.getMovieType());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/imrwnBoard/List";

	}

	private boolean loginCheck(HttpServletRequest req) {
		HttpSession session = req.getSession();

		return session.getAttribute("id") != null;
	}
	
	@GetMapping("/read")
	public String read(Integer bno, SearchCondition sc, Model m) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String now = sdf.format(date);
		Board b;
		Like_B l;
		try {
			b = boardService.getRead(bno);
			
			l = likeService.getSelect(bno, b.getWriter());
			if(l != null) {
				m.addAttribute("like", "good");
			}
			m.addAttribute("b", b);
			m.addAttribute("now", now);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/imrwnBoard/View";
	}
	@PostMapping("/remove")
	public String remove(Integer bno, HttpSession session, SearchCondition sc, RedirectAttributes redatt) {
		
		String movieType = "";
		try {
			String writer = session.getAttribute("id")+"";
			Board m = boardService.getBoard(bno);
			movieType = m.getMovieType();
			int res = boardService.getRemove(bno, writer);

			if(res == 1) {
				redatt.addFlashAttribute("msg","del");
				
				return "redirect:/board/"+movieType+sc.getQueryString();
			}else {
				throw new Exception("board remove error");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			redatt.addFlashAttribute("msg", "error");
		}
		return "redirect:/board/"+movieType+sc.getQueryString();
	}
	@GetMapping("/write")
	public String write() {
		return "/imrwnBoard/Write";
	}
	@PostMapping("/write")
	public String writeBoard(Integer fileEx, MultipartFile[] uploadFile, Board b, HttpSession session, RedirectAttributes redatt, Model model ) {
		String writer = session.getAttribute("id")+"";
		b.setWriter(writer);
		String content = b.getContent().replace("\r\n", "<br>");
		b.setContent(content);
		
		System.out.println("b : " + b);
		System.out.println("업로드 여부 확인 : " + fileEx);
		//jsp에서 img 출력할 때는 resource 폴더에 있는 것처럼 사용
		String uploadFolder = session.getServletContext().getRealPath("/resources");
		System.out.println("uploadFolder : " + uploadFolder);
		
		System.out.println("업로드 파일 이름 : " + b.getFileName());
		
		if (fileEx == 1) {
			for (MultipartFile multipartFile : uploadFile) {
				String uploadFileName = multipartFile.getOriginalFilename();
				System.out.println("uploadFileName : " + uploadFileName);
				uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("//") + 1); // 경로가 있다면 원래 이름만 가져오기
				System.out.println("last file name : " + uploadFileName);
				
				UUID uuid = UUID.randomUUID();
				uploadFileName = uuid.toString() + "-" + uploadFileName;
				System.out.println("변환 후 파일 이름 : " + uploadFileName);
				
				java.io.File saveFile = new java.io.File(uploadFolder, uploadFileName);
			
				try {
					multipartFile.transferTo(saveFile);
					b.setFileName(uploadFileName);
					System.out.println("b의 파일 명 : " + b.getFileName());
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else {
			b.setFileName(null);
		}
		try {
			int res = boardService.getWrite(b);
			if(res == 1) {
				redatt.addFlashAttribute("msg","suc");
				redatt.addFlashAttribute("msg", "write_ok");
						
				return "redirect:/board/"+b.getMovieType();
			}else {
				throw new Exception("board write error");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("msg","error");
			model.addAttribute("model", model);
			
			return "imrwnBoard/Write?movieType="+b.getMovieType();
		}
	}
	@GetMapping("/modify")
	public String update(Integer bno, Model model, HttpSession session) {
		
		try {
			Board b = boardService.getBoard(bno);
			model.addAttribute("b", b);
			String content = b.getContent().replace("<br>", System.lineSeparator());
			b.setContent(content);

			System.out.println("수정 b " + b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "imrwnBoard/Update";
	}
	@PostMapping("/modify")
	public String updateBoard(Integer del, MultipartFile[] uploadFile, Board b, HttpSession session, RedirectAttributes redatt, Model model) {
		String writer = session.getAttribute("id") + "";
		b.setWriter(writer);
		String content = b.getContent().replace("\r\n", "<br>");
		b.setContent(content);


		System.out.println("수정 모드 : " + del);
		
		//String uploadFolder = "E:\\code\\MyBatisProject2\\src\\main\\webapp\\resources";
		String uploadFolder = session.getServletContext().getRealPath("/")+"\\resources";
		System.out.println("업로드 폴더 : " + uploadFolder);
		
		//기존의 파일 이름 정보 가져오기
		Board oldB = null;
		try {
			oldB = boardService.getRead(b.getBno());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//파일은 수정 x
		if( del == 0 ) {
			b.setFileName(oldB.getFileName());
		}
		//삭제
		else if (del == 2) {
			java.io.File delFile = new java.io.File(uploadFolder, b.getFileName());
			if(delFile.exists()) delFile.delete();
			b.setFileName(null);
		}
		else {
			if(oldB.getFileName() != null) {
				java.io.File delFile = new java.io.File(uploadFolder, oldB.getFileName());
				System.out.println("기존 파일 삭제 : " + delFile);
				if(delFile.exists()) delFile.delete();
			}
			for(MultipartFile multipartFile : uploadFile) {
				String uploadFileName = multipartFile.getOriginalFilename();
				uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("//") + 1);
				
				UUID uuid = UUID.randomUUID();
				uploadFileName = uuid.toString() + "-" + uploadFileName;
				System.out.println("변환 후 파일 이름 " + uploadFileName);
				
				//자바에서 파일에 접근할 수 있도록 객체 타입 선언
				java.io.File saveFile = new java.io.File(uploadFolder, uploadFileName);
				
				try {
					multipartFile.transferTo(saveFile);
					b.setFileName(uploadFileName);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("수정 post " + b);
		
		try {
			int res = boardService.getModify(b);
			
			if (res == 1) {
				redatt.addAttribute("bno", b.getBno());
				redatt.addFlashAttribute("msg", "modify_of");

			
				return "redirect:/board/read?bno="+b.getBno();
			} else {
				throw new Exception("board write error");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("msg","error");
			model.addAttribute("b", b);
			model.addAttribute("bno", b.getBno());
			return "imrwnBoard/Update";
		}
		
	}
}
