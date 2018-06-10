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
	private int currPageNo;//��ǰҳ
	private int pageSize;//ҳ����
	private int totalCount;//�û�����
	private int totalPageCount;//ҳ����
	private List<Product> newslist;//��ǰҳ��Ʒ����
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