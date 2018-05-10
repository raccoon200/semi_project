package com.dleague.game.model.vo;

import java.sql.Date;

public class Game {
	private int gameNo;
	private String home;
	private String homeLogo;
	private String away;
	private String awayLogo;
	private Date gameDate;
	private String gameDateString;
	private Date gameRegDate;
	private String place;
	private String startTime;
	private String gameContent;
	private String status;

	public Game() {}

	/**
	 * @param gameNo
	 * @param home
	 * @param away
	 * @param gameDate
	 * @param gameRegDate
	 * @param place
	 * @param startTime
	 * @param gameContent
	 */
	public Game(int gameNo, String home, String away, Date gameDate, Date gameRegDate, String place, String startTime,
			String gameContent) {
		super();
		this.gameNo = gameNo;
		this.home = home;
		this.away = away;
		this.gameDate = gameDate;
		this.gameRegDate = gameRegDate;
		this.place = place;
		this.startTime = startTime;
		this.gameContent = gameContent;
	}

	public int getGameNo() {
		return gameNo;
	}

	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getAway() {
		return away;
	}

	public void setAway(String away) {
		this.away = away;
	}

	public Date getGameDate() {
		return gameDate;
	}

	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

	public Date getGameRegDate() {
		return gameRegDate;
	}

	public void setGameRegDate(Date gameRegDate) {
		this.gameRegDate = gameRegDate;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getGameContent() {
		return gameContent;
	}

	public void setGameContent(String gameContent) {
		this.gameContent = gameContent;
	}
	public String getGameDateString() {
		return gameDateString;
	}

	public void setGameDateString(String gameDateString) {
		this.gameDateString = gameDateString;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getHomeLogo() {
		return homeLogo;
	}

	public void setHomeLogo(String homeLogo) {
		this.homeLogo = homeLogo;
	}

	public String getAwayLogo() {
		return awayLogo;
	}

	public void setAwayLogo(String awayLogo) {
		this.awayLogo = awayLogo;
	}

	@Override
	public String toString() {
		return "Game [gameNo=" + gameNo + ", home=" + home + ", homeLogo=" + homeLogo + ", away=" + away + ", awayLogo="
				+ awayLogo + ", gameDate=" + gameDate + ", gameDateString=" + gameDateString + ", gameRegDate="
				+ gameRegDate + ", place=" + place + ", startTime=" + startTime + ", gameContent=" + gameContent
				+ ", status=" + status + "]";
	}

	
}
