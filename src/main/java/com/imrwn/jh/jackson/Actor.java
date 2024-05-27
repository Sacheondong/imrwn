package com.imrwn.jh.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown =true) 
public class Actor {	
	private String actorNm;
	private String actorEnNm;

	public String getActorEnNm() {
		return actorEnNm;
	}
	public void setActorEnNm(String actorEnNm) {
		this.actorEnNm = actorEnNm;
	}
	public String getActorNm() {
		return actorNm;
	}
	public void setActorNm(String actorNm) {
		this.actorNm = actorNm;
	}
	@Override
	public String toString() {
		return "[actorNm=" + actorNm + ", actorEnNm=" + actorEnNm + "]";
	}

}
