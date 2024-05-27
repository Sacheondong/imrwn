package com.imrwn.jh.dto;

import java.util.Date;
import java.util.Objects;

public class Board {
	private Integer bno;
	private String title;
	private String content;
	private String writer;
	private Date postDate;
	private int viewCnt;
	private int commentCnt;
	private int likeCnt;
	private String movieType;
	private String nickName;
	private String fileName;
	
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public int getCommentCnt() {
		return commentCnt;
	}
	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}
	public int getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board(String title, String content, String writer, String movieType) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.movieType = movieType;
	}
	@Override
	public String toString() {
		return "Board [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", postDate="
				+ postDate + ", viewCnt=" + viewCnt + ", commentCnt=" + commentCnt + ", likeCnt=" + likeCnt
				+ ", movieType=" + movieType + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(bno, commentCnt, content, likeCnt, movieType, title, viewCnt, writer);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		return Objects.equals(bno, other.bno) && commentCnt == other.commentCnt
				&& Objects.equals(content, other.content) && likeCnt == other.likeCnt
				&& Objects.equals(movieType, other.movieType) && Objects.equals(title, other.title)
				&& viewCnt == other.viewCnt && Objects.equals(writer, other.writer);
	}
	


}
