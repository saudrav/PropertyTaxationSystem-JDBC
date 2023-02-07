package com.cts.propts.client;

import com.cts.propts.exception.PropertyTaxPytException;
import com.cts.propts.service.PropertyTaxationService;

public class PropertyTaxation {

	public static void main(String[] args) throws PropertyTaxPytException {
		
		PropertyTaxationService propTax = new PropertyTaxationService(); 
		
		// TYPE YOUR  CODE HERE		
		if(propTax.addPropTaxDetails("inputfeed.txt")) {
			
			//System.out.println("start");			
			propTax.getPropertyTaxPyt();
		}
		
	}

}
