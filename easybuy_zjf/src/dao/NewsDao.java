package dao;

import java.util.List;

import entity.News;

public interface NewsDao {
	//��ѯǰ5������
   public List<News> findNews(int limit);
   //��ѯ������Ŀ
   public int getAllNewsCount();
	//��ѯÿ��ҳ�������
   public List<News> getNewsBypage(int currpage,int pagesize);
   //����ID������
   public News findNewsByid(int id);
}
