package com.ants.sccl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ants.sccl.model.DepartmentInventoryTransactions;
import com.ants.sccl.model.DepartmentMasterInventory;
import com.ants.sccl.model.DeviceMapping;
import com.ants.sccl.model.DevicePart;
import com.ants.sccl.model.DeviceRunBook;
import com.ants.sccl.model.DeviceRunBookInputModel;
import com.ants.sccl.model.DumperDetails;
import com.ants.sccl.model.PagingInput;
import com.ants.sccl.model.PartTypes;
import com.ants.sccl.model.PilferageDetectionModel;
import com.ants.sccl.model.ReplacementModel;
import com.ants.sccl.model.WarehouseInventoryTransactions;
import com.ants.sccl.model.WarehouseMasterInventory;
import com.ants.sccl.projections.ReplacementViewSPModel;
import com.ants.sccl.projections.WarehouseMasterInventoryProjection;
import com.ants.sccl.repository.DepartmentInventoryTransactionsRepositery;
import com.ants.sccl.repository.DepartmentMasterInventoryRepository;
import com.ants.sccl.repository.DeviceMappingRepository;
import com.ants.sccl.repository.PartTypeRepository;
import com.ants.sccl.repository.PilferageDetectionRepository;
import com.ants.sccl.repository.WarehouseInventoryTransactionsRepositery;
import com.ants.sccl.request.RefilDepartmentStock;
import com.ants.sccl.response.MessageResponse;
import com.ants.sccl.service.DepartmentMasterInventoryService;
import com.ants.sccl.service.DeviceMappingService;
import com.ants.sccl.service.DevicePartService;
import com.ants.sccl.service.DeviceRunBookService;
import com.ants.sccl.service.WarehouseMasterInventoryService;
import com.ants.sccl.serviceimpl.DeviceMappingServiceimpl;


@RestController
@RequestMapping("api/v2")
public class MaintenanceSchedulerController {

	String trueFlag="true";
	String falseFlag="false";
	String failed="failed";
	String success="success";

	@Autowired
	DeviceRunBookService deviceRunBookService;

	@Autowired
	DevicePartService devicePartService;

	@Autowired
	PilferageDetectionRepository pilferageDetectionRepository;

	@Autowired
	DeviceMappingService deviceMappingService;
	
	@Autowired
	DeviceMappingServiceimpl deviceMappingServiceimpl;

	@Autowired
	DepartmentMasterInventoryRepository departmentMasterInventoryRepository;

	@Autowired
	DepartmentMasterInventoryService departmentMasterInventoryService;

	@Autowired
	WarehouseMasterInventoryService warehouseMasterInventoryService;

	@Autowired
	PartTypeRepository partTypeRepository;
	
	@Autowired
	WarehouseInventoryTransactionsRepositery warehouseInventoryTransactionsRepositery;
	
	@Autowired
	DepartmentInventoryTransactionsRepositery departmentInventoryTransactionsRepositery;

	/* Doc
	 * device-runbook API used for save/update Device RunBook data in Device_Runbook Table ---- */

