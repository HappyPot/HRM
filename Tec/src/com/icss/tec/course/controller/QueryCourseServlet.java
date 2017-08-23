package com.icss.tec.course.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.tec.course.pojo.Course;
import com.icss.tec.course.service.CourseService;

/**
 * Servlet implementation class QueryCourseServlet
 */
@WebServlet("/QueryCourseServlet")
public class QueryCourseServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// 调用业务对象
				CourseService service = new CourseService();

				try {
					// 获得数据集合
					ArrayList<Course> list = service.queryCourse();
					// 在request范围中设置数据
					request.setAttribute("list", list);
					//请求转发到JSP视图
					request.getRequestDispatcher("/QueryCourse.jsp").forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
					//转发到错误页
					request.getRequestDispatcher("/error.jsp").forward(request, response);
				}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
