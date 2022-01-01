package com.ants.sccl.serviceimpl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ants.sccl.model.DeviceMapping;
import com.ants.sccl.projections.ReplacementViewSPModel;
import com.ants.sccl.repository.DeviceMappingRepository;
import com.ants.sccl.service.DeviceMappingService;
@Service
public class DeviceMappingServiceimpl implements DeviceMappingService {
	
	DeviceMappingRepository deviceMappingRepository;
	
	@Override
	public List<DeviceMapping> getDevices(String deviceType) {
		
		return null;
	}

	@Override
	public DeviceMapping addDevice(DeviceMapping deviceMapping) {
		
		return null;
	}

//	@Override
//	public List<ReplacementViewSPModel> getReplacementView(String deviceCatagory) {
//		List<ReplacementViewSPModel> dcr=null;
//		try {
//			dcr= deviceMappingRepository.SP_GetReplacement(deviceCatagory);
//			System.out.println(dcr.toString()+"-----------");
//		}catch (Exception e) {
//			System.out.println("-----------"+e);
//		System.out.println("imple"+e);
//		}
//		
//		return dcr;
//	
//	}
}
