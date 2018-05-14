package com.dleague.notice.model.vo;

import java.sql.Date;

public class Notice {
	private int notice_no;
	private String notice_title;
	private String notice_writer;
	private String notice_content;
	private Date notice_date;
	private String original_file_name;
	private String renamed_file_name;
	private int status;
	
	public Notice() {}

	public Notice(int notice_no, String notice_title, String notice_writer, String notice_content, Date notice_date,
			String original_file_name, String renamed_file_name, int status) {
		super();
		this.notice_no = notice_no;
		this.notice_title = notice_title;
		this.notice_writer = notice_writer;
		this.notice_content = notice_content;
		this.notice_date = notice_date;
		this.original_file_name = original_file_name;
		this.renamed_file_name = renamed_file_name;
		this.status = status;
	}

	public int getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_writer() {
		return notice_writer;
	}

	public void setNotice_writer(String notice_writer) {
		this.notice_writer = notice_writer;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public Date getNotice_date() {
		return notice_date;
	}

	public void setNotice_date(Date notice_date) {
		this.notice_date = notice_date;
	}

	public String getOriginal_file_name() {
		return original_file_name;
	}

	public void setOriginal_file_name(String original_file_name) {
		this.original_file_name = original_file_name;
	}

	public String getRenamed_file_name() {
		return renamed_file_name;
	}

	public void setRenamed_file_name(String renamed_file_name) {
		this.renamed_file_name = renamed_file_name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
