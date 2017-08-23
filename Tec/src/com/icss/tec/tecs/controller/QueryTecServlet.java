package com.icss.tec.tecs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.icss.tec.common.Pager;
import com.icss.tec.tecs.pojo.Tec;
import com.icss.tec.tecs.service.TecService;

/**
 * Servlet implementation class QueryTecServlet
 */
@WebServlet("/QueryTecServlet")
public class QueryTecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		// 获得页码
		String pageNumStr = request.getParameter("pageNum");
		// 获得每页多少条
		String pageSizeStr = request.getParameter("pageSize");

		int pageNum = 1;

		try {
			pageNum = Integer.parseInt(pageNumStr);
		} catch (Exception e) {

		}
		
		int pageSize = 10;
		
		try {
			pageSize = Integer.parseInt(pageSizeStr);
		} catch (Exception e) {
			
		}

		// 调用业务对象
		TecService service = new TecService();

		
			// 分页对象
			Pager pager;
			try {
				pager = new Pager(service.getTecCount(), pageSize, pageNum);
				// 获得当前页的数据集合
				ArrayList<Tec> list = service.queryTecByPage(pager);

				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("pager", pager);
				map.put("list", list);

				// 转换为json格式
				Gson gson = new Gson();
				out.write(gson.toJson(map));
			} catch (SQLException e) {
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
