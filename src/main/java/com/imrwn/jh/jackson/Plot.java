package com.imrwn.jh.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown =true) 
public class Plot {
	private String plotLang;
	private String plotText;
	
	
	public String getPlotLang() {
		return plotLang;
	}
	public void setPlotLang(String plotLang) {
		this.plotLang = plotLang;
	}
	public String getPlotText() {
		return plotText;
	}
	public void setPlotText(String plotText) {
		this.plotText = plotText;
	}
	@Override
	public String toString() {
		return "Plot [plotLang=" + plotLang + ", plotText=" + plotText + "]";
	}
	
	
}
