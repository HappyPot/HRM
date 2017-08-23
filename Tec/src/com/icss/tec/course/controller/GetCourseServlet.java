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
				// 获得课程编号
				String courseId = request.getParameter("courseId");

				// 调用业务对象
				CourseService service = new CourseService();
				
				try {
					// 获得课程数据
					Course course = service.queryCourseById(Integer.parseInt(courseId));
					// 在request范围存储数据
//					request.setAttribute("course", course);
					Gson gson = new Gson();
					out.write( gson.toJson(course));
					// 请求转发到JSP视图
//					request.getRequestDispatcher("/UpdateCourse.jsp").forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
