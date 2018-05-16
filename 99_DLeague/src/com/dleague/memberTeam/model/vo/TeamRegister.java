package com.dleague.memberTeam.model.vo;

import java.sql.Date;

public class TeamRegister {
	int team_register_no;
	String teamName;
	String t_register_writer;
	String regionCode;
	String introduce;
	String register_msg;
	String teamLogo;
	Date register_date;
	String status;
	int rnum;
	
	public TeamRegister() {}
	public TeamRegister(int team_register_no, String teamName, String t_register_writer, String regionCode,
			String introduce, String register_msg, String teamLogo, Date register_date, String status) {
		super();
		this.team_register_no = team_register_no;
		this.teamName = teamName;
		this.t_register_writer = t_register_writer;
		this.regionCode = regionCode;
		this.introduce = introduce;
		this.register_msg = register_msg;
		this.teamLogo = teamLogo;
		this.register_date = register_date;
		this.status = status;
	}
	public int getTeam_register_no() {
		return team_register_no;
	}
	public void setTeam_register_no(int team_register_no) {
		this.team_register_no = team_register_no;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getT_register_writer() {
		return t_register_writer;
	}
	public void setT_register_writer(String t_register_writer) {
		this.t_register_writer = t_register_writer;
	}
	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getRegister_msg() {
		return register_msg;
	}
	public void setRegister_msg(String register_msg) {
		this.register_msg = register_msg;
	}
	public String getTeamLogo() {
		return teamLogo;
	}
	public void setTeamLogo(String teamLogo) {
		this.teamLogo = teamLogo;
	}
	public Date getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	@Override
	public String toString() {
		return "[team_register_no=" + team_register_no + ", teamName=" + teamName + ", t_register_writer="
				+ t_register_writer + ", regionCode=" + regionCode + ", introduce=" + introduce + ", register_msg="
				+ register_msg + ", teamLogo=" + teamLogo + ", register_date=" + register_date + ", status=" + status
				+ ", rnum=" + rnum + "]";
	}
}
