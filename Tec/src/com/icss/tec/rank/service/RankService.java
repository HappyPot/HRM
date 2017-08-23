package com.icss.tec.rank.service;

import java.util.ArrayList;

import com.icss.tec.rank.dao.RankDao;
import com.icss.tec.rank.pojo.Rank;


public class RankService {
	private RankDao dao = new RankDao();
	
	public void addRank(Rank rank) throws Exception {
		dao.insert(rank);
	}
	
	public void updateRank(Rank rank) throws Exception {
		dao.update(rank);
	}
	
	public void deleteRank(int rankId) throws Exception {
		dao.delete(rankId);
	}
	
	public Rank queryRankById(int rankId) throws Exception {
		
		return dao.queryById(rankId);
	}
	
	public ArrayList<Rank> queryRank() throws Exception {
		
		return dao.query();
	}

}
