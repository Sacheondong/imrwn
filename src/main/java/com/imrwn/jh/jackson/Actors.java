package com.imrwn.jh.jackson;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown =true) 
public class Actors {
	private Actor[] actor;

	public Actor[] getActor() {
		return actor;
	}


	public void setActor(Actor[] actor) {
		this.actor = actor;
	}


	@Override
	public String toString() {
		return Arrays.toString(actor);
	}



	
}
