package com.icss.tec.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.icss.tec.common.DbUtil;
import com.icss.tec.course.pojo.Course;



public class CourseDao {
	/*
	 * 增加课程
	 */
	public void insert(Course course) throws Exception {

		Connection conn = DbUtil.getConnection();

		String sql = "insert into course values (course_seq.nextval,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, course.getCourseName());

		pstmt.executeUpdate();

		pstmt.close();
//		conn.close();
	}
	/*
	 * 修改课程
	 */
	public void update(Course course) throws Exception {

		Connection conn = DbUtil.getConnection();

		String sql = "update course set course_name=? where course_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, course.getCourseName());
		pstmt.setInt(2, course.getCourseId());

		pstmt.executeUpdate();

		pstmt.close();
//		conn.close();
	}
	/*
	 * 删除课程
	 */
	public void delete(int coursetId) throws Exception {
		
		Connection conn = DbUtil.getConnection();
		
		String sql = "delete from course where course_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, coursetId);
		
		pstmt.executeUpdate();

		pstmt.close();
//		conn.close();
	}
	/*
	 * 查询单个课程
	 */
	public Course queryById(int courseId) throws Exception {
		
		Connection conn = DbUtil.getConnection();
		
		Course course = null;
		
		String sql = "select * from course where course_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, courseId);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			course = new Course(rs.getInt(1),rs.getString(2));
		}
		
		rs.close();
		pstmt.close();
//		conn.close();

		return course;
	}
	/*
	 * 返回所有的课程
	 */
	public ArrayList<Course> query() throws Exception {
		
		ArrayList<Course> list = new ArrayList<Course>();
		
		Connection conn = DbUtil.getConnection();		
		
		String sql = "select * from course order by course_id";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Course course = new Course(rs.getInt(1),rs.getString(2));
			list.add(course);
		}
		
		rs.close();
		pstmt.close();
//		conn.close();
		
		return list;
	}
}
