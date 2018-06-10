package dao;

import java.util.List;

import entity.News;
import entity.User;

public interface Userdao {
	 	//查询用户数目
	   public int getAllUserCount();
		//查询每个页面的用户
	   public List<User> getUserBypage(int currpage,int pagesize);
	   //根据ID查用户
	   public User findNewsByid(int id);
	   //修改用户信息
	   public int updateUser(User user);
	   //删除用户信息
	   public int deleteUser(int id);
	   //查询用户名是否存在
	   public User loginname(String loginname);
	   //查询身份证号是否存在
	   public User shenCode(String shencode);
}
