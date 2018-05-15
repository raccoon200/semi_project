package com.dleague.memberTeam.model.vo;

public class WaitTeam {
	private int waitNo;
	private String teamName;
	private int gameNo;
	public WaitTeam() {
	}
	public WaitTeam(int waitNo, String teamName, int gameNo) {
		this.waitNo = waitNo;
		this.teamName = teamName;
		this.gameNo = gameNo;
	}
	public int getWaitNo() {
		return waitNo;
	}
	public void setWaitNo(int waitNo) {
		this.waitNo = waitNo;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getGameNo() {
		return gameNo;
	}
	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}
	@Override
	public String toString() {
		return "WaitTeam [waitNo=" + waitNo + ", teamName=" + teamName + ", gameNo=" + gameNo + "]";
	}
	
	
}
