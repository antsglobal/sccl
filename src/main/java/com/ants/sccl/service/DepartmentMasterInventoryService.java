package com.ants.sccl.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ants.sccl.model.DepartmentMasterInventory;
import com.ants.sccl.request.RefilDepartmentStock;

@Service
public interface DepartmentMasterInventoryService {

	//public List<DepartmentMasterInventory> departmentStockFilters(DepartmentMasterInventory dmi,int pageNumber,int pageSize);
	public Page<DepartmentMasterInventory> departmentStockFilters(String dmi,Pageable paging);
	
	
	public void departmentStockService(RefilDepartmentStock refilDepartmentStock );


	public List<DepartmentMasterInventory> departmentStockFilters(String stockInput);
}
