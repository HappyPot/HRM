package com.icss.tec.tecs.pojo;

import com.icss.tec.course.pojo.Course;
import com.icss.tec.rank.pojo.Rank;

public class Tec {
	private int tecId;

	private String tecName;
	
	private String tecPwd;
	
	private Course course; // 多对一

	private Rank rank; // 多对一

	public Tec() {
		super();
	}

	public Tec(int tecId, String tecName, String tecPwd, Course course, Rank rank) {
		super();
		this.tecId = tecId;
		this.tecName = tecName;
		this.tecPwd = tecPwd;
		this.course = course;
		this.rank = rank;
	}

	public Tec(String tecName, String tecPwd, Course course, Rank rank) {
		super();
		this.tecName = tecName;
		this.tecPwd = tecPwd;
		this.course = course;
		this.rank = rank;
	}
	
	public Tec(int tecId, String tecName, Course course, Rank rank) {
		super();
		this.tecId = tecId;
		this.tecName = tecName;
		this.course = course;
		this.rank = rank;
	}

	public Tec(String tecName, Course course, Rank rank) {
		super();
		this.tecName = tecName;
		this.course = course;
		this.rank = rank;
	}

	public int getTecId() {
		return tecId;
	}

	public void setTecId(int tecId) {
		this.tecId = tecId;
	}

	public String getTecName() {
		return tecName;
	}

	public void setTecName(String tecName) {
		this.tecName = tecName;
	}

	public String getTecPwd() {
		return tecPwd;
	}

	public void setTecPwd(String tecPwd) {
		this.tecPwd = tecPwd;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Tec [tecId=" + tecId + ", tecName=" + tecName + ", tecPwd=" + tecPwd + ", course=" + course + ", rank="
				+ rank + "]";
	}



	
	
}
