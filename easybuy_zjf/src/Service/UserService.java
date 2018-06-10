package Service;

import java.util.List;

import entity.Page;
import entity.User;
import entity.UserPage;

public interface UserService {
		//��ѯ�û���Ŀ
	   public int getAllUserCount();
		//��ѯÿ��ҳ����û�
	   public UserPage getUserBypage(int currpage,int pagesize);
	   //����ID���û�
	   public User findNewsByid(int id);
	   //�޸��û���Ϣ
	   public int updateUser(User user);
	   //ɾ���û���Ϣ
	   public int deleteUser(int id);
	   //��ѯ�û����Ƿ����
	   public int loginname(String loginname);
	   //��ѯ���֤���Ƿ����
	   public int shenCode(String shencode);
}
