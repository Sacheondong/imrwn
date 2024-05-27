package com.imrwn.jh.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.imrwn.jh.dao.FileDao;
import com.imrwn.jh.dto.File;

@Controller
@RequestMapping("/file")
public class FileController {
	@Autowired
	FileDao fileDao;
	
	@GetMapping("/write")
	public String write(Model model) {
		return "/Files/file";
	}
	@GetMapping("/view")
	public String fileView(Model model, Integer fno) {
		try {
			File f = fileDao.select(fno);
			model.addAttribute("f", f);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/Files/FileView";
	}
	
	@PostMapping("/write")
	public String save(Integer fileEx, File f, MultipartFile[] uploadFile, Model model, HttpSession session, RedirectAttributes reatt) {
		//글쓴이 정보를 , 현재 로그인하고 있는 id 값으로 저장해야 함
		String writer = session.getAttribute("id") + "";
		f.setWriter(writer);
		System.out.println("f : " + f);
		System.out.println("업로드 여부 확인 : " + fileEx);
		//jsp에서 img 출력할 때는 resource 폴더에 있는 것처럼 사용
		String uploadFolder = session.getServletContext().getRealPath("/resources");
		System.out.println("uploadFolder : " + uploadFolder);
		
		System.out.println("업로드 파일 이름 : " + f.getFileName());
		
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
					f.setFileName(uploadFileName);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else {
			f.setFileName(null);
		}
		try {
			int rowCnt = fileDao.insert(f);
			if(rowCnt != 1) throw new Exception("Write Error");
			System.out.println(f);
			reatt.addFlashAttribute("msg", "write_ok");
			
			return "redirect:/file/view";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("msg", "write_error");
			model.addAttribute("mode","new");
			
			return "redirect:/file/write";
		}
	}
	
	@PostMapping("/modify")
	public String modify(Integer del, MultipartFile[] uploadFile, RedirectAttributes reatt, File f, Model model, HttpSession session) {
		String writer = session.getAttribute("id") + "";
		f.setWriter(writer);
		System.out.println("수정 모드 : " + del);
		
		//String uploadFolder = "E:\\code\\MyBatisProject2\\src\\main\\webapp\\resources";
		String uploadFolder = session.getServletContext().getRealPath("/")+"\\resource";
		System.out.println("업로드 폴더 : " + uploadFolder);
		
		String str = "";
		
		//기존의 파일 이름 정보 가져오기
		File oldF = null;
		try {
			oldF = fileDao.select(f.getFno());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//파일은 수정 x
		if( del == 0 ) {
			f.setFileName(oldF.getFileName());
		}
		//삭제
		else if (del == 2) {
			java.io.File delFile = new java.io.File(uploadFolder, f.getFileName());
			if(delFile.exists()) delFile.delete();
			f.setFileName(null);
		}
		else {
			if(oldF.getFileName() != null) {
				java.io.File delFile = new java.io.File(uploadFolder, oldF.getFileName());
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
					f.setFileName(uploadFileName);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("수정 post " + f);
		
		try {
			int rowCnt = fileDao.update(f);
			if (rowCnt != 1) throw new Exception("modift Error");
			reatt.addFlashAttribute("msg", "modify_of");

			return "redirect:/file/view?fno="+f.getFno();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return "redirect:/file/modify?fno="+f.getFno();
		}
	}
	
	@GetMapping("modify")
	public String modi(Integer fno, File f, Model model, HttpSession session) {
		String writer = session.getAttribute("id") + "";
		f.setWriter(writer);
		
		try {
			f = fileDao.select(fno);
			model.addAttribute("f", f);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("수정 f " + f);
		
		return "/Files/FileEdit";
	}
	@PostMapping("/remove")
	public String remove(File oldF, Model model, HttpSession session, RedirectAttributes reatt) {
		System.out.println("oldF : " + oldF);
		try {
			int rowCnt = 0;
			
			String writer = session.getAttribute("id") + "";
			rowCnt = fileDao.delete(oldF.getFno(), writer);
	
			String uploadFolder = session.getServletContext().getRealPath("/")+"\\resources";
			if (rowCnt == 1) {
				if(oldF.getFileName() != null) {
					java.io.File delFile = new java.io.File(uploadFolder, oldF.getFileName());
					System.out.println("기존 파일 삭제 " + delFile);
					if (delFile.exists()) delFile.delete();
				}
				return "redirect:/file/write";
			}else {
				throw new Exception("board remove Error");
			}
		} catch (Exception e) {
			e.printStackTrace();
			reatt.addFlashAttribute("msg","error");
		}
		return "redirect:/file/view?fno=" + oldF.getFno();
	}
	
}
