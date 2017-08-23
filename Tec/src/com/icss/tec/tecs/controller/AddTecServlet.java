package com.icss.tec.tecs.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.tec.course.pojo.Course;
import com.icss.tec.rank.pojo.Rank;
import com.icss.tec.tecs.pojo.Tec;
import com.icss.tec.tecs.service.TecService;

/**
 * Servlet implementation class AddTecServlet
 */
@WebServlet("/AddTecServlet")
public class AddTecServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获得请求参数
		String tecName = request.getParameter("tecName");
		String tecPwd = request.getParameter("tecPwd");
		String rankId = request.getParameter("rankId");
		String courseId = request.getParameter("courseId");

		// 封装为pojo对象
		Course course = new Course();
		course.setCourseId(Integer.parseInt(courseId));

		Rank rank = new Rank();
		rank.setRankId(Integer.parseInt(rankId));

		Tec tec = new Tec(tecName, tecPwd, course, rank);
		
		//调用业务对象
		TecService service = new TecService();

			//增加员工功能
			try {
				service.addTec(tec);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
