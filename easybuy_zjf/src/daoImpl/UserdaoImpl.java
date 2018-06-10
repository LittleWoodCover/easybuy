package daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import utils.DatabaseUtil;
import dao.BaseDao;
import dao.Userdao;

import entity.User;

public class UserdaoImpl extends BaseDao implements Userdao {

	public UserdaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	// 查询用户数目
	@Override
	public int getAllUserCount() {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		int result = 0;
		String sql = "SELECT COUNT(1) FROM easybuy_user ";
		try {
			rs = this.executeQuery(sql);
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeAll(null, null, rs);
		}
		return result;
	}

	// 查询每个页面的用户
	@Override
	public List<User> getUserBypage(int currpage, int pagesize) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		String sql = "SELECT id,userName,loginName,password,sex,identityCode,email,mobile,type FROM easybuy_user LIMIT ?,?";
		Object[] obj = { (currpage - 1) * pagesize, pagesize };
		try {
			rs = this.executeQuery(sql, obj);
			while (rs.next()) {
				User user = new User();
				user.setEmail(rs.getString("email"));
				user.setId(rs.getInt("id"));
				user.setIdentityCode(rs.getString("identityCode"));
				user.setLoginName(rs.getString("loginName"));
				user.setMobile(rs.getString("mobile"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getInt("sex"));
				user.setType(rs.getInt("type"));
				user.setUserName(rs.getString("userName"));
				list.add(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeAll(null, null, rs);
		}
		return list;
	}

	// 根据ID查用户
	@Override
	public User findNewsByid(int id) {
		// TODO Auto-generated method stub
		 String sql = "select * from easybuy_user where id=?";
	        ResultSet rs = null;
	        User user = null;
	        try {
	            rs = executeQuery(sql, id);
	            if (rs.next()) {
	                user = new User();
	                user.setId(rs.getInt("id"));
	                user.setLoginName(rs.getString("loginName"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	DatabaseUtil.closeAll(null, null, rs);
	        }
	        return user;
	}

	// 修改用户信息
	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		 String sql = "UPDATE easybuy_user SET `loginName` = ?,userName=? ,identityCode=?,email=?,mobile=?,type=? WHERE `id` = ?";
	        int result = 0;
	        Object[] obj={user.getLoginName(),user.getUserName(),user.getIdentityCode(),user.getEmail(),user.getMobile(),user.getType(),user.getId()};
	        try {
	            result = this.executeUpdate(sql, obj);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	        System.out.println(result+"impl");
	        return result;
	}

	// 删除用户信息
	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		 String sql = "DELETE FROM easybuy_user WHERE `id` = ?";
	        int result = 0;
	        try {
	            result = executeUpdate(sql,id);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	        return result;
	}

	@Override
	public User loginname(String loginName) {
		// TODO Auto-generated method stub
		 String sql = "select * from easybuy_user where loginName=?";
	        ResultSet rs = null;
	        User user = null;
	        try {
	            rs = executeQuery(sql, loginName);
	            if (rs.next()) {
	                user = new User();
	                user.setId(rs.getInt("id"));
	                user.setLoginName(rs.getString("loginName"));
	            }
	            if(user==null){
	            	System.out.println(0);
	            }else{
	            	System.out.println(1);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	DatabaseUtil.closeAll(null, null, rs);
	        }
	        return user;
	}
	@Override
	public User shenCode(String identityCode) {
		// TODO Auto-generated method stub
		 String sql = "select * from easybuy_user where identityCode=?";
	        ResultSet rs = null;
	        User user = null;
	        try {
	            rs = executeQuery(sql, identityCode);
	            if (rs.next()) {
	                user = new User();
	                user.setId(rs.getInt("id"));
	                user.setLoginName(rs.getString("loginName"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	DatabaseUtil.closeAll(null, null, rs);
	        }
	        return user;
	}

}
