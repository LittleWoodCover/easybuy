package ServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import utils.DatabaseUtil;
import Service.UserService;
import dao.Userdao;
import daoImpl.UserdaoImpl;
import entity.User;
import entity.UserPage;

public class UserServiceImpl implements UserService{
	Userdao userdo;
	Connection conn;
	@Override
	public int getAllUserCount() {
		// TODO Auto-generated method stub
		try {
			conn = DatabaseUtil.getConnection();
			userdo=new UserdaoImpl(conn);
			return userdo.getAllUserCount();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeAll(conn, null, null);
		}
		return 0;
	}

	@Override
	public UserPage getUserBypage(int currpage, int pagesize) {
		// TODO Auto-generated method stub
		UserPage page = new UserPage();
		try {
			conn = DatabaseUtil.getConnection();
			userdo=new UserdaoImpl(conn);
			page.setCurrPageNo(currpage);
			page.setPageSize(pagesize);
			int count=userdo.getAllUserCount();
			page.setTotalCount(count);
			List<User> list=userdo.getUserBypage(currpage, pagesize);
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
	public User findNewsByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			conn = DatabaseUtil.getConnection();
			userdo=new UserdaoImpl(conn);
			conn.setAutoCommit(false);
			User newuser=userdo.loginname(user.getLoginName());
			if(newuser==null){
				result=userdo.updateUser(user);
			}else{
				result=-1;
			}			
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
			System.out.println(result+"re");
		}
		return result;
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			conn = DatabaseUtil.getConnection();
			userdo=new UserdaoImpl(conn);
			conn.setAutoCommit(false);
			result=userdo.deleteUser(id);
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
	public int loginname(String loginname) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			conn = DatabaseUtil.getConnection();
			userdo=new UserdaoImpl(conn);
			User user= userdo.loginname(loginname);
			if(user!=null){
				result=1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeAll(conn, null, null);
		}
		return result;
	}

	@Override
	public int shenCode(String shencode) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			conn = DatabaseUtil.getConnection();
			userdo=new UserdaoImpl(conn);
			User user= userdo.shenCode(shencode);
			if(user!=null){
				result=1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeAll(conn, null, null);
		}
		return result;
	}

}
