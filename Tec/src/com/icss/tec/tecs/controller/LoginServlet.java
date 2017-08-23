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
	private static final long serialVersionUID = 1L;//��������汾

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		// ����������
		String TecName = request.getParameter("TecName");
		String TecPwd = request.getParameter("TecPwd");
//		System.out.println(TecName);
		// ����ҵ�����
		TecService service = new TecService();
		
		try {
			//�õ���֤���
			int result = service.checkLogin(TecName, TecPwd);			
			out.print(result);
			
			//�����¼��֤ͨ������session�д洢��¼��ʶ
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
