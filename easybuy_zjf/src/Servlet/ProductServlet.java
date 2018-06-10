package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ProductService;
import ServiceImpl.ProductServiceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import entity.ProductPage;


public class ProductServlet extends HttpServlet {

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
			ProductService product = new ProductServiceImpl();
			String currPageNo = request.getParameter("currPageNo");
			if (currPageNo == null) {
				currPageNo = "1";
			}
			ProductPage page=product.getProductBypage(Integer.parseInt(currPageNo), 10);
			String str = JSON.toJSONString(page,
					SerializerFeature.WriteMapNullValue,
					SerializerFeature.WriteNullNumberAsZero,
					SerializerFeature.WriteNullStringAsEmpty,
					SerializerFeature.WriteDateUseDateFormat);
			out.print(str);
		}else if(opr.equals("delete")) {
			ProductService product = new ProductServiceImpl();
			String id = request.getParameter("id");
			int result=product.deleteProduct(Integer.parseInt(id));
			if(result>0){
				out.println("<script type='text/javascript'>");
				out.println("alert('商品信息删除成功，点击确认返回商品列表！');");
				out.println("location.href = 'easybuypages/productadmin.jsp';");
				out.println("</script>");
			}else{
				out.println("<script type='text/javascript'>");
				out.println("alert('商品信息删除失败，点击确认返回商品列表！');");
				out.println("location.href = 'easybuypages/productadmin.jsp';");
				out.println("</script>");
			}
		}
		out.flush();
		out.close();
	}

}
