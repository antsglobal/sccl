package com.ants.sccl.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ants.sccl.model.DeviceMapping;
import com.ants.sccl.projections.ReplacementViewSPModel;

@Service
public interface DeviceMappingService {
	
	public List<DeviceMapping> getDevices(String deviceType);
	
	public DeviceMapping addDevice(DeviceMapping deviceMapping);

//	public List<ReplacementViewSPModel> getReplacementView(String deviceCatagory);

}
