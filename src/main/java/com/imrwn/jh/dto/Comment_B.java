package com.imrwn.jh.dto;

import java.util.Date;
import java.util.Objects;

public class Comment_B {
	private Integer cno;
	private Integer bno;
	private String comment;
	private String commenter;
	private Date regDate;
	private String nickName;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getCno() {
		return cno;
	}

	public void setCno(Integer cno) {
		this.cno = cno;
	}

	public Integer getBno() {
		return bno;
	}

	public void setBno(Integer bno) {
		this.bno = bno;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommenter() {
		return commenter;
	}

	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Comment_B() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment_B(Integer bno, String comment, String commenter) {
		super();
		this.bno = bno;
		this.comment = comment;
		this.commenter = commenter;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bno, cno, comment, commenter);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment_B other = (Comment_B) obj;
		return Objects.equals(bno, other.bno) && Objects.equals(cno, other.cno)
				&& Objects.equals(comment, other.comment) && Objects.equals(commenter, other.commenter);
	}

	@Override
	public String toString() {
		return "Comment_B [cno=" + cno + ", bno=" + bno + ", comment=" + comment + ", commenter=" + commenter
				+ ", regDate=" + regDate + "]";
	}

}
