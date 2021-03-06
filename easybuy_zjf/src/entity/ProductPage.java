/**
 * 
 */
package entity;

import java.util.List;

/**
 * @author LENOVO
 *
 */
public class ProductPage {
	private int currPageNo;//当前页
	private int pageSize;//页容量
	private int totalCount;//用户总数
	private int totalPageCount;//页总数
	private List<Product> newslist;//当前页商品集合
	public int getCurrPageNo() {
		return currPageNo;
	}
	public void setCurrPageNo(int currPageNo) {
		this.currPageNo = currPageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		if(totalCount>0){
			if(this.totalCount%this.pageSize==0){
				totalPageCount=this.totalCount/this.pageSize;	
			}else{
				totalPageCount=this.totalCount/this.pageSize+1;
			}	
		}				
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public List<Product> getNewslist() {
		return newslist;
	}
	public void setNewslist(List<Product> newslist) {
		this.newslist = newslist;
	}
	
	
}
