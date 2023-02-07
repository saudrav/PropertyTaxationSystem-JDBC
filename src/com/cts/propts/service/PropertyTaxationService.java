package com.cts.propts.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cts.propts.dao.PropertyTaxDAO;
import com.cts.propts.exception.PropertyTaxPytException;
import com.cts.propts.model.PropertyTaxPyt;
import com.cts.propts.util.ApplicationUtil;

public class PropertyTaxationService {

	PropertyTaxDAO propertyTaxDAO = new PropertyTaxDAO();

	/*
	 * String propertyId;String ownersName;double areaInSqFt;String
	 * propertyType;double taxAmount; Date dateOfPyt;Date dueDate;double
	 * revisedTaxAmt;
	 */

	public static ArrayList<PropertyTaxPyt> buildPropertyTaxList(List<String> propTaxRecords) {

		ArrayList<PropertyTaxPyt> propTaxPytList = new ArrayList<>();

		// TYPE YOUR CODE HERE
		for (String ptr : propTaxRecords) {

			String[] arr = ptr.split(",");

			PropertyTaxPyt propertyTaxPyt = new PropertyTaxPyt();
			propertyTaxPyt.setPropertyId(arr[0]);
			propertyTaxPyt.setOwnersName(arr[1]);
			propertyTaxPyt.setAreaInSqFt(Double.parseDouble(arr[2]));
			propertyTaxPyt.setPropertyType(arr[3]);
			propertyTaxPyt.setTaxAmount(Double.parseDouble(arr[4]));
			propertyTaxPyt.setDateOfPyt(ApplicationUtil.stringToDateConverter(arr[5]));
			propertyTaxPyt.setDueDate(ApplicationUtil.stringToDateConverter(arr[6]));

			double revisedTaxAmt = calculateTaxDiscount(propertyTaxPyt.getPropertyType(),
					propertyTaxPyt.getAreaInSqFt(), propertyTaxPyt.getTaxAmount());

			propertyTaxPyt.setRevisedTaxAmt(revisedTaxAmt);

			propTaxPytList.add(propertyTaxPyt);
		}
		return propTaxPytList;
	}

	public boolean addPropTaxDetails(String inputFeed) throws PropertyTaxPytException {

		// TYPE YOUR CODE HERE
		List<String> propTaxEarlyPytList = new ArrayList<String>();

		propTaxEarlyPytList = ApplicationUtil.readFile(inputFeed);

		ArrayList<PropertyTaxPyt> propTaxPytList = new ArrayList<>();

		propTaxPytList = buildPropertyTaxList(propTaxEarlyPytList);

		return propertyTaxDAO.insertPropertyTaxPyt(propTaxPytList);
	}

	public void getPropertyTaxPyt() {

		ArrayList<PropertyTaxPyt> propTaxPytList = new ArrayList<>();

		propTaxPytList = propertyTaxDAO.getPropertyTaxPyt();

		System.out.println();
		System.out.println("propertyId\t ownersName\t areaInSqFt\t propertyType\t\t taxAmount\t dateOfPyt\t\t dueDate\t revisedTaxAmt");

		propTaxPytList.stream().forEach(System.out::println);

	}

	public static double calculateTaxDiscount(String propertyType, double areaInSqFt, double currentTaxAmt) {

		double revisedTaxAmt = 0.0;

		// TYPE YOUR CODE HERE
		if (propertyType.equalsIgnoreCase("Commercial")) {
			if (areaInSqFt <= 1000) {
				revisedTaxAmt = currentTaxAmt * 0.93;
			} else if (areaInSqFt >= 1001 && areaInSqFt <= 10000) {
				revisedTaxAmt = currentTaxAmt * 0.90;
			} else {
				revisedTaxAmt = currentTaxAmt * 0.83;
			}
		} else {
			if (areaInSqFt <= 1000) {
				revisedTaxAmt = currentTaxAmt * 0.95;
			} else if (areaInSqFt >= 1001 && areaInSqFt <= 10000) {
				revisedTaxAmt = currentTaxAmt * 0.91;
			} else {
				revisedTaxAmt = currentTaxAmt * 0.89;
			}
		}
		return revisedTaxAmt;
	}

}
