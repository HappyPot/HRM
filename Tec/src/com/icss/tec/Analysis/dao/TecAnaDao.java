package com.icss.tec.Analysis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.icss.tec.common.DbUtil;



public class TecAnaDao {
	/**
	 * 统计每个等级的教师人数
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Map<String,Object>> queryTecCount() throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		
		StringBuffer sb = new StringBuffer();		
		sb.append("SELECT r.rank_name,COUNT(t.tec_id) ");
		sb.append("FROM tec t ");
		sb.append("RIGHT OUTER JOIN rank r ON t.tec_rank_id = r.rank_id ");
		sb.append("GROUP BY r.rank_name");
		
		PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Map<String,Object>> list = new ArrayList<Map<String,Object>>();	
		
		while (rs.next()) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("rankName", rs.getString(1));
			map.put("tecCount",rs.getInt(2));
			
			list.add(map);
		}
		
		rs.close();
		pstmt.close();
		
		return list;		
	}

}
