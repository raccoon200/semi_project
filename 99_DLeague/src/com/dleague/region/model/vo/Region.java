package com.dleague.region.model.vo;

public class Region {
	private String RegionCode;
	private String regionName;
	
	public Region() {}
	public Region(String regionCode, String regionName) {
		super();
		RegionCode = regionCode;
		this.regionName = regionName;
	}
	public String getRegionCode() {
		return RegionCode;
	}
	public void setRegionCode(String regionCode) {
		RegionCode = regionCode;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	@Override
	public String toString() {
		return "Region [RegionCode=" + RegionCode + ", regionName=" + regionName + "]";
	}
	
	
}
