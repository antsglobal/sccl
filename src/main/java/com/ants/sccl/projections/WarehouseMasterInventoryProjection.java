package com.ants.sccl.projections;

import java.util.Date;

public interface WarehouseMasterInventoryProjection {
	
	 int getId();
	 String getPart_name();
	 String getStock_available();
	 String getBrand();
	 Date getCreated_date();
	 Date getUpdated_date();
	 String getRemarks();
	 String getUnits();
}
