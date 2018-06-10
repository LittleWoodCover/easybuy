package daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.DatabaseUtil;
import dao.BaseDao;
import dao.ProductDao;
import entity.Product;
import entity.User;

public class ProductDaoImpl extends BaseDao implements ProductDao{

	public ProductDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getAllProductCount() {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		int result = 0;
		String sql = "SELECT COUNT(1) FROM easybuy_product ";
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
	public List<Product> getProductBypage(int currpage, int pagesize) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		List<Product> list = new ArrayList<Product>();
		String sql = "SELECT id,name,description,price,stock,categoryLevel1Id,categoryLevel2Id,categoryLevel3Id,fileName,isDelete FROM easybuy_product LIMIT ?,?";
		Object[] obj = { (currpage - 1) * pagesize, pagesize };
		try {
			rs = this.executeQuery(sql, obj);
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getInt("price"));
				product.setStock(rs.getInt("stock"));
				product.setCategoryLevel1Id(rs.getInt("categoryLevel1Id"));
				product.setCategoryLevel2Id(rs.getInt("categoryLevel2Id"));
				product.setCategoryLevel3Id(rs.getInt("categoryLevel3Id"));
				product.setFileName(rs.getString("fileName"));
				product.setIsDelete(rs.getInt("isDelete"));
				list.add(product);
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
	public Product findProductByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateProductr(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		 String sql = "DELETE FROM easybuy_product WHERE `id` = ?";
	        int result = 0;
	        try {
	            result = executeUpdate(sql,id);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	        return result;
	}

	@Override
	public Product productName(String name) {
		// TODO Auto-generated method stub
		 String sql = "select * from easybuy_product where name=?";
	        ResultSet rs = null;
	        Product product = null;
	        try {
	            rs = executeQuery(sql, name);
	            if (rs.next()) {
	            	product = new Product();
	            	product.setId(rs.getInt("id"));
	            	product.setName(rs.getString("name"));
	            }	         
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	DatabaseUtil.closeAll(null, null, rs);
	        }
	        return product;
	}

	@Override
	public int getProductCountByFenlei(int fenleiId) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		int result = 0;
		String sql = "SELECT COUNT(1) FROM `easybuy_product` WHERE categoryLevel1Id=? OR categoryLevel2Id=? OR categoryLevel3Id=?";
		try {
			rs = this.executeQuery(sql,fenleiId,fenleiId,fenleiId);
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

}
