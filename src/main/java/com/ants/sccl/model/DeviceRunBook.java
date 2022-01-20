package com.ants.sccl.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Device_Runbook")
public class DeviceRunBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private long deviceRunBookId;

	@Column(name="Device_Id")
	private String deviceId;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="start")
	private Timestamp startTime;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="end")
	private Timestamp endTime;

	@Column(name="longitude")
	private String longitude;

	@Column(name="latitude")
	private String latitude;

	public long getDeviceRunBookId() {
		return deviceRunBookId;
	}

	public void setDeviceRunBookId(long deviceRunBookId) {
		this.deviceRunBookId = deviceRunBookId;
	}


	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "DeviceRunBook [deviceRunBookId=" + deviceRunBookId + ", deviceId=" + deviceId + ", startTime="
				+ startTime + ", endTime=" + endTime + ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}

}
