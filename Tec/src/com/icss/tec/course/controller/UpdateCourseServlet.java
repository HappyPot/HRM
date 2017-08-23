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
 * Servlet implementation class UpdateCourseServlet
 */
@WebServlet("/UpdateCourseServlet")
public class UpdateCourseServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		�����
		PrintWriter out = response.getWriter();
		
//		��ñ�����
		String courseId = request.getParameter("courseId");
		String courseName = request.getParameter("courseName");
		
//		��װpojo����
		Course course = new Course(Integer.parseInt(courseId),courseName);
		
//		����ҵ����
		CourseService service = new CourseService();
		
		try {
			service.updateCourse(course);
		} catch (Exception e) {			
			e.printStackTrace();
			return;
		}
		
		out.println("<script>alert('�޸Ŀγ̳ɹ���');location.href='QueryDeptServlet';</script>");		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
