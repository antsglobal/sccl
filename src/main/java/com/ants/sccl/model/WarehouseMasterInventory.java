package com.ants.sccl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Warehouse_Master_Inventory")
public class WarehouseMasterInventory {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="Part_Name")
	private String partName;
	
	@Column(name="Stock_available")
	private String stockAvailable;
	
	@Column(name="Brand")
	private String brand;
	
	@Column(name="Created_Date")
	private Date createdDate; 
	
	@Column(name="Updated_Date")
	private Date updatedDate;
	
	@Column(name="Remarks")
	private String remarks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getStockAvailable() {
		return stockAvailable;
	}

	public void setStockAvailable(String stockAvailable) {
		this.stockAvailable = stockAvailable;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
