package com.dleague.memberTeam.model.vo;

import java.sql.Date;

public class TeamMember {
	private String userId;
	private String teamName;
	private Date t_EnrollDate;
	private String grade;
	private int rnum;
	private String regionCode;
	
	public TeamMember() {
		super();
	}

	public TeamMember(String userId, String teamName, Date t_EnrollDate, String grade, int rnum, String regionCode) {
		super();
		this.userId = userId;
		this.teamName = teamName;
		this.t_EnrollDate = t_EnrollDate;
		this.grade = grade;
		this.rnum = rnum;
		this.regionCode = regionCode;
	}


	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Date getT_EnrollDate() {
		return t_EnrollDate;
	}

	public void setT_EnrollDate(Date t_EnrollDate) {
		this.t_EnrollDate = t_EnrollDate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	@Override
	public String toString() {
		return "[userId=" + userId + ", teamName=" + teamName + ", t_EnrollDate=" + t_EnrollDate + ", grade="
				+ grade + ", rnum=" + rnum + ", regionCode=" + regionCode + "]";
	}
	
}
