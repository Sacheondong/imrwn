package com.imrwn.jh.dto;

import java.util.Date;
import java.util.Objects;

public class Member {
	private String id;
	private String pwd;
	private String email;
	private Date regDate;
	private int movieCnt;
	private int movielikeCnt;
	private int movieScoreCnt;
	private String nickName;



	public int getMovieScoreCnt() {
		return movieScoreCnt;
	}

	public void setMovieScoreCnt(int movieScoreCnt) {
		this.movieScoreCnt = movieScoreCnt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getMovieCnt() {
		return movieCnt;
	}

	public void setMovieCnt(int movieCnt) {
		this.movieCnt = movieCnt;
	}

	public int getMovielikeCnt() {
		return movielikeCnt;
	}

	public void setMovielikeCnt(int movielikeCnt) {
		this.movielikeCnt = movielikeCnt;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String id, String pwd, String email) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", email=" + email + ", regDate=" + regDate + ", movieCnt="
				+ movieCnt + ", movielikeCnt=" + movielikeCnt + ", nickName=" + nickName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, movieCnt, movielikeCnt, nickName, pwd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(movieCnt, other.movieCnt)
				&& Objects.equals(movielikeCnt, other.movielikeCnt) && Objects.equals(nickName, other.nickName)
				&& Objects.equals(pwd, other.pwd);
	}

}
