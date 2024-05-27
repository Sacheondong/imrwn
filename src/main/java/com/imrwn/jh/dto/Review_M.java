package com.imrwn.jh.dto;

import java.util.Date;
import java.util.Objects;

public class Review_M {
	private Integer rno;
	private Integer mno;
	private String review;
	private String reviewer;
	private Date regDate;
	private String nickName;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getRno() {
		return rno;
	}

	public void setRno(Integer rno) {
		this.rno = rno;
	}

	public Integer getMno() {
		return mno;
	}

	public void setMno(Integer mno) {
		this.mno = mno;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getreviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Review_M() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review_M(Integer mno, String review, String reviewer) {
		super();
		this.mno = mno;
		this.review = review;
		this.reviewer = reviewer;
	}

	@Override
	public String toString() {
		return "Riview_M [rno=" + rno + ", mno=" + mno + ", review=" + review + ", reviewer=" + reviewer + ", regDate="
				+ regDate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(mno, reviewer, review, rno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review_M other = (Review_M) obj;
		return Objects.equals(mno, other.mno) && Objects.equals(reviewer, other.reviewer)
				&& Objects.equals(review, other.review) && Objects.equals(rno, other.rno);
	}

}
