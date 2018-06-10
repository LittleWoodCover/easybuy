package daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import utils.DatabaseUtil;
import dao.BaseDao;
import dao.NewsDao;
import entity.News;

public class NewsDaoImpl extends BaseDao implements NewsDao {

	public NewsDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	// 查询前5条新闻
	@Override
	public List<News> findNews(int limit) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		List<News> list = new ArrayList<News>();
		String sql = "SELECT id,title,content,createTime FROM easybuy_news ORDER BY createTime DESC LIMIT ?";
		try {
			rs = this.executeQuery(sql, limit);
			while (rs.next()) {
				News news = new News();
				news.setContent(rs.getString("content"));
				news.setCreateTime(rs.getDate("createTime"));
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				list.add(news);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeAll(null, null, rs);
		}
		return list;
	}

	// 查询新闻总数目
	@Override
	public int getAllNewsCount() {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		int result=0;
		List<News> list = new ArrayList<News>();
		String sql = "SELECT COUNT(1) FROM easybuy_news ";
		try {
			rs = this.executeQuery(sql);
			while (rs.next()) {
				result=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeAll(null, null, rs);
		}
		return result;
	}

	// 查询每个页面的新闻
	@Override
	public List<News> getNewsBypage(int currpage, int pagesize) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		List<News> list = new ArrayList<News>();
		String sql = "SELECT id,title,content,createTime FROM easybuy_news ORDER BY createTime DESC LIMIT ?,?";
		Object[] obj={(currpage-1)*pagesize,pagesize};
		try {
			rs = this.executeQuery(sql,obj);
			while (rs.next()) {
				News news = new News();
				news.setContent(rs.getString("content"));
				news.setCreateTime(rs.getDate("createTime"));
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				list.add(news);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeAll(null, null, rs);
		}
		return list;
	}

	@Override
	public News findNewsByid(int id) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		News news=null;
		String sql = "SELECT id,title,content,createTime FROM easybuy_news where id=?";
		try {
			rs = this.executeQuery(sql, id);
			while (rs.next()) {
				 news = new News();
				news.setContent(rs.getString("content"));
				news.setCreateTime(rs.getDate("createTime"));
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeAll(null, null, rs);
		}
		return news;
	}

}
