package com.imrwn.jh.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown =true) 
public class Movie {
	private Integer mno;
	private String title;
	private String titleEng;
	private String directors;
	private String actors;
	private String posters;
	private String plots;
	private int runtime;
	private int movieLikeCnt;
	private int movieReviewCnt;
	private String repRlsDate; 
	private String genre;
	private float avg;
	
	
	

	public float getAvg() {
		return avg;
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getMovieLikeCnt() {
		return movieLikeCnt;
	}

	public void setMovieLikeCnt(int movieLikeCnt) {
		this.movieLikeCnt = movieLikeCnt;
	}

	public int getMovieReviewCnt() {
		return movieReviewCnt;
	}

	public void setMovieReviewCnt(int movieReviewCnt) {
		this.movieReviewCnt = movieReviewCnt;
	}

	public Integer getMno() {
		return mno;
	}

	public void setMno(Integer mno) {
		this.mno = mno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleEng() {
		return titleEng;
	}

	public void setTitleEng(String titleEng) {
		this.titleEng = titleEng;
	}

	public String getDirectors() {
		return directors.toString();
	}

	public void setDirectors(String directors) {
		this.directors = directors;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getPosters() {
		return posters;
	}

	public void setPosters(String posters) {
		this.posters = posters;
	}

	public String getPlots() {
		return plots;
	}

	public void setPlots(String plots) {
		this.plots = plots;
	}

	public String getRepRlsDate() {
		if(repRlsDate == null || repRlsDate.length()==0 ) {
			return null;
		}else if (repRlsDate.length() >= 9) {
			return repRlsDate;
		}
		return repRlsDate.substring(0,4) + "-" + repRlsDate.substring(4,6) + "-" + repRlsDate.substring(6);
	}

	public void setRepRlsDate(String repRlsDate) {
		this.repRlsDate = repRlsDate;
	}


	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String title, String titleEng, String directors, String actors, String posters, String plots) {
		super();
		this.title = title;
		this.titleEng = titleEng;
		this.directors = directors;
		this.actors = actors;
		this.posters = posters;
		this.plots = plots;
	}

	@Override
	public String toString() {
		return "Movie [mno=" + mno + ", title=" + title + ", titleEng=" + titleEng + ", directors=" + directors
				+ ", actors=" + actors + ", posters=" + posters + ", plots=" + plots + ", runtime=" + runtime
				+ ", movieLikeCnt=" + movieLikeCnt + ", movieReviewCnt=" + movieReviewCnt + ", repRlsDate=" + repRlsDate
				+ ", genre=" + genre + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(actors, directors, mno, plots, posters, title, titleEng);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(actors, other.actors) && Objects.equals(directors, other.directors)
				&& Objects.equals(mno, other.mno) && Objects.equals(plots, other.plots)
				&& Objects.equals(posters, other.posters) && Objects.equals(title, other.title)
				&& Objects.equals(titleEng, other.titleEng);
	}

	

}
