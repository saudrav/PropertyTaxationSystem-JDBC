package com.cts.propts.model;

import java.util.Date;

public class PropertyTaxPyt {

	String propertyId;
	String ownersName;
	double areaInSqFt;
	String propertyType;
	double taxAmount;
	Date dateOfPyt;
	Date dueDate;
	double revisedTaxAmt;	
	
	public PropertyTaxPyt() {
		super();
	}

	public PropertyTaxPyt(String propertyId, String ownersName, double areaInSqFt, String propertyType,
			double taxAmount, Date dateOfPyt, Date dueDate, double revisedTaxAmt) {
		super();
		this.propertyId = propertyId;
		this.ownersName = ownersName;
		this.areaInSqFt = areaInSqFt;
		this.propertyType = propertyType;
		this.taxAmount = taxAmount;
		this.dateOfPyt = dateOfPyt;
		this.dueDate = dueDate;
		this.revisedTaxAmt = revisedTaxAmt;
	}


	public String getPropertyId() {
		return propertyId;
	}


	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}


	public String getOwnersName() {
		return ownersName;
	}


	public void setOwnersName(String ownersName) {
		this.ownersName = ownersName;
	}


	public double getAreaInSqFt() {
		return areaInSqFt;
	}


	public void setAreaInSqFt(double areaInSqFt) {
		this.areaInSqFt = areaInSqFt;
	}


	public String getPropertyType() {
		return propertyType;
	}


	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}


	public double getTaxAmount() {
		return taxAmount;
	}


	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}


	public Date getDateOfPyt() {
		return dateOfPyt;
	}


	public void setDateOfPyt(Date dateOfPyt) {
		this.dateOfPyt = dateOfPyt;
	}


	public Date getDueDate() {
		return dueDate;
	}


	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}


	public double getRevisedTaxAmt() {
		return revisedTaxAmt;
	}


	public void setRevisedTaxAmt(double revisedTaxAmt) {
		this.revisedTaxAmt = revisedTaxAmt;
	}


	@Override
	public String toString() {
		return "" + propertyId + "\t\t" + ownersName + "\t\t" + areaInSqFt	+ "\t\t" + propertyType + "\t\t" + taxAmount + "\t\t" + dateOfPyt + "\t\t" + dueDate + "\t\t" + revisedTaxAmt + "";
	}	
	
}
