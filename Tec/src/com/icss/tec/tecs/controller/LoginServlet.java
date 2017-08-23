package com.icss.tec.tecs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.tec.tecs.service.TecService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;//划分软件版本

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		// 获得请求参数
		String TecName = request.getParameter("TecName");
		String TecPwd = request.getParameter("TecPwd");
//		System.out.println(TecName);
		// 调用业务对象
		TecService service = new TecService();
		
		try {
			//得到验证结果
			int result = service.checkLogin(TecName, TecPwd);			
			out.print(result);
			
			//如果登录验证通过，在session中存储登录标识
			if (result == 3) {
				HttpSession session = request.getSession();
				session.setAttribute("tecName", TecName);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
