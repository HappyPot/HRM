package com.icss.tec.tecs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.tec.tecs.service.TecService;

/**
 * Servlet implementation class CheckNameServlet
 */
@WebServlet("/CheckNameServlet")
public class CheckNameServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		// 获得登录名称
		String tecName = request.getParameter("tecName");

		// 调用业务对象
		TecService service = new TecService();

		try {
			// 判断返回检查结果
			boolean result = service.checkLoginName(tecName);
			out.write(String.valueOf(result));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
