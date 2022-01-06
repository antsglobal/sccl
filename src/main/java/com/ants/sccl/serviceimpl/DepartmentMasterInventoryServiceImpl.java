package com.ants.sccl.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ants.sccl.model.DepartmentMasterInventory;
import com.ants.sccl.repository.DepartmentMasterInventoryRepository;
import com.ants.sccl.service.DepartmentMasterInventoryService;

@Service
public class DepartmentMasterInventoryServiceImpl implements DepartmentMasterInventoryService {

	@Autowired
	DepartmentMasterInventoryRepository departmentMasterInventoryRepository;
	
//	@Override
//	public List<DepartmentMasterInventory> departmentStockFilters(DepartmentMasterInventory dmi, int pageNumber,int pageSize) {
//		
//		String departmentName = null,  brand=null,  partName=null,stockAvailable,  warehouseStock,   lastRefildate;
//		
//		if(dmi.getDepartmentName()!=null)
//			departmentName=dmi.getDepartmentName();
//		
//		if(dmi.getBrand()!=null)
//			brand=dmi.getBrand();
//		
//		if(dmi.getPartName()!=null)
//			partName=dmi.getPartName();
		
//		if(dmi.getStockAvailable()!=0)
//			stockAvailable=dmi.getStockAvailable();
//		
//		if(dmi.getWarehouseStock()!=null)
//			warehouseStock=dmi.getWarehouseStock();
//		
//		if(dmi.getLastRefillDate()!=)
//			lastRefildate=dmi.getLastRefillDate();
		
		
		
		
//		List<DepartmentMasterInventory> dmil=departmentMasterInventoryRepository.departmentStockFilter(departmentName,
//				brand,partName,dmi.getStockAvailable(),dmi.getWarehouseStock(),
//				dmi.getLastRefillDate(),pageNumber,pageSize);
//	
//		return dmil;
//	}

	@Override
	public  Page<DepartmentMasterInventory> departmentStockFilters(String dmi,Pageable paging) {
		return departmentMasterInventoryRepository.departmentStockFilter(dmi,paging);
		
	}

	
}
