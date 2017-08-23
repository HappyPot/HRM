package com.icss.tec.course.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.tec.course.service.CourseService;

/**
 * Servlet implementation class DelCourseServlet
 */
@WebServlet("/DelCourseServlet")
public class DelCourseServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//��������
				PrintWriter out = response.getWriter();
				
				//��ò��ű��
				String courseId = request.getParameter("courseId");
				
				//����ҵ�����
				CourseService service = new CourseService();
				
				try {
					//ɾ����������
					service.deleteCourse(Integer.parseInt(courseId));
				} catch (Exception e) {			
					e.printStackTrace();
					return;
				}
				
				out.println("<script>alert('ɾ�����ųɹ���');location.href='QueryCourse.html';</script>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
