package dao;

import java.util.List;

import entity.News;
import entity.User;

public interface Userdao {
	 	//��ѯ�û���Ŀ
	   public int getAllUserCount();
		//��ѯÿ��ҳ����û�
	   public List<User> getUserBypage(int currpage,int pagesize);
	   //����ID���û�
	   public User findNewsByid(int id);
	   //�޸��û���Ϣ
	   public int updateUser(User user);
	   //ɾ���û���Ϣ
	   public int deleteUser(int id);
	   //��ѯ�û����Ƿ����
	   public User loginname(String loginname);
	   //��ѯ���֤���Ƿ����
	   public User shenCode(String shencode);
}
