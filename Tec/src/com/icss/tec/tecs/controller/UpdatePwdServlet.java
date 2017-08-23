package com.icss.tec.tecs.controller;

import java.io.IOException;
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
 * Servlet implementation class UpdatePwdServlet
 */
@WebServlet("/UpdatePwdServlet")
public class UpdatePwdServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//�������
				String tecPwd = request.getParameter("tecPwd");
				
				//����û���
				HttpSession session = request.getSession();
				String tecName = (String) session.getAttribute("tecName");
				
				//��װpojo����
				Tec tec = new Tec();
				tec.setTecName(tecName);
				tec.setTecPwd(tecPwd);
				
				//����ҵ�����
				TecService service = new TecService();
				
				try {
					//�޸�����
					service.updatePwd(tec);
				} catch (SQLException e) {			
					e.printStackTrace();
				}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
