package com.dleague.search.model.vo;

import java.sql.Date;

public class Activity {
	private int activity_No;
	private String home;
	private String homeLogo;
	private String away;
	private String awayLogo;
	private String place;
	private Date activityDate;
	private String result;
	
	public Activity() {}

	public Activity(int activity_No, String home, String away, String place, Date activityDate, String result) {
		super();
		this.activity_No = activity_No;
		this.home = home;
		this.away = away;
		this.place = place;
		this.activityDate = activityDate;
		this.result = result;
	}

	public int getActivity_No() {
		return activity_No;
	}

	public void setActivity_No(int activity_No) {
		this.activity_No = activity_No;
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

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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
		return "Activity [activity_No=" + activity_No + ", home=" + home + ", homeLogo=" + homeLogo + ", away=" + away
				+ ", awayLogo=" + awayLogo + ", place=" + place + ", activityDate=" + activityDate + ", result="
				+ result + "]";
	}

	
	
}
