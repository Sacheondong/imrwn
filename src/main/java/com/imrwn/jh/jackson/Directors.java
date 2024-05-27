package com.imrwn.jh.jackson;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown =true) 
public class Directors {
	private Director[] director;

	public Director[] getDirector() {
		return director;
	}
	public void setDirector(Director[] director) {
		this.director = director;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(director);
	}



}
