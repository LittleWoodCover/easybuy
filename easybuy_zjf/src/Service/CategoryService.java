package Service;

import java.util.List;

import entity.Category;
import entity.CategoryPage;


public interface CategoryService {
		//��ѯÿ��ҳ��ķ���
	   public CategoryPage getCategoryBypage(int currpage,int pagesize);
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
	   public int categoryName(String name);
	 //����type�����
	   public List<Category> getCategoryByType(int type);
	   //���ݸ����������б�
	   public List<Category> getCatelistByParentId(int parentId);
}
