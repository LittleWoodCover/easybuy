package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.CategoryService;
import ServiceImpl.CategoryServiceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import entity.Category;
import entity.CategoryPage;

public class CategoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String opr = request.getParameter("opr");
		if (opr.equals("loadfenye")) {
			CategoryService category = new CategoryServiceImpl();
			String currPageNo = request.getParameter("currPageNo");
			if (currPageNo == null) {
				currPageNo = "1";
			}
			CategoryPage page = category.getCategoryBypage(
					Integer.parseInt(currPageNo), 10);
			String str = JSON.toJSONString(page,
					SerializerFeature.WriteMapNullValue,
					SerializerFeature.WriteNullNumberAsZero,
					SerializerFeature.WriteNullStringAsEmpty,
					SerializerFeature.WriteDateUseDateFormat);
			out.print(str);
		} else if (opr.equals("delete")) {
			String id = request.getParameter("id");
			CategoryService categoryv = new CategoryServiceImpl();
			int result = categoryv.deleteCategory(Integer.parseInt(id));
			if (result > 0) {
				out.println("<script type='text/javascript'>");
				out.println("alert('分类信息删除成功，点击确认返回分类列表！');");
				out.println("location.href = 'easybuypages/fenleiadmin.jsp';");
				out.println("</script>");
			} else if (result == -1) {
				out.println("<script type='text/javascript'>");
				out.println("alert('删除失败！该分类下有子分类！');");
				out.println("location.href ='easybuypages/fenleiadmin.jsp';");
				out.println("</script>");
			} else if (result == -2) {
				out.println("<script type='text/javascript'>");
				out.println("alert('删除失败！该分类下有商品！');");
				out.println("location.href ='easybuypages/fenleiadmin.jsp';");
				out.println("</script>");
			}
		} else if (opr.equals("tiaozhuan")) {
			CategoryService categoryv = new CategoryServiceImpl();
			List<Category> list = categoryv.getCategoryByType(1);
			request.setAttribute("list1", list);
			request.getRequestDispatcher("easybuypages/addCategory.jsp")
					.forward(request, response);
		} else if (opr.equals("gettwolist")) {
			CategoryService categoryv = new CategoryServiceImpl();
			String parentId = request.getParameter("parentId");
			List<Category> list = categoryv.getCatelistByParentId(Integer
					.parseInt(parentId));
			String str = JSON.toJSONString(list,
					SerializerFeature.WriteMapNullValue,
					SerializerFeature.WriteNullNumberAsZero,
					SerializerFeature.WriteNullStringAsEmpty,
					SerializerFeature.WriteDateUseDateFormat);
			out.print(str);
		} else if (opr.equals("addcategory")) {
			CategoryService categoryv = new CategoryServiceImpl();
			Category cg = new Category();
			Integer parentid = 0;
			String type = request.getParameter("type");
			String categoryone = request.getParameter("categoryone");
			String categorytwo = request.getParameter("categorytwo");
			String name = request.getParameter("name");
			if (type.equals("1")) {
				parentid = 0;
			} else if (type.equals("2")) {
				parentid = Integer.parseInt(categoryone);
			} else {
				parentid = Integer.parseInt(categorytwo);
			}
			cg.setName(name);
			cg.setParentId(parentid);
			cg.setType(Integer.parseInt(type));
			int result = categoryv.addCategory(cg);
			if (result > 0) {
				out.println("<script type='text/javascript'>");
				out.println("alert('分类信息添加成功，点击确认返回分类列表！');");
				out.println("location.href = 'easybuypages/fenleiadmin.jsp';");
				out.println("</script>");
			} else {
				out.println("<script type='text/javascript'>");
				out.println("alert('分类信息添加失败，点击确认返回分类列表！');");
				out.println("location.href = 'easybuypages/fenleiadmin.jsp';");
				out.println("</script>");
			}
		}
		out.flush();
		out.close();
	}

}
