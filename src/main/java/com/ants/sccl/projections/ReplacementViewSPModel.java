package com.ants.sccl.projections;

public interface ReplacementViewSPModel {
	
	long getPId();
	
	String getStock_id();
	String getDevice_name();
	String getPart_name();
	String getCategory();
	int getRun_Hours();
	int getQuantity_to_be_replaced();
	int getMax_hours();
	Double getHP_percent();
	String getHours_status();
	int getStock_available();
	String getBrand();
	String getUnits();
	
}
