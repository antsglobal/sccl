package com.ants.sccl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ants.sccl.model.WarehouseMasterInventory;
import com.ants.sccl.projections.WarehouseMasterInventoryProjection;

@Repository
public interface WarehouseMasterInventoryRepository extends JpaRepository<WarehouseMasterInventory, Integer> {

	@Query(value = "call SP_Add_Warehouse_Stocks(:P_Part_Name ,:P_Brand,:P_Quantity)",nativeQuery = true)
	void addWarehouseInventory(String P_Part_Name, String P_Brand, String P_Quantity);
	
	@Query(value="select WMI.*, PT.Units from SCCL_Demo.Warehouse_Master_Inventory WMI\r\n"
			+ "left join SCCL_Demo.Part_Types PT on WMI.Part_Name = PT.Part_Name;",nativeQuery = true)
	List<WarehouseMasterInventoryProjection> findAllInventory();
}
