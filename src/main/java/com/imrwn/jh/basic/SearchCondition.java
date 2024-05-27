package com.imrwn.jh.basic;

import org.springframework.web.util.UriComponentsBuilder;

public class SearchCondition {
	private Integer page = 1;
	private Integer pageSize = 10;
	private String keyword = "";
	private String option;
	private String movieType;
	
	
	
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	// offset ����� ��ȯ�ϴ� �Լ�
	public Integer getOffset() {
		return (page-1)*pageSize;
	}
	
	//�������� ��� �ۼ��ϱ⿡�� ������ ���� �����Ƿ� �Լ��� ����
	public String getQueryString(Integer page) {
		if("".equals(keyword))
			return UriComponentsBuilder.newInstance()
				.queryParam("page",page)
				.queryParam("pageSize",pageSize)
				.build().toString();
			
		return UriComponentsBuilder.newInstance()
				.queryParam("page",page)
				.queryParam("pageSize",pageSize)
				.queryParam("option", option)
				.queryParam("keyword", keyword)
				.build().toString();
			
	}
	public String getQueryString() {
		return getQueryString(page);
	}

	public SearchCondition(Integer page, Integer pageSize, String keyword, String option, String movieType) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.keyword = keyword;
		this.option = option;
		this.movieType = movieType;
	}
	public SearchCondition() {}
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	@Override
	public String toString() {
		return "SearchCondition [page=" + page + ", pageSize=" + pageSize + ", keyword=" + keyword + ", option="
				+ option + ", movieType=" + movieType + "]";
	}
	


	
}
