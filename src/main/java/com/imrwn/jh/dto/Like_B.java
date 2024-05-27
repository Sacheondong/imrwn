package com.imrwn.jh.dto;

import java.util.Objects;

public class Like_B {
	private Integer lno;
	private String id;
	private Integer bno;

	public Integer getLno() {
		return lno;
	}

	public void setLno(Integer lno) {
		this.lno = lno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getBno() {
		return bno;
	}

	public void setBno(Integer bno) {
		this.bno = bno;
	}

	public Like_B() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Like_B(String id, Integer bno) {
		super();
		this.id = id;
		this.bno = bno;
	}

	@Override
	public String toString() {
		return "Like_B [lno=" + lno + ", id=" + id + ", bno=" + bno + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bno, id, lno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Like_B other = (Like_B) obj;
		return Objects.equals(bno, other.bno) && Objects.equals(id, other.id) && Objects.equals(lno, other.lno);
	}

}
