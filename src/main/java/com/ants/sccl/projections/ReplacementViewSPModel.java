package com.ants.sccl.projections;

import java.util.Date;

public interface ReplacementViewSPModel {
	
	long getPId();
	
	String getStockId();
	String getDeviceName();
	String getPartName();
	String getCategory();
	int getRunHours();
	int getQuantityToBeReplaced();
	int getMaxHours();
	Double getHpPercent();
	String getHoursStatus();
	int getStockAvailable();
	String getBrand();
	String getUnits();
	Date getLastReplacementDate();
}
