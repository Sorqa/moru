package com.test.sku.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String cmd = request.getParameter("cmd");
		String viewPath = null;
		
		if(cmd==null ||cmd.equals("loginForm"))	{	//||:이거나
			viewPath = "/jsp/loginForm.jsp";
		}else if(cmd.equals("login")) {
			//로그인 절차
			String uid = request.getParameter("uid");
			String pwd = request.getParameter("pwd");
			
			User user = new User(uid,pwd);
			UserDAO dao = new UserDAO();
			boolean ok = dao.login(user);
			
			request.setAttribute("login", ok);
			viewPath = "/jsp/loginResult.jsp";
		}else if(cmd.equals("List")){
			UserDAO dao = new UserDAO();
			List<User> list = dao.getList();
			request.setAttribute("list", list);
			viewPath = "/jsp/userList.jsp";
			
		}else if(cmd.equals("detail")) {	
			String uid = request.getParameter("uid");
			UserDAO dao = new UserDAO();
			//List<Map<String, String>> deail = dao.getUser(uid);
			User deail = dao.getUser(uid);
			request.setAttribute("deail", deail);
			viewPath = "/jsp/detailUser.jsp";
		}
		
		//jsp보여주기
		if(viewPath !=null) {			
			getServletContext().getRequestDispatcher(viewPath).forward(request,response);
		}
		
	}

}
