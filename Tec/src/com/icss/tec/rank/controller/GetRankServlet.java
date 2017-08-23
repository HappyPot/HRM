package com.icss.tec.rank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.icss.tec.rank.pojo.Rank;
import com.icss.tec.rank.service.RankService;

/**
 * Servlet implementation class GetRankServlet
 */
@WebServlet("/GetRankServlet")
public class GetRankServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		��������
		PrintWriter out = response.getWriter();
		
//		���ְ��id
		String rankId = request.getParameter("rankId");
		
//		����ҵ�����
		RankService service = new RankService();
		
		try {
			//���ְ������
			Rank rank = service.queryRankById(Integer.parseInt(rankId));
			System.out.println("Servlet!!!!!!!!!!!!!==="+rank);
//			ת��Ϊjson����
			Gson gson = new Gson();
			out.write( gson.toJson(rank));
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
