package dao;

import java.util.List;

import entity.Product;



public interface ProductDao {
		//查询商品数目
	   public int getAllProductCount();
		//查询每个页面的商品
	   public List<Product> getProductBypage(int currpage,int pagesize);
	   //根据ID查商品
	   public Product findProductByid(int id);
	   //修改商品信息
	   public int updateProductr(Product product);
	   //删除商品信息
	   public int deleteProduct(int id);
	   //查询商品名是否存在
	   public Product productName(String productName);
	   //查找分类ID的产品数量
	   public int getProductCountByFenlei(int fenleiId);
}
