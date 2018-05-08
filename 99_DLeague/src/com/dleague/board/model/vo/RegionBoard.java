package com.dleague.board.model.vo;

import java.sql.Date;

public class RegionBoard {
	private int board_region_no;
	private String board_region_title;
	private String board_region_writer;
	private String board_regioncode;
	private String board_region_content;
	private Date board_region_date;
	private String original_file_name;
	private String renamed_file_name;
	private String status;
	private int count;
	
	public RegionBoard() {};
	
	public RegionBoard(int board_region_no, String board_region_title, String board_region_writer,
			String board_regioncode, String board_region_content, Date board_region_date, String original_file_name,
			String renamed_file_name, String status, int count) {
		super();
		this.board_region_no = board_region_no;
		this.board_region_title = board_region_title;
		this.board_region_writer = board_region_writer;
		this.board_regioncode = board_regioncode;
		this.board_region_content = board_region_content;
		this.board_region_date = board_region_date;
		this.original_file_name = original_file_name;
		this.renamed_file_name = renamed_file_name;
		this.status = status;
		this.count = count;
	}
	public int getBoard_region_no() {
		return board_region_no;
	}
	public void setBoard_region_no(int board_region_no) {
		this.board_region_no = board_region_no;
	}
	public String getBoard_region_title() {
		return board_region_title;
	}
	public void setBoard_region_title(String board_region_title) {
		this.board_region_title = board_region_title;
	}
	public String getBoard_region_writer() {
		return board_region_writer;
	}
	public void setBoard_region_writer(String board_region_writer) {
		this.board_region_writer = board_region_writer;
	}
	public String getBoard_regioncode() {
		return board_regioncode;
	}
	public void setBoard_regioncode(String board_regioncode) {
		this.board_regioncode = board_regioncode;
	}
	public String getBoard_region_content() {
		return board_region_content;
	}
	public void setBoard_region_content(String board_region_content) {
		this.board_region_content = board_region_content;
	}
	public Date getBoard_region_date() {
		return board_region_date;
	}
	public void setBoard_region_date(Date board_region_date) {
		this.board_region_date = board_region_date;
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
