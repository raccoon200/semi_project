package com.dleague.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.dleague.board.model.dao.BoardDAO;
import com.dleague.board.model.vo.Complain;
import com.dleague.board.model.vo.FreeBoard;
import com.dleague.board.model.vo.FreeBoardComment;
import com.dleague.board.model.vo.RegionBoard;
import com.dleague.board.model.vo.RegionBoardComment;

import static com.dleague.common.JDBCTemplate.*;

public class BoardService {

	public List<RegionBoard> selectAll(int cPage, int numPerPage, String regionCode, String searchType, String searchValue) {;
		Connection conn = getConnection();
		List<RegionBoard> list= null;
		if(searchValue==null) {
			list = new BoardDAO().selectAll(conn, cPage, numPerPage, regionCode);
		}else {
			if(searchType.equals("title"))
				list = new BoardDAO().selectSearchTitle(conn, cPage, numPerPage, regionCode, searchValue);
			else
				list= new BoardDAO().selectSearchId(conn, cPage, numPerPage, regionCode, searchValue);
		}
		close(conn);
		return list;
	}
	public int selectRegionBoardCount(String regionCode, String searchType, String searchValue) {
		Connection conn = getConnection();
		int count = -1;
		if(searchValue==null) {
			count = new BoardDAO().selectRegionBoardCount(conn, regionCode);
		}else {
			if(searchType.equals("title"))
				count = new BoardDAO().selectRegionBoardCountByTitle(conn, regionCode, searchValue);
			else
				count = new BoardDAO().selectRegionBoardCountById(conn, regionCode, searchValue);
		}
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
		int result = new BoardDAO().selectRecentRegionBoardNo(conn);
		close(conn);
		return result;
	}
	public int increaseRegionCount(int no) {
		Connection conn= getConnection();
		int result = new BoardDAO().increaseRegionCount(conn, no);
		close(conn);
		return result;
		
	}
	public int insertRegionBoardComment(RegionBoardComment regionBoardComment) {
		Connection conn = getConnection();
		int result = new BoardDAO().insertRegionBoardComment(conn, regionBoardComment);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	public List<RegionBoardComment> selectRegionCommentAll(int no) {
		Connection conn = getConnection();
		List<RegionBoardComment> regionbcList = new BoardDAO().selectRegionCommentAll(conn, no);
		close(conn);
		return regionbcList;
	}
	public int updateRegionBoard(RegionBoard board) {
		Connection conn = getConnection();
		int result = new BoardDAO().updateRegionBoard(conn, board);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	public int deleteRegionBoard(int no) {
		Connection conn = getConnection();
		int result = new BoardDAO().deleteRegionBoard(conn, no);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	public int deleteRegionBoardComment(int no, int del) {
		Connection conn = getConnection();
		int result = new BoardDAO().deleteRegionBoardComment(conn, no, del);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	public List<FreeBoard> selectFreeAll(int cPage, int numPerPage, String searchType, String searchValue) {
		Connection conn = getConnection();
		List<FreeBoard> list= null;
		if(searchValue==null) {
			list = new BoardDAO().selectFreeAll(conn, cPage, numPerPage);
		}else {
			if(searchType.equals("title"))
				list = new BoardDAO().selectSearchFreeTitle(conn, cPage, numPerPage, searchValue);
			else
				list= new BoardDAO().selectSearchFreeId(conn, cPage, numPerPage, searchValue);
		}
		close(conn);
		return list;
	}
	public int selectFreeBoardCount(String searchType, String searchValue) {
		Connection conn = getConnection();
		int count = -1;
		if(searchValue==null) {
			count = new BoardDAO().selectFreeBoardCount(conn);
		}else {
			if(searchType.equals("title"))
				count = new BoardDAO().selectFreeBoardCountByTitle(conn, searchValue);
			else
				count = new BoardDAO().selectFreeBoardCountById(conn, searchValue);
		}
		close(conn);
		return count;
	}
	public int insertFreeBoard(FreeBoard board) {
		Connection conn = getConnection();
		int result = new BoardDAO().insertFreeBoard(conn, board);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	public int selectRecentFreeBoardNo() {
		Connection conn = getConnection();
		int result = new BoardDAO().selectFreeBoardNo(conn);
		close(conn);
		return result;
	}
	public int increaseFreeCount(int no) {
		Connection conn= getConnection();
		int result = new BoardDAO().increaseFreeCount(conn, no);
		close(conn);
		return result;
	}
	public FreeBoard selectFreeBoardOne(int no) {
		Connection conn = getConnection();
		FreeBoard board = new BoardDAO().selectFreeBoardOne(conn, no);
		close(conn);
		return board;
	}
	public List<FreeBoardComment> selectFreeCommentAll(int no) {
		Connection conn = getConnection();
		List<FreeBoardComment> freebcList = new BoardDAO().selectFreeCommentAll(conn, no);
		close(conn);
		return freebcList;
	}
	public int updateFreeBoard(FreeBoard board) {
		Connection conn = getConnection();
		int result = new BoardDAO().updateFreeBoard(conn, board);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	public int deleteFreeBoard(int no) {
		Connection conn = getConnection();
		int result = new BoardDAO().deleteFreeBoard(conn, no);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	public int insertFreeBoardComment(FreeBoardComment freeBoardComment) {
		Connection conn = getConnection();
		int result = new BoardDAO().insertFreeBoardComment(conn, freeBoardComment);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	public int deleteFreeBoardComment(int no, int del) {
		Connection conn = getConnection();
		int result = new BoardDAO().deleteFreeBoardComment(conn, no, del);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	public List<Complain> selectComplainAll(int cPage, int numPerPage, String searchType, String searchValue) {
		Connection conn = getConnection();
		List<Complain> complainList = null;
		if("all".equals(searchType)) {
			complainList = new BoardDAO().selectComplainAll(conn, cPage, numPerPage);
		}else if("title".equals(searchType)) {
			complainList = new BoardDAO().selectComplainTitle(conn, cPage, numPerPage, searchValue);
		}else if("writer".equals(searchType)) {
			complainList = new BoardDAO().selectComplainWriter(conn, cPage, numPerPage, searchValue);
		}else if("c_userid".equals(searchType)) {
			complainList = new BoardDAO().selectComplainC_UserId(conn, cPage, numPerPage, searchValue);
		}else if("c_teamname".equals(searchType)) {
			complainList = new BoardDAO().selectComplainC_TeamName(conn, cPage, numPerPage, searchValue);
		}else {
			complainList = new BoardDAO().selectComplainAll(conn, cPage, numPerPage);
		}
		close(conn);
		return complainList;
	}
	public int selectComplainCount(String searchType, String searchValue) {
		Connection conn = getConnection();
		int result = -1;
		if("all".equals(searchType)) {
			result = new BoardDAO().selectComplainAllCount(conn);
		}else if("title".equals(searchType)) {
			result = new BoardDAO().selectComplainTitleCount(conn, searchValue);
		}else if("writer".equals(searchType)) {
			result = new BoardDAO().selectComplainWriterCount(conn, searchValue);
		}else if("c_userid".equals(searchType)) {
			result = new BoardDAO().selectComplainC_UserIdCount(conn, searchValue);
		}else if("c_teamname".equals(searchType)) {
			result = new BoardDAO().selectComplainC_TeamNameCount(conn, searchValue);
		}else {
			result = new BoardDAO().selectComplainAllCount(conn);
		}
		close(conn);
		return result;
	}
	public Complain selectComplainBoardOne(int no) {
		Connection conn = getConnection();
		Complain complainBoard = new BoardDAO().selectComplainBoardOne(conn, no);
		close(conn);
		return complainBoard;
	}
	public int insertComplain(Complain complain) {
		Connection conn = getConnection();
		int result = new BoardDAO().insertComplain(conn, complain);
		if(result>0) 
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	public int selectRecentComplainNo() {
		Connection conn = getConnection();
		int result = new BoardDAO().selectRecentComplainNo(conn);
		close(conn);
		return result;
	}
}
