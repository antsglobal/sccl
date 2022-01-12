package com.ants.sccl.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ants.sccl.model.WarehouseMasterInventory;
import com.ants.sccl.repository.WarehouseMasterInventoryRepository;
import com.ants.sccl.service.WarehouseMasterInventoryService;

@Service
public class WarehouseMasterInventoryServiceImpl implements WarehouseMasterInventoryService {

	@Autowired
	WarehouseMasterInventoryRepository warehouseMasterInventoryRepository;
	
	@Override
	public List<WarehouseMasterInventory> wareHouseInventoryview() {
		
		return warehouseMasterInventoryRepository.findAll();
	
		
	}

	@Override
	public void addwareHouseInventoryService(WarehouseMasterInventory warehouseMasterInventory) {
		warehouseMasterInventoryRepository.addWarehouseInventory(warehouseMasterInventory.getPartName(),warehouseMasterInventory.getBrand(),warehouseMasterInventory.getStockAvailable());
		
	}
	

}
