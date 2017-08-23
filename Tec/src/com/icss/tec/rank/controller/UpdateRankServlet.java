package com.icss.tec.rank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.tec.rank.pojo.Rank;
import com.icss.tec.rank.service.RankService;

/**
 * Servlet implementation class UpdateRankServlet
 */
@WebServlet("/UpdateRankServlet")
public class UpdateRankServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// 获得输出流
				PrintWriter out = response.getWriter();

				// 获得请求参数
				String rankId = request.getParameter("rankId");
				String rankName = request.getParameter("rankName");
				String rankSalary = request.getParameter("rankSalary");

				// 封装为pojo对象
				Rank rank = new Rank(Integer.parseInt(rankId), rankName, Integer.parseInt(rankSalary));

				// 调用业务对象
				RankService service = new RankService();

				try {
					// 修改职务
					service.updateRank(rank);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
