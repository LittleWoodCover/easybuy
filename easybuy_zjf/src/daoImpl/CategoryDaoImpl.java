package daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.DatabaseUtil;
import dao.BaseDao;
import dao.CategoryDao;
import entity.Category;




public class CategoryDaoImpl extends BaseDao implements CategoryDao {

	public CategoryDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getAllCategoryCount() {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		int result = 0;
		String sql = "SELECT COUNT(1) FROM easybuy_product_category ";
		try {
			rs = this.executeQuery(sql);
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeAll(null, null, rs);
		}
		return result;
	}

	@Override
	public List<Category> getCategoryBypage(int currpage, int pagesize) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		List<Category> list = new ArrayList<Category>();
		String sql = "SELECT id,name,parentId,type FROM easybuy_product_category LIMIT ?,?";
		Object[] obj = { (currpage - 1) * pagesize, pagesize };
		try {
			rs = this.executeQuery(sql, obj);
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setParentId(rs.getInt("parentId"));
				String parentName=null;
				if(category.getParentId()==0){
					parentName="нч";
				}else{
					parentName=this.getNameById(category.getParentId());
				}				 
				category.setParentName(parentName);
				category.setType(rs.getInt("type"));
				list.add(category);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeAll(null, null, rs);
		}
		return list;
	}

	@Override
	public Category findCategoryByid(int id) {
		// TODO Auto-generated method stub
		 String sql = "select * from easybuy_product_category where id=?";
	        ResultSet rs = null;
	        Category category = null;
	        try {
	            rs = executeQuery(sql, id);
	            if (rs.next()) {
	            	category = new Category();
	            	category.setId(rs.getInt("id"));
					category.setName(rs.getString("name"));
					category.setParentId(rs.getInt("parentId"));
					category.setType(rs.getInt("type"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	DatabaseUtil.closeAll(null, null, rs);
	        }
	        return category;
	}

	@Override
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCategory(int id) {
		// TODO Auto-generated method stub
		 String sql = "DELETE FROM easybuy_product_category WHERE `id` = ?";
	        int result = 0;
	        try {
	            result = executeUpdate(sql,id);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	        return result;
	}

	@Override
	public int addCategory(Category category) {
		// TODO Auto-generated method stub
		 String sql = "INSERT INTO easybuy_product_category(name,parentId,TYPE) VALUES(?,?,?)";
		 Object[] obj={category.getName(),category.getParentId(),category.getType()};
	        int result = 0;
	        try {
	            result = executeUpdate(sql,obj);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	        return result;
	}

	@Override
	public Category categoryName(String name) {
		// TODO Auto-generated method stub
		 String sql = "select * from easybuy_product_category where name=?";
	        ResultSet rs = null;
	        Category category = null;
	        try {
	            rs = executeQuery(sql, name);
	            if (rs.next()) {
	            	category = new Category();
	            	category.setId(rs.getInt("id"));
					category.setName(rs.getString("name"));
					category.setParentId(rs.getInt("parentId"));
					category.setType(rs.getInt("type"));
	            }	         
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	DatabaseUtil.closeAll(null, null, rs);
	        }
	        return category;
	}

	@Override
	public String getNameById(int id) {
		 String sql = "select * from easybuy_product_category where id=?";
	        ResultSet rs = null;
	        Category category = null;
	        try {
	            rs = executeQuery(sql, id);
	            if (rs.next()) {
	            	category = new Category();
	            	category.setId(rs.getInt("id"));
					category.setName(rs.getString("name"));
					category.setParentId(rs.getInt("parentId"));
					category.setType(rs.getInt("type"));
	            }	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	DatabaseUtil.closeAll(null, null, rs);
	        }
	        return category.getName();
	}

	@Override
	public Category getcategoryByParentId(int parentId) {
		// TODO Auto-generated method stub
		String sql = "select * from easybuy_product_category where parentId=?";
        ResultSet rs = null;
        Category category = null;
        try {
            rs = executeQuery(sql, parentId);
            if (rs.next()) {
            	category = new Category();
            	category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setParentId(rs.getInt("parentId"));
				category.setType(rs.getInt("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	DatabaseUtil.closeAll(null, null, rs);
        }
        return category;
	}

	@Override
	public List<Category> getCategoryByType(int type) {
		// TODO Auto-generated method stub
		String sql = "select * from easybuy_product_category where type=?";
        ResultSet rs = null;
        Category category = null;
        List<Category> list=new ArrayList<Category>();
        try {
            rs = executeQuery(sql, type);
            while (rs.next()) {
            	category = new Category();
            	category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setParentId(rs.getInt("parentId"));
				category.setType(rs.getInt("type"));
				list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	DatabaseUtil.closeAll(null, null, rs);
        }
        return list;
	}

	@Override
	public List<Category> getCatelistByParentId(int parentId) {
		// TODO Auto-generated method stub
		String sql = "select * from easybuy_product_category where parentId=?";
        ResultSet rs = null;
        Category category = null;
        List<Category> list=new ArrayList<Category>();
        try {
            rs = executeQuery(sql, parentId);
            while (rs.next()) {
            	category = new Category();
            	category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setParentId(rs.getInt("parentId"));
				category.setType(rs.getInt("type"));
				list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	DatabaseUtil.closeAll(null, null, rs);
        }
        return list;
	}

}
