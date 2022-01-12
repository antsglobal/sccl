package com.ants.sccl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ants.sccl.model.WarehouseMasterInventory;

@Repository
public interface WarehouseMasterInventoryRepository extends JpaRepository<WarehouseMasterInventory, Integer> {

	@Query(value = "call SP_Add_Warehouse_Stocks(:P_Part_Name ,:P_Brand,:P_Quantity)",nativeQuery = true)
	void addWarehouseInventory(String P_Part_Name, String P_Brand, String P_Quantity);
	
}
