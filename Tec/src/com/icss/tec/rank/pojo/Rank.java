package com.icss.tec.rank.pojo;

public class Rank {
	private int rankId;

	private String rankName;
	
	private int rankSal;

	
	
	public Rank() {
		super();
	}

	public Rank(int rankId, String rankName, int rankSal) {
		super();
		this.rankId = rankId;
		this.rankName = rankName;
		this.rankSal = rankSal;
	}

	public Rank(String rankName, int rankSal) {
		super();
		this.rankName = rankName;
		this.rankSal = rankSal;
	}

	public int getRankId() {
		return rankId;
	}

	public void setRankId(int rankId) {
		this.rankId = rankId;
	}

	public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	public int getRankSal() {
		return rankSal;
	}

	public void setRankSal(int rankSal) {
		this.rankSal = rankSal;
	}

	@Override
	public String toString() {
		return "Rank [rankId=" + rankId + ", rankName=" + rankName + ", rankSal=" + rankSal + "]";
	}
	
}
