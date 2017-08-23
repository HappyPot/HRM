package com.icss.tec.Analysis.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.icss.tec.Analysis.dao.TecAnaDao;



public class TecAnaService {
private TecAnaDao dao = new TecAnaDao();
	
	/**
	 * 统计每个等级的人数
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Map<String,Object>> queryTecCount() throws SQLException {
		return dao.queryTecCount();
	}
}
