package com.dleague.board.model.service;

import java.sql.Connection;
import java.util.List;

import com.dleague.board.model.dao.BoardDAO;
import com.dleague.board.model.vo.RegionBoard;
import static com.dleague.common.JDBCTemplate.*;

public class BoardService {

	public List<RegionBoard> selectAll() {;
		Connection conn = getConnection();
		List<RegionBoard> list = new BoardDAO().selectAll(conn);
		close(conn);
		return list;
	}

}
