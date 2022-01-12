package com.ants.sccl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ants.sccl.model.WarehouseMasterInventory;

@Service
public interface WarehouseMasterInventoryService {
	
	public List<WarehouseMasterInventory> wareHouseInventoryview();

	public void addwareHouseInventoryService(WarehouseMasterInventory warehouseMasterInventory);

}
