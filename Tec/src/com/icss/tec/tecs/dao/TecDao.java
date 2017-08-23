package com.icss.tec.tecs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.tec.common.DbUtil;
import com.icss.tec.common.Pager;
import com.icss.tec.course.pojo.Course;
import com.icss.tec.rank.pojo.Rank;
import com.icss.tec.tecs.pojo.Tec;

public class TecDao {
	/**
	 * 登录检查用户名
	 * 
	 * @param empLoginName
	 * @return
	 * @throws SQLException
	 */
	public Tec queryByLoginName(String tecName) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "select tec_pwd from tec where tec_name=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, tecName);
		ResultSet rs = pstmt.executeQuery();

		Tec tec = null;

		if (rs.next()) {
			tec = new Tec();
			tec.setTecPwd(rs.getString(1));
		}

		rs.close();
		pstmt.close();
		conn.close();
		return tec;
	}
	/**
	 * 插入教师数据
	 * @param tec
	 * @throws Exception
	 */
	public void insert(Tec tec) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		conn = DbUtil.getConnection();
		String sql = "insert into tec values(tec_seq.Nextval,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, tec.getTecName());
		pstmt.setString(2, tec.getTecPwd());
		pstmt.setInt(3, tec.getCourse().getCourseId());
		pstmt.setInt(4, tec.getRank().getRankId());
		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}
	/**
	 * 删除教师
	 * @param tecId
	 * @throws Exception
	 */
	public void delete(int tecId) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;

		conn = DbUtil.getConnection();
		String sql = "delete from tec where tec_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, tecId);
		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}
	/**
	 * 修改教师
	 * @param tec
	 * @throws Exception
	 */
	public void update(Tec tec) throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		conn = DbUtil.getConnection();
		String sql = "update tec set tec_name = ?, tec_course_id = ?, tec_rank_id = ? where tec_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, tec.getTecName());
		pstmt.setInt(2, tec.getCourse().getCourseId());
		pstmt.setInt(3, tec.getRank().getRankId());
		pstmt.setInt(4, tec.getTecId());
		System.out.println("@@@@@@@@@@@@@@@@@@dao    "+  tec);
		pstmt.executeUpdate();
		System.out.println("@@@@@@@@@@@@@@@@@@dao");
		pstmt.close();
		conn.close();
	}
	/**
	 * 根据教师id返回教师的数据
	 * @param tecId
	 * @return
	 * @throws Exception
	 */
	public Tec queryById(int tecId) throws Exception {

		Connection conn = DbUtil.getConnection();

		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.*,c.course_name,r.rank_name ");
		sb.append("FROM tec t ");
		sb.append("LEFT OUTER JOIN course c ON t.tec_course_id=c.course_id ");
		sb.append("LEFT OUTER JOIN rank r ON t.tec_rank_id = r.rank_id ");
		sb.append("WHERE tec_id=?");

		PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		pstmt.setInt(1, tecId);

		ResultSet rs = pstmt.executeQuery();

		Tec tec = null;

		if (rs.next()) {
			Course course = new Course();
			course.setCourseId(rs.getInt(4));
			course.setCourseName(rs.getString("COURSE_NAME"));

			Rank rank = new Rank();
			rank.setRankId(rs.getInt(5));
			rank.setRankName(rs.getString("RANK_NAME"));

			tec = new Tec(rs.getInt(1), rs.getString(2),rs.getString(3),course,rank);
		}

		rs.close();
		pstmt.close();
		conn.close();
		return tec;	
		}
	/**
	 * 获得查询结果总记录数
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int getCount() throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "select count(*) from tec";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		rs.next();
		int count = rs.getInt(1);

		rs.close();
		pstmt.close();
		conn.close();
		return count;
	}
	/**
	 * 分页查询
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Tec> queryByPage(Pager pager) throws Exception {

		Connection conn = DbUtil.getConnection();

		StringBuffer sb = new StringBuffer();
		sb.append(
				"SELECT * FROM (SELECT ROWNUM rnum,t.tec_id,t.tec_name,c.course_name,r.rank_name ");
		sb.append("FROM tec t ");
		sb.append("LEFT OUTER JOIN course c ON t.tec_course_id=c.course_id ");
		sb.append("LEFT OUTER JOIN rank r ON t.tec_rank_id=r.rank_id) ");
		sb.append("WHERE rnum BETWEEN ? AND ?");

		PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		pstmt.setInt(1, pager.getStart());
		pstmt.setInt(2, pager.getEnd());

		ResultSet rs = pstmt.executeQuery();

		ArrayList<Tec> list = new ArrayList<Tec>();

		while (rs.next()) {

			Course course = new Course();
			course.setCourseName(rs.getString(4));

			Rank rank = new Rank();
			rank.setRankName(rs.getString(5));

			Tec tec = new Tec();
			tec.setTecId(rs.getInt(2));
			tec.setTecName(rs.getString(3));
			tec.setCourse(course);
			tec.setRank(rank);

			list.add(tec);
		}

		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
	/**
	 * 修改密码
	 */
	public void updatePwd(Tec tec) throws SQLException {
			
			Connection conn = DbUtil.getConnection();
			
			String sql = "update tec set tec_pwd=? where tec_name=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, tec.getTecPwd());
			pstmt.setString(2, tec.getTecName());
			
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		}
	
}
