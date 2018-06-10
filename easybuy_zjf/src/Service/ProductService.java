package Service;

import entity.Product;
import entity.ProductPage;




public interface ProductService {
		//��ѯ��Ʒ��Ŀ
	   public int getAllProductCount();
		//��ѯÿ��ҳ�����Ʒ
	   public ProductPage getProductBypage(int currpage,int pagesize);
	   //����ID����Ʒ
	   public Product findProductByid(int id);
	   //�޸���Ʒ��Ϣ
	   public int updateProduct(Product product);
	   //ɾ����Ʒ��Ϣ
	   public int deleteProduct(int id);
	   //��ѯ��Ʒ�����Ƿ����
	   public int productName(String name);
}
