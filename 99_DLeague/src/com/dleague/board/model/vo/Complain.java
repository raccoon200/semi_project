package com.dleague.board.model.vo;

import java.sql.Date;

public class Complain {
	private int complain_no;
	private String complain_title;
	private String complain_writer;
	private Date complain_date;
	private String complain_content;
	private String c_userId;
	private String c_teamname;
	private String complain_type;
	private String result;
	private Date result_date;
	
	public Complain() {}
	public Complain(int complain_no, String complain_title, String complain_writer, Date complain_date,
			String complain_content, String c_userId, String c_teamname, String complain_type, String result, Date result_date) {
		super();
		this.complain_no = complain_no;
		this.complain_title = complain_title;
		this.complain_writer = complain_writer;
		this.complain_date = complain_date;
		this.complain_content = complain_content;
		this.c_userId = c_userId;
		this.c_teamname = c_teamname;
		this.complain_type = complain_type;
		this.result = result;
		this.result_date = result_date;
	}
	public int getComplain_no() {
		return complain_no;
	}
	public void setComplain_no(int complain_no) {
		this.complain_no = complain_no;
	}
	public String getComplain_title() {
		return complain_title;
	}
	public void setComplain_title(String complain_title) {
		this.complain_title = complain_title;
	}
	public String getComplain_writer() {
		return complain_writer;
	}
	public void setComplain_writer(String complain_writer) {
		this.complain_writer = complain_writer;
	}
	public Date getComplain_date() {
		return complain_date;
	}
	public void setComplain_date(Date complain_date) {
		this.complain_date = complain_date;
	}
	public String getComplain_content() {
		return complain_content;
	}
	public void setComplain_content(String complain_content) {
		this.complain_content = complain_content;
	}
	public String getC_userId() {
		return c_userId;
	}
	public void setC_userId(String c_userId) {
		this.c_userId = c_userId;
	}
	public String getC_teamname() {
		return c_teamname;
	}
	public void setC_teamname(String c_teamname) {
		this.c_teamname = c_teamname;
	}
	public String getComplain_type() {
		return complain_type;
	}
	public void setComplain_type(String complain_type) {
		this.complain_type = complain_type;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public void setResult_Date(Date result_date) {
		this.result_date = result_date;
	}
	public Date getResult_Date() {
		return result_date;
	}
	@Override
	public String toString() {
		return "Complain [complain_no=" + complain_no + ", complain_title=" + complain_title + ", complain_writer="
				+ complain_writer + ", complain_date=" + complain_date + ", complain_content=" + complain_content
				+ ", c_userId=" + c_userId + ", c_teamname=" + c_teamname + ", complain_type=" + complain_type
				+ ", result=" + result + "]";
	}
	
	
	
}
