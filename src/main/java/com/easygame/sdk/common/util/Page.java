package com.easygame.sdk.common.util;

/** 分页数据类 */
public class Page {

	/** 每页显示数 */
	private int pageSize = 20;

	/** 当前页 */
	private int currentPage = 1;

	/** 开始行数 */
	private int startRow = 0;

	/** 前一页 */
	private int prePage = 1;

	/** 下一页 */
	private int nextPage = 1;

	/** 总数 */
	private int totalCount = 0;

	/** 总页数 */
	private int totalPage = 1;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		startRow = (this.currentPage - 1) * pageSize;
		prePage = currentPage <= 1 ? 1 : currentPage - 1;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		startRow = (this.currentPage - 1) * pageSize;
		prePage = currentPage <= 1 ? 1 : currentPage - 1;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.totalPage = this.totalCount / pageSize + ((this.totalCount % pageSize > 0) ? 1 : 0);
		nextPage = totalPage > currentPage ? currentPage + 1 : totalPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String toString() {
		return getCurrentPage() + "/" + getPageSize();
	}

}