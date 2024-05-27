package com.imrwn.jh.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown =true) 
public class Director {
	private String directorNm;
	private String directorEnNm;
	
	public String getDirectorNm() {
		return directorNm;
	}
	public void setDirectorNm(String directorNm) {
		this.directorNm = directorNm;
	}
	public String getDirectorEnNm() {
		return directorEnNm;
	}
	public void setDirectorEnNm(String directorEnNm) {
		this.directorEnNm = directorEnNm;
	}
	
	@Override
	public String toString() {
		return "[directorNm=" + directorNm + ", directorEnNm=" + directorEnNm + "]";
	}


}
