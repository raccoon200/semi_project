package com.dleague.admin.model.service;

import java.sql.Connection;
import java.util.List;

import com.dleague.admin.model.dao.adminDAO;
import com.dleague.member.model.vo.Member;
import static com.dleague.common.JDBCTemplate.*;

public class adminService {

	public List<Member> MemberList() {
		Connection conn = getConnection();
		List<Member> list = new adminDAO().MemberList(conn);
		close(conn);
		return list;
	}

}
