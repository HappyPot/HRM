package com.icss.tec.tecs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.icss.tec.tecs.pojo.Tec;
import com.icss.tec.tecs.service.TecService;

/**
 * Servlet implementation class GetTecServlet
 */
@WebServlet("/GetTecServlet")
public class GetTecServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		//获得员工id
		String tecId = request.getParameter("tecId");
		
		//调用业务对象
		TecService service = new TecService();
		
		
			//返回Emp对象
			Tec tec;
			try {
				tec = service.queryTecById(Integer.parseInt(tecId));
				//转换为json数据
				Gson gson = new Gson();
				out.write(gson.toJson(tec));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
