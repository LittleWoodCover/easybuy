package Service;

import entity.Product;
import entity.ProductPage;




public interface ProductService {
		//查询商品数目
	   public int getAllProductCount();
		//查询每个页面的商品
	   public ProductPage getProductBypage(int currpage,int pagesize);
	   //根据ID查商品
	   public Product findProductByid(int id);
	   //修改商品信息
	   public int updateProduct(Product product);
	   //删除商品信息
	   public int deleteProduct(int id);
	   //查询商品名称是否存在
	   public int productName(String name);
}
