package com.dleague.memberTeam.model.vo;

import java.sql.Date;

public class Team {
	private String teamName;
	private String regionCode;
	private String capTain;
	private String teamLogo;
	private String introduce;
	private Date foundingDate;
	private String status;
	private int rnum;
	
	public Team() {}
	
	public Team(String teamName, String regionCode, String capTain, String teamLogo, String introduce,
			Date foundingDate, String status, int rnum) {
		super();
		this.teamName = teamName;
		this.regionCode = regionCode;
		this.capTain = capTain;
		this.teamLogo = teamLogo;
		this.introduce = introduce;
		this.foundingDate = foundingDate;
		this.status = status;
		this.rnum = rnum;
	}

	public Team(String teamName, String regionCode, String capTain, String teamLogo, String introduce, Date foundinDate,
			String status) {
		super();
		this.teamName = teamName;
		this.regionCode = regionCode;
		this.capTain = capTain;
		this.teamLogo = teamLogo;
		this.introduce = introduce;
		this.foundingDate = foundinDate;
		this.status = status;
	}
	
	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getCapTain() {
		return capTain;
	}

	public void setCapTain(String capTain) {
		this.capTain = capTain;
	}

	public String getTeamLogo() {
		return teamLogo;
	}

	public void setTeamLogo(String teamLogo) {
		this.teamLogo = teamLogo;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Date getFoundingDate() {
		return foundingDate;
	}

	public void setFoundingDate(Date foundinDate) {
		this.foundingDate = foundinDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "[teamName=" + teamName + ", regionCode=" + regionCode + ", capTain=" + capTain + ", teamLogo="
				+ teamLogo + ", introduce=" + introduce + ", foundingDate=" + foundingDate + ", status=" + status
				+ ", rnum=" + rnum + "]";
	}
	

}
