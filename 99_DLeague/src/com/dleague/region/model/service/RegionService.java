package com.dleague.region.model.service;


import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

import com.dleague.region.model.dao.RegionDAO;
import com.dleague.region.model.vo.Region;
import static com.dleague.common.JDBCTemplate.*;

public class RegionService {


	public List<Region> selectRegionList() {
		Connection conn = getConnection();
		List<Region> regionList = new RegionDAO().selectRegionList(conn);
		close(conn);
		return regionList;
	}

}
