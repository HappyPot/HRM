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

import com.icss.tec.tecs.pojo.Tec;
import com.icss.tec.tecs.service.TecService;

/**
 * Servlet implementation class GetPwdServlet
 */
@WebServlet("/GetPwdServlet")
public class GetPwdServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		TecService service = new TecService();
		
		HttpSession session = request.getSession();
		String tecName = (String) session.getAttribute("tecName");
				
		try {
			Tec tec = service.queryPwdByLoginName(tecName);
			out.write(tec.getTecPwd());
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
