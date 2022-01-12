package com.ants.sccl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Department_Master_Inventory")
public class DepartmentMasterInventory {

	@Id
	@Column(name="Id")
	private int id;

	@Column(name="Department_Name")
	private String departmentName;

	@Column(name="Part_Name")
	private String partName;

	@Column(name="Brand")
	private String brand;

	@Column(name="Stock_Available")
	private int stockAvailable;

	@Column(name="Warehouse_Stock")
	private int warehouseStock;

	@Column(name="Last_Refill_Date")
	private Date lastRefillDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getStockAvailable() {
		return stockAvailable;
	}

	public void setStockAvailable(int stockAvailable) {
		this.stockAvailable = stockAvailable;
	}

	public int getWarehouseStock() {
		return warehouseStock;
	}

	public void setWarehouseStock(int warehouseStock) {
		this.warehouseStock = warehouseStock;
	}

	public Date getLastRefillDate() {
		return lastRefillDate;
	}

	public void setLastRefillDate(Date lastRefillDate) {
		this.lastRefillDate = lastRefillDate;
	}

	@Override
	public String toString() {
		return "DepartmentMasterInventory [id=" + id + ", departmentName=" + departmentName + ", partName=" + partName
				+ ", brand=" + brand + ", stockAvailable=" + stockAvailable + ", warehouseStock=" + warehouseStock
				+ ", lastRefillDate=" + lastRefillDate + "]";
	}
}
