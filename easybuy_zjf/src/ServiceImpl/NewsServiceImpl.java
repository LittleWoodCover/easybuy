/**
 * 
 */
package ServiceImpl;

import java.sql.Connection;
import java.util.List;

import utils.DatabaseUtil;
import dao.NewsDao;
import daoImpl.NewsDaoImpl;
import entity.News;
import entity.Page;
import Service.NewsService;

/**
 * @author LENOVO
 * 
 */
public class NewsServiceImpl implements NewsService {

	NewsDao newsdao;
	Connection conn;
	

	// 查询前5条新闻
	@Override
	public List<News> findNews(int limit) {
		// TODO Auto-generated method stub
		try {
			conn = DatabaseUtil.getConnection();
			newsdao = new NewsDaoImpl(conn);
			return newsdao.findNews(limit);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeAll(conn, null, null);
		}
		return null;
	}

	// 查询新闻总数目
	@Override
	public int getAllNewsCount() {
		// TODO Auto-generated method stub
		try {
			conn = DatabaseUtil.getConnection();
			newsdao = new NewsDaoImpl(conn);
			return newsdao.getAllNewsCount();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeAll(conn, null, null);
		}
		return 0;
	}

	// 查询每个页面的新闻
	@Override
	public Page getNewsBypage(int currpage, int pagesize) {
		// TODO Auto-generated method stub
		Page page = new Page();
		try {
			conn = DatabaseUtil.getConnection();
			newsdao = new NewsDaoImpl(conn);
			page.setCurrPageNo(currpage);
			page.setPageSize(pagesize);
			int count=newsdao.getAllNewsCount();
			page.setTotalCount(count);
			List<News> list=newsdao.getNewsBypage(currpage, pagesize);
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
	public News findNewsByid(int id) {
		// TODO Auto-generated method stub
		try {
			conn = DatabaseUtil.getConnection();
			newsdao = new NewsDaoImpl(conn);
			return newsdao.findNewsByid(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeAll(conn, null, null);
		}
		return null;
	}

}
