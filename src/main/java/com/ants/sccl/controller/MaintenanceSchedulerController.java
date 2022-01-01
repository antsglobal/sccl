package com.ants.sccl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ants.sccl.model.AssetRegister;
import com.ants.sccl.model.DevicePart;
import com.ants.sccl.model.DeviceRunBook;
import com.ants.sccl.model.DeviceRunBookInputModel;
import com.ants.sccl.model.PilferageDetectionModel;
import com.ants.sccl.model.ReplacementModel;
import com.ants.sccl.projections.ReplacementViewSPModel;
import com.ants.sccl.repository.AssetRegisterRepository;
import com.ants.sccl.repository.PilferageDetectionRepository;
import com.ants.sccl.response.MessageResponse;
import com.ants.sccl.service.DeviceMappingService;
import com.ants.sccl.service.DevicePartService;
import com.ants.sccl.service.DeviceRunBookService;


@RestController
@RequestMapping("/")
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
	AssetRegisterRepository assetRegisterRepository;

	@Autowired
	DeviceMappingService deviceMappingService;

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

	//	/** this API for testing pagenation */
	//	@PostMapping("/page-nation-test-api")
	//	public ResponseEntity<MessageResponse> getTestItems(Integer pageNo, Integer pageSize, String sortBy){
	//		List<DeviceRunBook> drbl=deviceRunBookService.findAllDeviceRunBook(pageNo,pageSize,sortBy);
	//		return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(trueFlag,success,drbl)) ;
	//	}



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
}


