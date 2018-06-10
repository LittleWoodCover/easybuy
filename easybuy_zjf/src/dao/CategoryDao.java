package dao;

import java.util.List;

import entity.Category;



public interface CategoryDao {
		//查询分类数目
	   public int getAllCategoryCount();
		//查询每个页面的分类
	   public List<Category> getCategoryBypage(int currpage,int pagesize);
	   //根据ID查分类
	   public Category findCategoryByid(int id);
	   //根据ID查名称
	   public String getNameById(int id);
	   //修改分类信息
	   public int updateCategory(Category category);
	   //删除分类信息
	   public int deleteCategory(int id);
	   //添加分类信息
	   public int addCategory(Category category);
	   //查询分类名是否存在
	   public Category categoryName(String name);
	   //查询分类名是否存在
	   public Category getcategoryByParentId(int parentId);
	   //根据type查分类
	   public List<Category> getCategoryByType(int type);
	   //根据父分类查分类列表
	   public List<Category> getCatelistByParentId(int parentId);
}
