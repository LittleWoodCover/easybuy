/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import utils.DatabaseUtil;

/**
 * @author LENOVO
 * 
 */
public class BaseDao {
	Connection conn;

	public BaseDao(Connection conn) {
		super();
		this.conn = conn;
	}

	 protected int executeUpdate(String sql, Object... params) {
	        int result = 0;
	        PreparedStatement pstmt = null;
	        try {
	            pstmt = conn.prepareStatement(sql);
	            for (int i = 0; i < params.length; i++) {
	                pstmt.setObject(i + 1, params[i]);
	            }
	            result = pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	DatabaseUtil.closeAll(null, pstmt, null);
	        }
	        return result;
	    }

	public ResultSet executeQuery(String sql, Object... obj)
			throws SQLException {
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pst.setObject(i + 1, obj[i]);
			}
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		return rs;
	}
}
