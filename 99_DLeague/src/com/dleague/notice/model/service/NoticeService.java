package com.dleague.notice.model.service;

import static com.dleague.common.JDBCTemplate.*;

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

	public Notice selectNoticeOne(int no) {
		Connection conn = getConnection();
		Notice notice = new NoticeDAO().selectNoticeOne(conn, no);
		close(conn);
		return notice;
	}

	public int insertNotice(Notice notice) {
		Connection conn = getConnection();
		int result = new NoticeDAO().insertNotice(conn, notice);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int selectRecentNoticeNo() {
		Connection conn = getConnection();
		int result = new NoticeDAO().selectRecentNoticeNo(conn);
		close(conn);
		return result;
	}

}
