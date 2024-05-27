package com.imrwn.jh.basic;

public class PageHandler {
	// Integer page, Integer pageSize�� SearchCondition���� ó��
	private SearchCondition sc;

	private int totalCnt; // �� �Խù� ����
	private int naviSize = 10; // ������ �׺���̼��� ũ��
	private int totalPage; // ��ü �������� ����

	private int beginPage; // �׺���̼��� ù��° ������
	private int endPage; // �׺���̼��� ������ ������
	private boolean showPrev; // ���� �������� �̵��ϴ� ��ũ�� ������ �������� ����
	private boolean showNext; // ���� �������� �̵��ϴ� ��ũ�� ������ �������� ����

	public PageHandler(int totalCnt, SearchCondition sc) {
		this.totalCnt = totalCnt;
		this.sc = sc;
		doPaging(totalCnt, sc);
	}

	// �����ڿ��� �޼ҵ�� ����
	public void doPaging(int totalCnt, SearchCondition sc) {
		this.totalCnt = totalCnt;
		totalPage = (int) Math.ceil(totalCnt / (double) sc.getPageSize()); // �ø�
		beginPage = (sc.getPage() - 1) / naviSize * naviSize + 1;
		endPage = Math.min(beginPage + naviSize - 1, totalPage);
		showPrev = beginPage != 1;
		showNext = endPage != totalPage;
	}

	void print() {
		System.out.println("page =" + sc.getPage());
		System.out.print(showPrev ? "< " : "");
		for (int i = beginPage; i <= endPage; i++) {
			System.out.print(i + " ");
		}
		System.out.println(showNext ? ">" : "");
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public int getNaviSize() {
		return naviSize;
	}

	public void setNaviSize(int naviSize) {
		this.naviSize = naviSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public SearchCondition getSc() {
		return sc;
	}

	public void setSc(SearchCondition sc) {
		this.sc = sc;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isShowPrev() {
		return showPrev;
	}

	public void setShowPrev(boolean showPrev) {
		this.showPrev = showPrev;
	}

	public boolean isShowNext() {
		return showNext;
	}

	public void setShowNext(boolean showNext) {
		this.showNext = showNext;
	}

	// toString���� ����
	@Override
	public String toString() {
		return "PageHandler [sc=" + sc + ", totalCnt=" + totalCnt + ", naviSize=" + naviSize + ", totalPage="
				+ totalPage + ", beginPage=" + beginPage + ", endPage=" + endPage + ", showPrev=" + showPrev
				+ ", showNext=" + showNext + "]";
	}
}
