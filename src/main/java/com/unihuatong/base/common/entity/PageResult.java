package com.unihuatong.base.common.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Description 分页返回结果
 * @author 戚兆宇
 * @date 2017年2月28日 下午2:46:07
 */
public class PageResult implements Serializable {

	private static final long serialVersionUID = -5355670416924413177L;

	private int pageNo = 1;// 请求页数
	private int pageSize = 10;// 每页数量
	private long totalCount = 0; // 返回总计
	private long totalPageNum = 0; // 一共页数
	private List<Object> result;// 返回集合

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public long getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(long totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public List<Object> getResult() {
		return result;
	}

	public void setResult(List<Object> result) {
		this.result = result;
	}

}
