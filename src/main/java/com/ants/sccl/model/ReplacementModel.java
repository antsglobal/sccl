package com.ants.sccl.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReplacementModel {

	private int P_part_id;
	private int P_stock_id;
	private String P_device_name;
	private String P_part_name;
	private int P_replace_quantity;
	
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date P_replacement_date;
	public int getP_part_id() {
		return P_part_id;
	}
	public void setP_part_id(int p_part_id) {
		P_part_id = p_part_id;
	}
	public int getP_stock_id() {
		return P_stock_id;
	}
	public void setP_stock_id(int p_stock_id) {
		P_stock_id = p_stock_id;
	}
	public String getP_device_name() {
		return P_device_name;
	}
	public void setP_device_name(String p_device_name) {
		P_device_name = p_device_name;
	}
	public String getP_part_name() {
		return P_part_name;
	}
	public void setP_part_name(String p_part_name) {
		P_part_name = p_part_name;
	}
	public int getP_replace_quantity() {
		return P_replace_quantity;
	}
	public void setP_replace_quantity(int p_replace_quantity) {
		P_replace_quantity = p_replace_quantity;
	}
	public Date getP_replacement_date() {
		return P_replacement_date;
	}
	public void setP_replacement_date(Date p_replacement_date) {
		P_replacement_date = p_replacement_date;
	}
	@Override
	public String toString() {
		return "ReplacementModel [P_part_id=" + P_part_id + ", P_stock_id=" + P_stock_id + ", P_device_name="
				+ P_device_name + ", P_part_name=" + P_part_name + ", P_replace_quantity=" + P_replace_quantity
				+ ", P_replacement_date=" + P_replacement_date + "]";
	}

	
	
}
