package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

import Service.NewsService;
import ServiceImpl.NewsServiceImpl;
import entity.News;
import entity.Page;

public class NewsServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String opr = request.getParameter("opr");
		if (opr.equals("list")) {
			NewsService news = new NewsServiceImpl();
			List<News> list = news.findNews(5);
			String str = JSON.toJSONString(list,
					SerializerFeature.WriteMapNullValue,
					SerializerFeature.WriteNullNumberAsZero,
					SerializerFeature.WriteNullStringAsEmpty);
			out.print(str);
		} else if (opr.equals("loadfenye")) {
			String currPageNo = request.getParameter("currPageNo");
			if (currPageNo == null) {
				currPageNo = "1";
			}
			NewsService news = new NewsServiceImpl();
			Page page = news.getNewsBypage(Integer.parseInt(currPageNo), 10);
			String str = JSON.toJSONString(page,
					SerializerFeature.WriteMapNullValue,
					SerializerFeature.WriteNullNumberAsZero,
					SerializerFeature.WriteNullStringAsEmpty,
					SerializerFeature.WriteDateUseDateFormat);
			out.print(str);
		}else if (opr.equals("content")) {
			String id = request.getParameter("id");
			NewsService news = new NewsServiceImpl();
			News ne=news.findNewsByid(Integer.parseInt(id));
			request.setAttribute("news", ne);
			request.getRequestDispatcher("easybuypages/Member_content.jsp").forward(request, response);
		}
		out.flush();
		out.close();
	}

}
