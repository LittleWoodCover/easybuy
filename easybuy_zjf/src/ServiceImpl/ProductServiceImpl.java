package ServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.ProductDao;
import daoImpl.ProductDaoImpl;
import utils.DatabaseUtil;


import entity.Product;
import entity.ProductPage;
import Service.ProductService;

public class ProductServiceImpl implements ProductService{
	ProductDao productdao;
	Connection conn;
	@Override
	public int getAllProductCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProductPage getProductBypage(int currpage, int pagesize) {
		// TODO Auto-generated method stub
		ProductPage page = new ProductPage();
		try {
			conn = DatabaseUtil.getConnection();
			productdao=new ProductDaoImpl(conn);
			page.setCurrPageNo(currpage);
			page.setPageSize(pagesize);
			int count=productdao.getAllProductCount();
			page.setTotalCount(count);
			List<Product> list=productdao.getProductBypage(currpage, pagesize);
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
	public Product findProductByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			conn = DatabaseUtil.getConnection();
			productdao=new ProductDaoImpl(conn);
			conn.setAutoCommit(false);
			result=productdao.deleteProduct(id);
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
	public int productName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

}
