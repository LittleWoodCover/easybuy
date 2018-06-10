package ServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import utils.DatabaseUtil;
import Service.CategoryService;
import dao.CategoryDao;
import dao.ProductDao;
import daoImpl.CategoryDaoImpl;
import daoImpl.ProductDaoImpl;
import entity.Category;
import entity.CategoryPage;



public class CategoryServiceImpl implements CategoryService {
	CategoryDao categorydao;
	Connection conn;
	@Override
	public CategoryPage getCategoryBypage(int currpage, int pagesize) {
		// TODO Auto-generated method stub
		CategoryPage page = new CategoryPage();
		try {
			conn = DatabaseUtil.getConnection();
			categorydao=new CategoryDaoImpl(conn);
			page.setCurrPageNo(currpage);
			page.setPageSize(pagesize);
			int count=categorydao.getAllCategoryCount();
			page.setTotalCount(count);
			List<Category> list=categorydao.getCategoryBypage(currpage, pagesize);
			page.setNewslist(list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeAll(conn, null, null);
		}
		return page;
	}

	@Override
	public Category findCategoryByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNameById(int id) {
		// TODO Auto-generated method stub
		try {
			conn = DatabaseUtil.getConnection();
			categorydao=new CategoryDaoImpl(conn);
			Category category=categorydao.findCategoryByid(id);
			if(category!=null){
				return category.getName();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeAll(conn, null, null);
		}
		return null;
	}

	@Override
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCategory(int id) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			conn = DatabaseUtil.getConnection();
			categorydao=new CategoryDaoImpl(conn);
			ProductDao productdao=new ProductDaoImpl(conn);
			conn.setAutoCommit(false);
			//判断此分类下是否有子分类
			Category category=categorydao.getcategoryByParentId(id);
			int num=productdao.getProductCountByFenlei(id);
			if(category==null){
				if(num==0){
					result= categorydao.deleteCategory(id);
				}else{
					result=-2;//此分类下有商品
				}
				
			}else{
				result=-1;//有子分类
			}
			conn.commit();
		} catch (Exception e) {
			// TODO: handle exception
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			DatabaseUtil.closeAll(conn, null, null);
		}
		return result;
	}

	@Override
	public int addCategory(Category category) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			conn = DatabaseUtil.getConnection();
			conn.setAutoCommit(false);
			categorydao=new CategoryDaoImpl(conn);
			result=categorydao.addCategory(category);
			conn.commit();
		} catch (Exception e) {
			// TODO: handle exception
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeAll(conn, null, null);
		}
		return result;
	}
	@Override
	public int categoryName(String name) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			conn = DatabaseUtil.getConnection();
			categorydao=new CategoryDaoImpl(conn);
			Category category=categorydao.categoryName(name);
			if(category!=null){
				result=1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeAll(conn, null, null);
		}
		return result;
	}

	@Override
	public List<Category> getCategoryByType(int type) {
		// TODO Auto-generated method stub
		List<Category> list=null;
		try {
			conn = DatabaseUtil.getConnection();
			categorydao=new CategoryDaoImpl(conn);
			list=categorydao.getCategoryByType(type);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeAll(conn, null, null);
		}
		return list;
	}

	@Override
	public List<Category> getCatelistByParentId(int parentId) {
		// TODO Auto-generated method stub
		List<Category> list=null;
		try {
			conn = DatabaseUtil.getConnection();
			categorydao=new CategoryDaoImpl(conn);
			list=categorydao.getCatelistByParentId(parentId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeAll(conn, null, null);
		}
		return list;
	}

}
