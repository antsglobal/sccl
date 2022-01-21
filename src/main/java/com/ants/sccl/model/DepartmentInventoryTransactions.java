package com.ants.sccl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Department_Inventory_Transactions")
public class DepartmentInventoryTransactions {
	
	@Id
	@Column(name="Id")
	private int id;
	
	@Column(name="Device_Name")
	private String deviceName;
	
	@Column(name="Part_Name")
	private String partName;
	
	@Column(name="Quantity")
	private int Quantity;	
	
	@Column(name="Created_Date")
	private String createdDate;

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

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "DepartmentInventoryTransactions [id=" + id + ", deviceName=" + deviceName + ", partName=" + partName
				+ ", Quantity=" + Quantity + ", createdDate=" + createdDate + "]";
	}
	
}
