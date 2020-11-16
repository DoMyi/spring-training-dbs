package com.example.demo.model;

import java.util.Date;

public class ElectricityMeter {
	
	private int id;
	private float totalBill;
	private float numberOfUnits;
	private float ratePerUnit;
	private Date dueDate;

	public ElectricityMeter(int id, float numberOfUnits, float ratePerUnit, Date dueDate) {
		super();
		this.id = id;
		this.numberOfUnits = numberOfUnits;
		this.ratePerUnit = ratePerUnit;
		this.totalBill = Math.round(numberOfUnits*ratePerUnit);
		this.setDueDate(dueDate);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(float totalBill) {
		this.totalBill = totalBill;
	}

	public float getNumberOfUnits() {
		return numberOfUnits;
	}

	public void setNumberOfUnits(float numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
	}

	public float getRatePerUnit() {
		return ratePerUnit;
	}

	public void setRatePerUnit(float ratePerUnit) {
		this.ratePerUnit = ratePerUnit;
	}

	public ElectricityMeter() {
		// TODO Auto-generated constructor stub
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

}
