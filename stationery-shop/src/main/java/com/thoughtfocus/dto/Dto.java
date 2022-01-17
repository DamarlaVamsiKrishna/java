package com.thoughtfocus.dto;

public class Dto {
	private String name;
	private double price;
	private String type;
	private int qunatity;
	private String brandname;
	private long serialnumber;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQunatity() {
		return qunatity;
	}
	public void setQunatity(int qunatity) {
		this.qunatity = qunatity;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public long getSerialnumber() {
		return serialnumber;
	}
	public void setSerialnumber(long serialnumber) {
		this.serialnumber = serialnumber;
	}
	@Override
	public String toString() {
		return "Dto [name=" + name + ", price=" + price + ", type=" + type + ", qunatity=" + qunatity + ", brandname="
				+ brandname + ", serialnumber=" + serialnumber + "]";
	}
	
	
}
