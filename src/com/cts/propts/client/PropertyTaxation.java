package com.cts.propts.client;

import java.io.IOException;
import java.text.ParseException;

import com.cts.propts.exception.PropertyTaxPytException;
import com.cts.propts.model.PropertyTaxPyt;
import com.cts.propts.service.PropertyTaxationService;

public class PropertyTaxation {

	public static void main(String[] args) throws PropertyTaxPytException, IOException, ParseException {
		
		PropertyTaxationService propTax = new PropertyTaxationService(); 
		
		// TYPE YOUR  CODE HERE
		
		if(propTax.addPropTaxDetails("inputfeed.txt")) {
			
			System.out.println("start");	
			
			propTax.getPropertyTaxPyt();
		}
		
	}

}
