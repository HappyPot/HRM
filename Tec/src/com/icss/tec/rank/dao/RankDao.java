package com.icss.tec.rank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.icss.tec.common.DbUtil;
import com.icss.tec.rank.pojo.Rank;
import com.icss.tec.tecs.pojo.Tec;



public class RankDao {
	/**
	 * 添加等级
	 * @param rank
	 * @throws Exception
	 */
	public void insert(Rank rank) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		conn = DbUtil.getConnection();
		String sql = "insert into rank values(rank_seq.Nextval,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, rank.getRankName());
		pstmt.setInt(2, rank.getRankSal());
		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}
	/**
	 * 删除数据
	 * @param jobId
	 * @throws Exception
	 */
	public void delete(int rankId) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;

		conn = DbUtil.getConnection();
		String sql = "delete from rank where rank_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, rankId);
		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}
	/**
	 * 修改等级
	 * @param job
	 * @throws Exception
	 */
	public void update(Rank rank) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;

		conn = DbUtil.getConnection();
		String sql = "update rank set rank_name = ?,rank_salary = ? where rank_id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, rank.getRankName());
		pstmt.setInt(2, rank.getRankSal());
		pstmt.setInt(3, rank.getRankId());
		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}
	/**
	 * 查询数据
	 * @param jobId
	 * @return
	 * @throws Exception
	 */
	public Rank queryById(int rankId) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = DbUtil.getConnection();
		String sql = "select * from rank where rank_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, rankId);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			return new Rank(rs.getInt("rank_id"), rs.getString("rank_name"), rs.getInt("rank_salary"));
		}

		rs.close();
		pstmt.close();
		conn.close();

		return null;
	}
	/**
	 * 返回数据集合
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Rank> query() throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = DbUtil.getConnection();
		String sql = "select * from Rank";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		ArrayList<Rank> list = new ArrayList<Rank>();
		while (rs.next()) {
			list.add(new Rank(rs.getInt("rank_id"), rs.getString("rank_name"), rs.getInt("rank_salary")));
		}

		rs.close();
		pstmt.close();
		conn.close();

		return list;
	}
}
