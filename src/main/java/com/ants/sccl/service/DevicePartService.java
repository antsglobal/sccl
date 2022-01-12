package com.ants.sccl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ants.sccl.model.DevicePart;
import com.ants.sccl.model.ReplacementModel;
import com.ants.sccl.projections.ReplacementViewSPModel;

@Service
public interface DevicePartService {
	
	public DevicePart deivePartReplace(DevicePart devicepart);
	
	public DevicePart deivePartCreate(DevicePart devicepart);
	
	public List<ReplacementViewSPModel> getReplacementView(String deviceCategory);
	
	public int saveReplacement(ReplacementModel replacementModel);

}