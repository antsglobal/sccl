package com.ants.sccl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="Device_Part_Master")
public class DevicePartMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="Device_Name")
	private String deviceName;
	
	@Column(name="Part_Name")
	private String partName;
	
	@Column(name="Part_Type")
	private String Part_Type;
	
	@Column(name="Quantity_To_Be_Replaced")
	private int QuantityToBeReplaced;
	
	@Column(name="Units")
	private String units;
	
	@Column(name="Max_Hours")
	private int maxHours;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getPart_Type() {
		return Part_Type;
	}

	public void setPart_Type(String part_Type) {
		Part_Type = part_Type;
	}

	public int getQuantityToBeReplaced() {
		return QuantityToBeReplaced;
	}

	public void setQuantityToBeReplaced(int quantityToBeReplaced) {
		QuantityToBeReplaced = quantityToBeReplaced;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public int getMaxHours() {
		return maxHours;
	}

	public void setMaxHours(int maxHours) {
		this.maxHours = maxHours;
	}
	
	

}
