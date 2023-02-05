package com.cts.propts.exception;

public class PropertyTaxPytException extends Exception {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	String strMsg1;
	Throwable strMsg2;

	public PropertyTaxPytException() {
		super();
	}

	public PropertyTaxPytException(String strMsg1, Throwable strMsg2) {
		super();
		this.strMsg1 = strMsg1;
		this.strMsg2 = strMsg2;
	}

}
