package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UserService;
import ServiceImpl.UserServiceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import entity.User;
import entity.UserPage;

public class UserServlet extends HttpServlet {

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
			UserService user = new UserServiceImpl();
			String currPageNo = request.getParameter("currPageNo");
			if (currPageNo == null) {
				currPageNo = "1";
			}
			UserPage page=user.getUserBypage(Integer.parseInt(currPageNo), 8);
			String str = JSON.toJSONString(page,
					SerializerFeature.WriteMapNullValue,
					SerializerFeature.WriteNullNumberAsZero,
					SerializerFeature.WriteNullStringAsEmpty,
					SerializerFeature.WriteDateUseDateFormat);
			out.print(str);
		}else if(opr.equals("updateuser")){
			String loginName = request.getParameter("loginName");
			String userName = request.getParameter("userName");
			String identityCode = request.getParameter("identityCode");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			String type = request.getParameter("type");
			String id = request.getParameter("id");
			UserService userserv = new UserServiceImpl();
			User user=new User();
			user.setLoginName(loginName);
			user.setEmail(email);
			user.setIdentityCode(identityCode);
			user.setMobile(mobile);
			user.setType(Integer.parseInt(type));
			user.setUserName(userName);
			user.setId(Integer.parseInt(id));
			int result=userserv.updateUser(user);
			if(result>0){
				out.println("<script type='text/javascript'>");
				out.println("alert('用户信息修改成功，点击确认返回用户列表！');");
				out.println("location.href = 'easybuypages/admin.jsp';");
				out.println("</script>");
			}else{
				out.println("<script type='text/javascript'>");
				out.println("alert('当前用户名已存在，请输入不同的用户名！');");
				out.println("location.href ='easybuypages/admin.jsp';");
				out.println("</script>");			
			}
		}else if(opr.equals("delete")){
			String id = request.getParameter("id");
			System.out.println(id);
			UserService userserv = new UserServiceImpl();
			int result=userserv.deleteUser(Integer.parseInt(id));
			if(result>0){
				out.println("<script type='text/javascript'>");
				out.println("alert('用户信息删除成功，点击确认返回用户列表！');");
				out.println("location.href = 'easybuypages/admin.jsp';");
				out.println("</script>");
			}else{
				out.println("<script type='text/javascript'>");
				out.println("alert('删除失败！');");
				out.println("location.href ='easybuypages/admin.jsp';");
				out.println("</script>");			
			}
		}
		out.flush();
		out.close();
	}

}
