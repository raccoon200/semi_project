package com.dleague.board.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

import com.dleague.board.model.dao.BoardDAO;
import com.dleague.board.model.vo.RegionBoard;
import static com.dleague.common.JDBCTemplate.*;

public class BoardService {

	public List<RegionBoard> selectAll(int cPage, int numPerPage) {;
		Connection conn = getConnection();
		List<RegionBoard> list = new BoardDAO().selectAll(conn, cPage, numPerPage);
		close(conn);
		return list;
	}
	public int selectRegionBoardCount() {
		Connection conn = getConnection();
		int count = new BoardDAO().selectRegionBoardCount(conn);
		close(conn);
		return count;
	}
	public RegionBoard selectRegionBoardOne(int no) {
		Connection conn = getConnection();
		RegionBoard board = new BoardDAO().selectRegionBoardOne(conn, no);
		close(conn);
		return board;
	}
	public int insertRegionBoard(RegionBoard board) {
		Connection conn = getConnection();
		int result = new BoardDAO().insertRegionBoard(conn, board);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	public int selectRecentRegionBoardNo() {
		Connection conn = getConnection();
		int result = new BoardDAO().selectRegionBoardNo(conn);
		close(conn);
		return result;
	}

}