	@PostMapping("/device-runbook")
	public ResponseEntity<MessageResponse> saveDeviceRunBook(@RequestBody DeviceRunBookInputModel deviceRunBookInputModel) {
		DeviceRunBook drb=new DeviceRunBook();

		if(deviceRunBookInputModel.getFlag()==1) {
			try {
				drb.setDeviceId(deviceRunBookInputModel.getDeviceId());
				drb.setStartTime(deviceRunBookInputModel.getTimeStamp());
				drb.setLatitude(deviceRunBookInputModel.getLatitude());
				drb.setLongitude(deviceRunBookInputModel.getLongitude());
				drb=deviceRunBookService.saveDeviceRunBook(drb);
				return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(trueFlag,"data stored success",drb));
			}catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse(falseFlag,failed,e));
			}
		}
		else if(deviceRunBookInputModel.getFlag()==0) {
			try {
				DeviceRunBook drbOne=deviceRunBookService.findDevice(deviceRunBookInputModel.getDeviceId());
				drbOne.setEndTime(deviceRunBookInputModel.getTimeStamp());
				drbOne.setLatitude(deviceRunBookInputModel.getLatitude());
				drbOne.setLongitude(deviceRunBookInputModel.getLongitude());
				drbOne=deviceRunBookService.saveDeviceRunBook(drbOne);

				return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(trueFlag,"data stored success",drbOne));
			}catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse(trueFlag,failed,e));
			}
		}
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse(falseFlag,failed,""));		
	}


	/*Doc:
	 *  device-runbook-info API used for get all device runbook data **/

	@GetMapping("/device-runbook-info")
	public ResponseEntity<MessageResponse> deviceRunBook() {

		List<DeviceRunBook> drb=deviceRunBookService.findAllDeviceRunBook();
		if(!drb.isEmpty())
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(trueFlag,success, drb)) ;
		else
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageResponse(falseFlag,failed,drb)) ;
	}


	/* Doc :
	 * Device Prilferage detection API **/

	@PostMapping("/pilferage-detection")
	public ResponseEntity<MessageResponse>  pilferageDetection(@RequestBody PilferageDetectionModel pilferageDetectionModel) {
		if(pilferageDetectionModel.getPilferageIndicator()==false) {
			PilferageDetectionModel tdm=pilferageDetectionRepository.save(pilferageDetectionModel);
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(trueFlag,success,tdm));
		}
		else
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageResponse(falseFlag,failed, pilferageDetectionModel)) ;
	}

	/* Doc:
	 * Device Part Replace API */
	@PostMapping("/device-part")
	public ResponseEntity<MessageResponse> devicePartReplace(@RequestBody DevicePart devicePart){
		try {
			if(devicePart.getId()!=0) {
				devicePart.setReplacementStatus("1");
				DevicePart devicePartReturnObj=devicePartService.deivePartReplace(devicePart);
				DevicePart deviceParttwo=null;
				if(devicePartReturnObj!=null) {

					/* creating new record in device part table **/
					DevicePart devicePartone= new DevicePart();
					devicePartone.setDeviceName(devicePart.getDeviceName());
					devicePartone.setDevicePartName(devicePart.getDevicePartName());
					devicePartone.setRunHours("0");
					devicePartone.setReplacementStatus("0");

					deviceParttwo =devicePartService.deivePartCreate(devicePartone);
				}
				return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(trueFlag,success,deviceParttwo)) ;
			}else
				return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(falseFlag,failed,"")) ;

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(falseFlag,failed,e)) ;
		}
	}
	/**
	 * This API use for getting all machines based on based on type from Device Mapping Table
	 * */
	@PostMapping("/machines")
	public ResponseEntity<MessageResponse> getMachines(@RequestParam String machineType){
		return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(trueFlag,success,"")) ;
	}

	/** This Replacement-view API is takes device category and returns replacementView elements */
	@PostMapping("/replacement-view")
	public ResponseEntity<MessageResponse> replacementView(@RequestParam String deviceCategory){
		List<ReplacementViewSPModel> dmsre=devicePartService.getReplacementView(deviceCategory);
		//List<?> dmsre=deviceMappingService.getReplacementView(deviceCategory);
		//List<DeviceRunBook> drbl=deviceRunBookService.findAllDeviceRunBook(pageNo,pageSize,sortBy);
		return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(trueFlag,success,dmsre)) ;
	}

	/** This API used for replace the parts */

	@PostMapping("/replacement")
	public ResponseEntity<MessageResponse> replacement(@RequestBody ReplacementModel replacementModel){
		int flag=0;
		try {
			flag=devicePartService.saveReplacement(replacementModel);
		}catch (Exception e) {

		}
		if(flag==1)
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(trueFlag,success,"")) ;
		else 
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(falseFlag,failed,"")) ;
	}


	@PostMapping("/department-stock-page")
	public ResponseEntity<MessageResponse> DepartmentStocksPage(@RequestBody PagingInput pageInput){

		Page<DepartmentMasterInventory>	dmiList=null;

		if(pageInput.getPageSize()<=0)
			pageInput.setPageSize(1);
		Pageable paging = PageRequest.of(pageInput.getPageNumber(), pageInput.getPageSize());

		if("ALL".equalsIgnoreCase(pageInput.getQuery())) {
			dmiList= departmentMasterInventoryRepository.findAll(paging);
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(trueFlag,success,dmiList)) ;
		}
		else {
			dmiList=departmentMasterInventoryService.departmentStockFilters(pageInput.getQuery(),paging);


			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(trueFlag,success,dmiList)) ;
		}
	}

	@PostMapping("/department-stock")
	public ResponseEntity<MessageResponse> DepartmentStocks(@RequestParam String stockInput){

		List<DepartmentMasterInventory>	dmiList=null;

		if("ALL".equalsIgnoreCase(stockInput)) {
			dmiList=departmentMasterInventoryRepository.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(trueFlag,success,dmiList)) ;
		}
		else {
			dmiList=departmentMasterInventoryService.departmentStockFilters(stockInput);


			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(trueFlag,success,dmiList)) ;
		}
	}


	/* Add Department Stock API */
	/* notes: need to know what parameters returend this stored procudured */
	@PostMapping("/refil-department-stock")
	public ResponseEntity<MessageResponse> DepartmentStocks(@RequestBody RefilDepartmentStock refilDepartmentStock ){

		departmentMasterInventoryService.departmentStockService(refilDepartmentStock);

		return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(trueFlag,success,"")) ;
	}


	/* Warehouse Stock View API */
	@GetMapping("/warehouse-inventory")
	public ResponseEntity<MessageResponse> whereHouseStock(){
		List<WarehouseMasterInventoryProjection> whiList = warehouseMasterInventoryService.wareHouseInventoryview();
		return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(trueFlag,success,whiList)) ;

	}

	/* Warehouse Stock listing API */
	@PostMapping("/add-warehouse-inventory")
	public ResponseEntity<MessageResponse> addWhereHouseStock(@RequestBody WarehouseMasterInventory warehouseMasterInventory){
		warehouseMasterInventoryService.addwareHouseInventoryService(warehouseMasterInventory);
		return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(trueFlag,success,""));

	}

	/* Part type API used for  */
	@GetMapping("/part-type")
	public ResponseEntity<MessageResponse> partType(){

		List<PartTypes> ptl=partTypeRepository.findAll();

		return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(trueFlag,success,ptl)) ;

	}
	
	/* one-1 Completed */
	@PostMapping("/warehouse-inventory-transactions")
	public ResponseEntity<MessageResponse> warehouseInventoryTransactions(@RequestBody DumperDetails dumperDetails){

		List<WarehouseInventoryTransactions> ptl=warehouseInventoryTransactionsRepositery.findBetweenDates(dumperDetails.getFromDate(),dumperDetails.getToDate());

		return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(trueFlag,success,ptl)) ;

	}
	
	/* two -2  completed */
	@PostMapping("/department-inventory-transactions")
	public ResponseEntity<MessageResponse> departmentInventoryTransactions(@RequestBody DumperDetails dumperDetails){

		List<DepartmentInventoryTransactions> ptl=departmentInventoryTransactionsRepositery.findBetweenDates(dumperDetails.getFromDate(),dumperDetails.getToDate());;

		return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(trueFlag,success,ptl)) ;

	}
	
}