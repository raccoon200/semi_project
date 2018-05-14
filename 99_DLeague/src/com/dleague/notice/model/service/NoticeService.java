package com.dleague.notice.model.service;

import static com.dleague.common.JDBCTemplate.close;
import static com.dleague.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.dleague.board.model.dao.BoardDAO;
import com.dleague.board.model.vo.FreeBoard;
import com.dleague.notice.model.dao.NoticeDAO;
import com.dleague.notice.model.vo.Notice;

public class NoticeService {


	public List<Notice> selectNoticeAll(int cPage, int numPerPage, String searchValue) {
		Connection conn = getConnection();
		List<Notice> list= null;
		if(searchValue==null) {
			list = new NoticeDAO().selectAll(conn, cPage, numPerPage);
		}else {
			list = new NoticeDAO().selectSearchNoticeTitle(conn, cPage, numPerPage, searchValue);
		}
		close(conn);
		return list;
	}

	public int selectNoticeCount(String searchValue) {
		Connection conn = getConnection();
		int result = -1;
		if(searchValue!=null) 
			result = new NoticeDAO().selectNoticeCountBySearch(conn, searchValue);
		else
			result = new NoticeDAO().selectNoticeCount(conn);
		return result;
	}

}
