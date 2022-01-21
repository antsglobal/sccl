package com.ants.sccl.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ants.sccl.model.DevicePart;
import com.ants.sccl.model.ReplacementModel;
import com.ants.sccl.projections.ReplacementViewSPModel;
import com.ants.sccl.repository.DevicePartRepository;
import com.ants.sccl.service.DevicePartService;

@Service
public class DevicePartServiceImpl implements DevicePartService {

	@Autowired
	DevicePartRepository devicePartRepository;

	public DevicePart deivePartReplace(DevicePart devicepart) {

		return devicePartRepository.save(devicepart);
	}

	public DevicePart deivePartCreate(DevicePart devicepart) {

		return devicePartRepository.save(devicepart);
	}

	@Override
	public List<ReplacementViewSPModel> getReplacementView(String deviceCategory) {
		List<ReplacementViewSPModel> dcr=null;
		
		try {
			
			dcr= devicePartRepository.SP_GetReplacement(deviceCategory);
		}catch (Exception e) {
			System.out.println("Exception :"+e);
			return dcr;
		}

		return dcr;
	}

	@Override
	public int saveReplacement(ReplacementModel replacementModel) {
		 return devicePartRepository.saveReplacement(replacementModel.getpId(),replacementModel.getStockId(),replacementModel.getDeviceName(),replacementModel.getPartName(),replacementModel.getReplaceQuantity(),replacementModel.getLastReplacementDate() );
	}
	
}
