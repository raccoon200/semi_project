package com.dleague.region.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.dleague.board.model.vo.RegionBoard;
import com.dleague.region.model.vo.Region;

import static com.dleague.common.JDBCTemplate.*;


public class RegionDAO {
	Properties prop = new Properties();
	
	public RegionDAO() {
		String fileName = RegionDAO.class.getResource("/sql/region/region-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Region> selectRegionList(Connection conn) {
		List<Region> regionList = new ArrayList<Region>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		//String query = prop.getProperty("selectRegionMap");
		String query = "select * from region";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Region region = new Region();
				region.setRegionCode(rset.getString("regioncode"));
				region.setRegionName(rset.getString("regionname"));
				
				regionList.add(region);
			
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return regionList;
	}


	
}
