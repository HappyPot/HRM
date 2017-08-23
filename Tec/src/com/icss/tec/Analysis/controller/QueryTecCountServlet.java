package com.icss.tec.Analysis.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.icss.tec.Analysis.service.TecAnaService;

/**
 * Servlet implementation class QueryEmpCountServlet
 */
@WebServlet("/QueryTecCountServlet")
public class QueryTecCountServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		//ҵ�����
		TecAnaService service = new TecAnaService();
		
		try {
			//���ͳ������
			ArrayList<Map<String,Object>> list = service.queryTecCount();
			//ת��ΪJSON��ʽ
			Gson gson = new Gson();
			out.write( gson.toJson(list) );
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
