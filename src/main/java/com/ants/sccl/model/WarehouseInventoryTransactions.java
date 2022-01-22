package com.ants.sccl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Warehouse_Inventory_Transactions")
public class WarehouseInventoryTransactions {
	
	@Id
	@Column(name = "Id")
	private int id;
	
	@Column(name = "Department_Name")
	private String departmentName;
	
	@Column(name = "Part_Name")
	private String partName;
	
	@Column(name = "Quantity")
	private int quantity;
	
	@Column(name = "Created_Date")
	private Date createdDate;
	
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "WarehouseInventoryTransactions [Id=" + id + ", departmentName=" + departmentName + ", partName="
				+ partName + ", quantity=" + quantity + ", createdDate=" + createdDate + "]";
	}
}
