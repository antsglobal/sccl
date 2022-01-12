package com.ants.sccl.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ants.sccl.model.DepartmentMasterInventory;

@Repository
public interface DepartmentMasterInventoryRepository extends JpaRepository<DepartmentMasterInventory, Integer>{

	
	//List<DepartmentMasterInventory> departmentStockFilter(DepartmentMasterInventory dmi, int pageNumber, int pageSize);
	//	@Query(value="SELECT * FROM SCCL_Demo.Department_Master_Inventory where Department_Name=?1 or Brand=?2 or Part_Name=?3 or Stock_Available=?4 or Warehouse_Stock=?5 or Last_Refill_Date=?6",nativeQuery = true)
	//	List<DepartmentMasterInventory> departmentStockFilter(String departmentName, String brand, String partName,
	//			int stockAvailable, int warehouseStock,  Date lastRefildate, int pageNumber, int pageSize);

	@Query(value="SELECT * FROM SCCL_Demo.Department_Master_Inventory where Department_Name LIKE %?1% or Brand LIKE %?1% or Part_Name LIKE %?1% or Stock_Available LIKE %?1% or Warehouse_Stock LIKE %?1% or Last_Refill_Date LIKE %?1%",nativeQuery = true)	
	Page<DepartmentMasterInventory> departmentStockFilter(String dmi,Pageable paging);
	
	@Query(value="SELECT * FROM SCCL_Demo.Department_Master_Inventory where Department_Name LIKE %?1% or Brand LIKE %?1% or Part_Name LIKE %?1% or Stock_Available LIKE %?1% or Warehouse_Stock LIKE %?1% or Last_Refill_Date LIKE %?1%",nativeQuery = true)	
	List<DepartmentMasterInventory> departmentStockFilter(String dmi);

	@Query(value="call SP_Refil_Department_Stocks(:P_Stock_Id,:P_Department_Name,\r\n"
			+ ":P_Part_Name,\r\n"
			+ ":P_Brand,\r\n"
			+ ":P_Refil_Quantity,\r\n"
			+ ":P_Refil_Date\r\n"
			+ ")", nativeQuery = true)
	void departmentStock(int P_Stock_Id,String P_Department_Name,String P_Part_Name,String P_Brand,String P_Refil_Quantity,Date P_Refil_Date);
}
