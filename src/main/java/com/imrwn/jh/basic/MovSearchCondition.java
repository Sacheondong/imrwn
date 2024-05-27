package com.imrwn.jh.basic;

import org.springframework.web.util.UriComponentsBuilder;

public class MovSearchCondition {
	private Integer page = 1;
	private Integer pageSize = 24;
	private String searchWord = "";
	
	
	

	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
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
		if("".equals(searchWord))
			return UriComponentsBuilder.newInstance()
				.queryParam("page",page)
				.queryParam("pageSize",pageSize)
				.build().toString();
			
		return UriComponentsBuilder.newInstance()
				.queryParam("page",page)
				.queryParam("pageSize",pageSize)
				.queryParam("searchWord", searchWord)
				.build().toString();
			
	}
	public String getQueryString() {
		return getQueryString(page);
	}

	public MovSearchCondition(Integer page, Integer pageSize, String searchWord) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.searchWord = searchWord;

	}
	public MovSearchCondition() {}
	

	@Override
	public String toString() {
		return "MovSearchCondition [page=" + page + ", pageSize=" + pageSize + ", searchWord=" + searchWord + "]";
	}
	


	
}
