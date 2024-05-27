package com.imrwn.jh.dto;

import java.util.Date;

public class File {
	private Integer fno;
	private String content;
	private String fileName;
	private String writer;
	private Date regDate;
	
	
	
	@Override
	public String toString() {
		return "File [fno=" + fno + ", content=" + content + ", fileName=" + fileName + ", writer=" + writer
				+ ", regDate=" + regDate + "]";
	}
	public File() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getFno() {
		return fno;
	}
	public void setFno(Integer fno) {
		this.fno = fno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
