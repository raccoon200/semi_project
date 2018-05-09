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


}
