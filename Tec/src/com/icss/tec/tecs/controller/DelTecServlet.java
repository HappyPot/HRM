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
				//��ý�ʦ���
				String tecId = request.getParameter("tecId");
						
				//����ҵ�����
				TecService service = new TecService();
				
				
				//ɾ��Ա������
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
