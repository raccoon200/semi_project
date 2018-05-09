package com.dleague.game.model.service;

import static com.dleague.common.JDBCTemplate.*;

import java.sql.Connection;

import com.dleague.game.model.dao.GameDAO;
import com.dleague.game.model.vo.Game;

public class GameService {
	public int insertGame(Game g) {
		Connection conn = getConnection();
		int result = new GameDAO().insertGame(conn, g);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
}
