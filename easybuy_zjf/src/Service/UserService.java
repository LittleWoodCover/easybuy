package Service;

import java.util.List;

import entity.Page;
import entity.User;
import entity.UserPage;

public interface UserService {
		//查询用户数目
	   public int getAllUserCount();
		//查询每个页面的用户
	   public UserPage getUserBypage(int currpage,int pagesize);
	   //根据ID查用户
	   public User findNewsByid(int id);
	   //修改用户信息
	   public int updateUser(User user);
	   //删除用户信息
	   public int deleteUser(int id);
	   //查询用户名是否存在
	   public int loginname(String loginname);
	   //查询身份证号是否存在
	   public int shenCode(String shencode);
}
