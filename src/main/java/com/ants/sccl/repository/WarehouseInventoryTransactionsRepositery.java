package com.ants.sccl.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ants.sccl.model.WarehouseInventoryTransactions;

@Repository
public interface WarehouseInventoryTransactionsRepositery extends JpaRepository<WarehouseInventoryTransactions, Integer> {

	@Query(value="Select *\r\n"
			+ "from SCCL_Demo.Warehouse_Inventory_Transactions\r\n"
			+ "where Created_Date between ?1 and ?2",nativeQuery = true)
	List<WarehouseInventoryTransactions> findBetweenDates(Date fromDate, Date toDate);

}
