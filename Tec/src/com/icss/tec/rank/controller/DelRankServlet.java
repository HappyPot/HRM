package com.icss.tec.rank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.tec.rank.service.RankService;

/**
 * Servlet implementation class DelRankServlet
 */
@WebServlet("/DelRankServlet")
public class DelRankServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// ��������
				PrintWriter out = response.getWriter();

				// ����������
				String rankId = request.getParameter("rankId");

				// ����ҵ�����
				RankService service = new RankService();

				try {
					// ɾ���ȼ�
					service.deleteRank(Integer.parseInt(rankId));
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
