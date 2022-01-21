package com.ants.sccl.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.ants.sccl.model.DeviceMapping;


@Service
public interface DeviceMappingService {
	
	public List<DeviceMapping> getDevices(String deviceType);
	
	public DeviceMapping addDevice(DeviceMapping deviceMapping);

	public List<DeviceMapping> loaderDriller();

	public List<DeviceMapping> findAll();

}
