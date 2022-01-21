package com.ants.sccl.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ants.sccl.model.DepartmentInventoryTransactions;

@Repository
public interface DepartmentInventoryTransactionsRepositery extends JpaRepository<DepartmentInventoryTransactions, Integer> {

	@Query(value="SELECT * FROM SCCL_Demo.Department_Inventory_Transactions where Created_Date between ?1 and ?2",nativeQuery = true)
	List<DepartmentInventoryTransactions> findBetweenDates(Date fromDate, Date toDate);

}
