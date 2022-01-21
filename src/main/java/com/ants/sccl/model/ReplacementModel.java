package com.ants.sccl.model;

import java.util.Date;

public class ReplacementModel {

	private int pId;
	private int stockId;
	private String deviceName;
	private String partName;
	private int replaceQuantity;
	private Date  lastReplacementDate;
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public int getReplaceQuantity() {
		return replaceQuantity;
	}
	public void setReplaceQuantity(int replaceQuantity) {
		this.replaceQuantity = replaceQuantity;
	}
	public Date getLastReplacementDate() {
		return lastReplacementDate;
	}
	public void setLastReplacementDate(Date lastReplacementDate) {
		this.lastReplacementDate = lastReplacementDate;
	}
	@Override
	public String toString() {
		return "ReplacementModel [pId=" + pId + ", stockId=" + stockId + ", deviceName=" + deviceName + ", partName="
				+ partName + ", replaceQuantity=" + replaceQuantity + ", lastReplacementDate=" + lastReplacementDate
				+ "]";
	}
	
}
