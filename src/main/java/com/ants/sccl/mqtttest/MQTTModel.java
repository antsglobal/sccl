package com.ants.sccl.mqtttest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.stereotype.Component;


@Entity
@Table(name="Test_MQTT")
@Component
public class MQTTModel {
	
	@Id
	@Column(name="Id")
	private int id;
	
	@Column(name="Device_Id")
	private String deviceId;
	
	@Column(name="Topic")
	private String deviceTopic;	
	
	@Column(name="Messages")
	private String message;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceTopic() {
		return deviceTopic;
	}

	public void setDeviceTopic(String deviceTopic) {
		this.deviceTopic = deviceTopic;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
