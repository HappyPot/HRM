package com.icss.tec.tecs.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.tec.tecs.service.TecService;

/**
 * Servlet implementation class DelTecServlet
 */
@WebServlet("/DelTecServlet")
public class DelTecServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//获得教师编号
				String tecId = request.getParameter("tecId");
						
				//调用业务对象
				TecService service = new TecService();
				
				
				//删除员工数据
				try {
					service.deleteTec(Integer.parseInt(tecId));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
