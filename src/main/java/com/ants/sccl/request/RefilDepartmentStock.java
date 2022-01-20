package com.ants.sccl.request;

import java.util.Date;

public class RefilDepartmentStock {
	
	int id;
	String departmentName;
	String partName;
	String brand;
	String refilQuantity;
	Date RefilDate;
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
	public String getRefilQuantity() {
		return refilQuantity;
	}
	public void setRefilQuantity(String refilQuantity) {
		this.refilQuantity = refilQuantity;
	}
	public Date getRefilDate() {
		return RefilDate;
	}
	public void setRefilDate(Date refilDate) {
		RefilDate = refilDate;
	}
	@Override
	public String toString() {
		return "RefilDepartmentStock [id=" + id + ", departmentName=" + departmentName + ", partName=" + partName
				+ ", brand=" + brand + ", refilQuantity=" + refilQuantity + ", RefilDate=" + RefilDate + "]";
	}
}
