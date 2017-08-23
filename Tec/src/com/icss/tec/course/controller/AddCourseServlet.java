package com.icss.tec.course.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.tec.course.pojo.Course;
import com.icss.tec.course.service.CourseService;

/**
 * Servlet implementation class AddCourseServlet
 */
@WebServlet("/AddCourseServlet")
public class AddCourseServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		输出流
		PrintWriter out = response.getWriter();
		
//		获得表单数据
		String courseName = request.getParameter("courseName");
		
//		封装pojo对象
		Course course = new Course(courseName);
		
//		调用业务功能
		CourseService service = new CourseService();
		
		try {
			service.addCourse(course);
		} catch (Exception e) {			
			e.printStackTrace();
			//转发到错误页
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
		
		out.println("<script>alert('增加课程成功！');location.href='QueryCourse.html';</script>");	
		//response.sendRedirect("QueryDeptServlet");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
