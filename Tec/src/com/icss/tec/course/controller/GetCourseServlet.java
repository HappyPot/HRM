package com.icss.tec.course.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.icss.tec.course.pojo.Course;
import com.icss.tec.course.service.CourseService;

/**
 * Servlet implementation class GetCourseServlet
 */
@WebServlet("/GetCourseServlet")
public class GetCourseServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				PrintWriter out = response.getWriter();
				// ��ÿγ̱��
				String courseId = request.getParameter("courseId");

				// ����ҵ�����
				CourseService service = new CourseService();
				
				try {
					// ��ÿγ�����
					Course course = service.queryCourseById(Integer.parseInt(courseId));
					// ��request��Χ�洢����
//					request.setAttribute("course", course);
					Gson gson = new Gson();
					out.write( gson.toJson(course));
					// ����ת����JSP��ͼ
//					request.getRequestDispatcher("/UpdateCourse.jsp").forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
