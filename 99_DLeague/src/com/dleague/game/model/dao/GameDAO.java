package com.dleague.game.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.dleague.game.model.vo.Game;
import static com.dleague.common.JDBCTemplate.*;
public class GameDAO {
	Properties prop = new Properties();
	
	public GameDAO() {
		String fileName = GameDAO.class.getResource("/sql/game/game-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int insertGame(Connection conn, Game g) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertGame");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, g.getHome());
			pstmt.setString(2, g.getGameDateString().substring(0, g.getGameDateString().lastIndexOf(" ")));
			pstmt.setString(3, "yyyy\"년\" mm\"월\" dd\"일\"");
			pstmt.setString(4, g.getPlace());
			pstmt.setString(5, g.getStartTime());
			pstmt.setString(6, g.getGameContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
