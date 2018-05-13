package com.dleague.board.model.vo;

import java.sql.Date;

public class FreeBoardComment {
	private int board_free_comment_no;
	private int board_free_comment_level;
	private String board_free_comment_writer;
	private String board_free_comment_content;
	private int board_free_ref;
	private int board_free_comment_ref;
	private Date board_free_comment_date;
	
	public FreeBoardComment() {}

	
	
	public FreeBoardComment(int board_free_comment_no, int board_free_comment_level, String board_free_comment_writer,
			String board_free_comment_content, int board_free_ref, int board_free_comment_ref,
			Date board_free_comment_date) {
		super();
		this.board_free_comment_no = board_free_comment_no;
		this.board_free_comment_level = board_free_comment_level;
		this.board_free_comment_writer = board_free_comment_writer;
		this.board_free_comment_content = board_free_comment_content;
		this.board_free_ref = board_free_ref;
		this.board_free_comment_ref = board_free_comment_ref;
		this.board_free_comment_date = board_free_comment_date;
	}



	public int getBoard_free_comment_no() {
		return board_free_comment_no;
	}

	public void setBoard_free_comment_no(int board_free_comment_no) {
		this.board_free_comment_no = board_free_comment_no;
	}

	public int getBoard_free_comment_level() {
		return board_free_comment_level;
	}

	public void setBoard_free_comment_level(int board_free_comment_level) {
		this.board_free_comment_level = board_free_comment_level;
	}

	public String getBoard_free_comment_writer() {
		return board_free_comment_writer;
	}

	public void setBoard_free_comment_writer(String board_free_comment_writer) {
		this.board_free_comment_writer = board_free_comment_writer;
	}

	public String getBoard_free_comment_content() {
		return board_free_comment_content;
	}

	public void setBoard_free_comment_content(String board_free_comment_content) {
		this.board_free_comment_content = board_free_comment_content;
	}

	public int getBoard_free_ref() {
		return board_free_ref;
	}

	public void setBoard_free_ref(int board_free_ref) {
		this.board_free_ref = board_free_ref;
	}

	public int getBoard_free_comment_ref() {
		return board_free_comment_ref;
	}

	public void setBoard_free_comment_ref(int board_free_comment_ref) {
		this.board_free_comment_ref = board_free_comment_ref;
	}

	public Date getBoard_free_comment_date() {
		return board_free_comment_date;
	}

	public void setBoard_free_comment_date(Date board_free_comment_date) {
		this.board_free_comment_date = board_free_comment_date;
	}
	
	
}
