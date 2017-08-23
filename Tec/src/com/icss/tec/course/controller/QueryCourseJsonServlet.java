package com.icss.tec.course.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.icss.tec.course.pojo.Course;
import com.icss.tec.course.service.CourseService;

/**
 * Servlet implementation class QueryJsonServlet
 */
@WebServlet("/QueryCourseJsonServlet")
public class QueryCourseJsonServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
//		����ҵ�����
		CourseService service = new CourseService();
		System.out.println("11111111111");
		try {
			//���ز������ݼ���
			ArrayList<Course> list = service.queryCourse();
//			ת��Ϊjson���ݸ�ʽ
			Gson gson = new Gson();
			out.write( gson.toJson(list) );
		} catch (Exception e) {			
			e.printStackTrace();
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
