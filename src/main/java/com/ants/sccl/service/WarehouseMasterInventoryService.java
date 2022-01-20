package com.ants.sccl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ants.sccl.model.WarehouseMasterInventory;
import com.ants.sccl.projections.WarehouseMasterInventoryProjection;

@Service
public interface WarehouseMasterInventoryService {
	
	public List<WarehouseMasterInventoryProjection> wareHouseInventoryview();

	public void addwareHouseInventoryService(WarehouseMasterInventory warehouseMasterInventory);

}
