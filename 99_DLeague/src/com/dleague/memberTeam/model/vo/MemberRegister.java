package com.dleague.memberTeam.model.vo;

import java.sql.Date;

public class MemberRegister {
	String userId;
	String teamName;
	String msg;
	Date registerDate;
	String YN;
	
	public MemberRegister() {}
	public MemberRegister(String userId, String teamName, String msg, Date registerDate, String yN) {
		this.userId = userId;
		this.teamName = teamName;
		this.msg = msg;
		this.registerDate = registerDate;
		YN = yN;
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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getYN() {
		return YN;
	}

	public void setYN(String yN) {
		YN = yN;
	}

	@Override
	public String toString() {
		return "MemberResiter [userId=" + userId + ", teamName=" + teamName + ", msg=" + msg + ", registerDate="
				+ registerDate + ", YN=" + YN + "]";
	}
}
