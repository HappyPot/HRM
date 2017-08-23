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
			// ����ҵ�����
				CourseService service = new CourseService();

				try {
					// ������ݼ���
					ArrayList<Course> list = service.queryCourse();
					// ��request��Χ����������
					request.setAttribute("list", list);
					//����ת����JSP��ͼ
					request.getRequestDispatcher("/QueryCourse.jsp").forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
					//ת��������ҳ
					request.getRequestDispatcher("/error.jsp").forward(request, response);
				}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
