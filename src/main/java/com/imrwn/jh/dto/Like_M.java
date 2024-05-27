package com.imrwn.jh.dto;

import java.util.Objects;

public class Like_M {
	private Integer lno;
	private Integer mno;
	private String id;
	private int good;
	private float score;
	private float avg;
	
	

	public float getAvg() {
		return avg;
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}

	public Integer getLno() {
		return lno;
	}

	public void setLno(Integer lno) {
		this.lno = lno;
	}

	public Integer getMno() {
		return mno;
	}

	public void setMno(Integer mno) {
		this.mno = mno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public Like_M() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Like_M(Integer mno, String id, int good, float score) {
		super();
		this.mno = mno;
		this.id = id;
		this.good = good;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Like_M [lno=" + lno + ", mno=" + mno + ", id=" + id + ", good=" + good + ", score=" + score + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, good, lno, mno, score);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Like_M other = (Like_M) obj;
		return Objects.equals(id, other.id) && good == other.good && Objects.equals(lno, other.lno)
				&& Objects.equals(mno, other.mno) && score == other.score;
	}

}
