package com.dleague.game.model.service;

import static com.dleague.common.JDBCTemplate.close;
import static com.dleague.common.JDBCTemplate.commit;
import static com.dleague.common.JDBCTemplate.getConnection;
import static com.dleague.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.dleague.game.model.dao.GameDAO;
import com.dleague.game.model.exception.GameException;
import com.dleague.game.model.vo.Game;
import com.dleague.search.model.vo.Activity;
import com.dleague.search.model.vo.Team;

public class GameService {
	public int insertGame(Game g) throws GameException {
		Connection conn = getConnection();
		int result = new GameDAO().insertGame(conn, g);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public int getGameCountByTeamName(String teamname) throws GameException {
		Connection conn = getConnection();
		int cnt = new GameDAO().getGameCountByTeamName(conn, teamname);
		close(conn);
		return cnt;
	}

	public List<Game> selectListByTeamName(String teamname) throws GameException {
		Connection conn = getConnection();
		List<Game> list = new GameDAO().selectListByTeamName(conn, teamname);
		close(conn);
		return list;
	}

	public Game selectOneGame(int no) throws GameException {
		Connection conn = getConnection();
		Game g = new GameDAO().selectOneGame(conn, no);
		close(conn);
		return g;
	}

	public Activity selectOneWithResult(int no) throws GameException {
		Connection conn = getConnection();
		Activity a = new GameDAO().selectOneWithResult(conn, no);
		close(conn);
		return a;
	}

	public Team selectTeamByTeamName(String teamname) throws GameException {
		Connection conn = getConnection();
		Team t = new GameDAO().selectTeamByTeamName(conn, teamname);
		close(conn);
		return t;
	}

	public int waitTeam(String teamName, int gameNo) throws GameException {
		Connection conn = getConnection();
		int result = 0;
		int check = new GameDAO().waitTeamCheck(conn, teamName, gameNo);
		if(check == 0) {
			result = new GameDAO().insertWaitTeam(conn, teamName, gameNo);
		}else if(check < 0){
			result = check;
		}
		if(result > 0) commit(conn);
		else rollback(conn);
		return result;
	}

	public int deleteGame(int gameNo) throws GameException {
		Connection conn = getConnection();
		int result = new GameDAO().deleteGame(conn, gameNo);
		if(result > 0) commit(conn);
		else rollback(conn);
		return result;
	}
}
