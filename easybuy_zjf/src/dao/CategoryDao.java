package dao;

import java.util.List;

import entity.Category;



public interface CategoryDao {
		//��ѯ������Ŀ
	   public int getAllCategoryCount();
		//��ѯÿ��ҳ��ķ���
	   public List<Category> getCategoryBypage(int currpage,int pagesize);
	   //����ID�����
	   public Category findCategoryByid(int id);
	   //����ID������
	   public String getNameById(int id);
	   //�޸ķ�����Ϣ
	   public int updateCategory(Category category);
	   //ɾ��������Ϣ
	   public int deleteCategory(int id);
	   //��ӷ�����Ϣ
	   public int addCategory(Category category);
	   //��ѯ�������Ƿ����
	   public Category categoryName(String name);
	   //��ѯ�������Ƿ����
	   public Category getcategoryByParentId(int parentId);
	   //����type�����
	   public List<Category> getCategoryByType(int type);
	   //���ݸ����������б�
	   public List<Category> getCatelistByParentId(int parentId);
}
