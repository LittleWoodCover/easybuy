package dao;

import java.util.List;

import entity.Product;



public interface ProductDao {
		//��ѯ��Ʒ��Ŀ
	   public int getAllProductCount();
		//��ѯÿ��ҳ�����Ʒ
	   public List<Product> getProductBypage(int currpage,int pagesize);
	   //����ID����Ʒ
	   public Product findProductByid(int id);
	   //�޸���Ʒ��Ϣ
	   public int updateProductr(Product product);
	   //ɾ����Ʒ��Ϣ
	   public int deleteProduct(int id);
	   //��ѯ��Ʒ���Ƿ����
	   public Product productName(String productName);
	   //���ҷ���ID�Ĳ�Ʒ����
	   public int getProductCountByFenlei(int fenleiId);
}
