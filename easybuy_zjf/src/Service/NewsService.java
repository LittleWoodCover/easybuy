/**
 * 
 */
package Service;

import java.util.List;

import entity.News;
import entity.Page;

/**
 * @author LENOVO
 *
 */
public interface NewsService {
	//查询前5条新闻
	   public List<News> findNews(int limit);
	   //查询新闻数目
	   public int getAllNewsCount();
		//查询每个页面的新闻
	   public Page getNewsBypage(int currpage,int pagesize);
	   //根据ID查新闻
	   public News findNewsByid(int id);
}
