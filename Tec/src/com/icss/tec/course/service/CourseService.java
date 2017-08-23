package com.icss.tec.course.service;

import java.util.ArrayList;

import com.icss.tec.course.dao.CourseDao;
import com.icss.tec.course.pojo.Course;



public class CourseService {
	private CourseDao dao = new CourseDao();
	/*
	 * ����
	 */
	public void addCourse(Course course) throws Exception {
		dao.insert(course);		
	}
	/*
	 * �޸�
	 */
	public void updateCourse(Course course) throws Exception {
		dao.update(course);		
	}
	/*
	 * ɾ��
	 */
	public void deleteCourse(int courseId) throws Exception {
		dao.delete(courseId);		
	}
	/*
	 * ��ѯ����
	 */
	public Course queryCourseById(int courseId) throws Exception {
		
		return dao.queryById(courseId);
	}
	/*
	 * ��ѯ����
	 */
	public ArrayList<Course> queryCourse() throws Exception {
		
		return dao.query();
	}

}
