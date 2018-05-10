package com.dleague.board.model.vo;

import java.sql.Date;

public class RegionBoardComment {
	private int board_region_comment_no;
	private int board_region_comment_level;
	private String board_region_comment_writer;
	private String board_region_comment_content;
	private int board_region_ref;
	private int board_region_comment_ref;
	private Date board_region_comment_date;
	public RegionBoardComment() {
		
	}
	public RegionBoardComment(int board_region_comment_level, String board_region_comment_writer,
			String board_region_comment_content, int board_region_ref, int board_region_comment_ref) {
		super();
		this.board_region_comment_level = board_region_comment_level;
		this.board_region_comment_writer = board_region_comment_writer;
		this.board_region_comment_content = board_region_comment_content;
		this.board_region_ref = board_region_ref;
		this.board_region_comment_ref = board_region_comment_ref;
	}
	public int getBoard_region_comment_no() {
		return board_region_comment_no;
	}
	public void setBoard_region_comment_no(int board_region_comment_no) {
		this.board_region_comment_no = board_region_comment_no;
	}
	public int getBoard_region_comment_level() {
		return board_region_comment_level;
	}
	public void setBoard_region_comment_level(int board_region_comment_level) {
		this.board_region_comment_level = board_region_comment_level;
	}
	public String getBoard_region_comment_writer() {
		return board_region_comment_writer;
	}
	public void setBoard_region_comment_writer(String board_region_comment_writer) {
		this.board_region_comment_writer = board_region_comment_writer;
	}
	public String getBoard_region_comment_content() {
		return board_region_comment_content;
	}
	public void setBoard_region_comment_content(String board_region_comment_content) {
		this.board_region_comment_content = board_region_comment_content;
	}
	public int getBoard_region_ref() {
		return board_region_ref;
	}
	public void setBoard_region_ref(int board_region_ref) {
		this.board_region_ref = board_region_ref;
	}
	public int getBoard_region_comment_ref() {
		return board_region_comment_ref;
	}
	public void setBoard_region_comment_ref(int board_region_comment_ref) {
		this.board_region_comment_ref = board_region_comment_ref;
	}
	public Date getBoard_region_comment_date() {
		return board_region_comment_date;
	}
	public void setBoard_region_comment_date(Date board_region_comment_date) {
		this.board_region_comment_date = board_region_comment_date;
	}
	@Override
	public String toString() {
		return "RegionBoardComment [board_region_comment_no=" + board_region_comment_no
				+ ", board_region_comment_level=" + board_region_comment_level + ", board_region_comment_writer="
				+ board_region_comment_writer + ", board_region_comment_content=" + board_region_comment_content
				+ ", board_region_ref=" + board_region_ref + ", board_region_comment_ref=" + board_region_comment_ref
				+ ", board_region_comment_date=" + board_region_comment_date + "]";
	}
	
	
	
}
