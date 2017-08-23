package com.icss.tec.course.service;

import java.util.ArrayList;

import com.icss.tec.course.dao.CourseDao;
import com.icss.tec.course.pojo.Course;



public class CourseService {
	private CourseDao dao = new CourseDao();
	/*
	 * 增加
	 */
	public void addCourse(Course course) throws Exception {
		dao.insert(course);		
	}
	/*
	 * 修改
	 */
	public void updateCourse(Course course) throws Exception {
		dao.update(course);		
	}
	/*
	 * 删除
	 */
	public void deleteCourse(int courseId) throws Exception {
		dao.delete(courseId);		
	}
	/*
	 * 查询单个
	 */
	public Course queryCourseById(int courseId) throws Exception {
		
		return dao.queryById(courseId);
	}
	/*
	 * 查询所有
	 */
	public ArrayList<Course> queryCourse() throws Exception {
		
		return dao.query();
	}

}
