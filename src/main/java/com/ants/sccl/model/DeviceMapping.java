package com.ants.sccl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="`IOT_Device_Mapping`")
public class DeviceMapping {

	@Id
	@Column(name="device_Id")
	private String deviceId;

	@Column(name="category")
	private String deviceCategory;

	@Column(name="mapping_Id")
	private String deviceMappingID;

	@Column(name="Status")
	private String deviceStatus;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceCategory() {
		return deviceCategory;
	}

	public void setDeviceCategory(String deviceCategory) {
		this.deviceCategory = deviceCategory;
	}

	public String getDeviceMappingID() {
		return deviceMappingID;
	}

	public void setDeviceMappingID(String deviceMappingID) {
		this.deviceMappingID = deviceMappingID;
	}

	public String getDeviceStatus() {
		return deviceStatus;
	}

	public void setDeviceStatus(String deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

	@Override
	public String toString() {
		return "DeviceMapping [deviceId=" + deviceId + ", deviceCategory=" + deviceCategory + ", deviceMappingID="
				+ deviceMappingID + ", deviceStatus=" + deviceStatus + "]";
	}

}
