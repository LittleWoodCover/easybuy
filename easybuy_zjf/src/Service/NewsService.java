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
	//��ѯǰ5������
	   public List<News> findNews(int limit);
	   //��ѯ������Ŀ
	   public int getAllNewsCount();
		//��ѯÿ��ҳ�������
	   public Page getNewsBypage(int currpage,int pagesize);
	   //����ID������
	   public News findNewsByid(int id);
}
