package com.ants.sccl.serviceimpl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ants.sccl.model.DeviceMapping;
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

	@Override
	public List<DeviceMapping> loaderDriller() {
		 System.out.println("------one in services-------");
		 List<DeviceMapping>  xyz=deviceMappingRepository.findLoaderDriller();
		 System.out.println(xyz.get(0)+"-------------");
			return xyz;
	}

	@Override
	public List<DeviceMapping> findAll() {
		
		return deviceMappingRepository.findAll();
	}
}
