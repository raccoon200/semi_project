package com.dleague.board.model.vo;

import java.sql.Date;

public class FreeBoard {
	private int board_free_no;
	private String board_free_title;
	private String board_free_writer;
	private String board_free_content;
	private Date board_free_date;
	private String original_file_name;
	private String renamed_file_name;
	private String status;
	private int count;
	
	public FreeBoard() {}
	public FreeBoard(int board_free_no, String board_free_title, String board_free_writer, String board_free_content,
			Date board_free_date, String original_file_name, String renamed_file_name, String status, int count) {
		super();
		this.board_free_no = board_free_no;
		this.board_free_title = board_free_title;
		this.board_free_writer = board_free_writer;
		this.board_free_content = board_free_content;
		this.board_free_date = board_free_date;
		this.original_file_name = original_file_name;
		this.renamed_file_name = renamed_file_name;
		this.status = status;
		this.count = count;
	}
	public int getBoard_free_no() {
		return board_free_no;
	}
	public void setBoard_free_no(int board_free_no) {
		this.board_free_no = board_free_no;
	}
	public String getBoard_free_title() {
		return board_free_title;
	}
	public void setBoard_free_title(String board_free_title) {
		this.board_free_title = board_free_title;
	}
	public String getBoard_free_writer() {
		return board_free_writer;
	}
	public void setBoard_free_writer(String board_free_writer) {
		this.board_free_writer = board_free_writer;
	}
	public String getBoard_free_content() {
		return board_free_content;
	}
	public void setBoard_free_content(String board_free_content) {
		this.board_free_content = board_free_content;
	}
	public Date getBoard_free_date() {
		return board_free_date;
	}
	public void setBoard_free_date(Date board_free_date) {
		this.board_free_date = board_free_date;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
