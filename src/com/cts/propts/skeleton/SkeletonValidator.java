package com.cts.propts.skeleton;

import java.lang.reflect.Method;

import java.util.logging.Level;
import java.util.logging.Logger;



/**

 * 
 * This class is used to verify if the Code Skeleton is intact and not modified by participants thereby ensuring smooth auto evaluation
 *
 */
public class SkeletonValidator {

	public SkeletonValidator() {
	
		validateClassName("com.cts.propts.dao.PropertyTaxDAO");
		validateClassName("com.cts.propts.dao.DBConnectionManager");
		validateClassName("com.cts.propts.model.PropertyTaxPyt");
		validateClassName("com.cts.propts.service.PropertyTaxationService");
		validateClassName("com.cts.propts.exception.PropertyTaxPytException");
		validateClassName("com.cts.propts.util.ApplicationUtil");
		//----
		validateMethodSignature("buildPropertyTaxList:ArrayList,addPropTaxDetails:boolean,calculateTaxDiscount:double","com.cts.propts.service.PropertyTaxationService");
		validateMethodSignature("insertPropertyTaxPyt:boolean","com.cts.propts.dao.PropertyTaxDAO");
		validateMethodSignature("getInstance:DBConnectionManager,getConnection:Connection","com.cts.propts.dao.DBConnectionManager");
		

	}

	private static final Logger LOG = Logger.getLogger("SkeletonValidator");

	protected final boolean validateClassName(String className) {

		boolean iscorrect = false;
		try {
			Class.forName(className);
			iscorrect = true;
			LOG.info("Class Name " + className + " is correct");

		} catch (ClassNotFoundException e) {
			LOG.log(Level.SEVERE, "You have changed either the " + "class name/package. Use the correct package "
					+ "and class name as provided in the skeleton");

		} catch (Exception e) {
			LOG.log(Level.SEVERE,
					"There is an error in validating the " + "Class Name. Please manually verify that the "
							+ "Class name is same as skeleton before uploading");
		}
		return iscorrect;

	}

	protected final void validateMethodSignature(String methodWithExcptn, String className) {
		Class cls = null;
		try {

			String[] actualmethods = methodWithExcptn.split(",");
			boolean errorFlag = false;
			String[] methodSignature;
			String methodName = null;
			String returnType = null;

			for (String singleMethod : actualmethods) {
				boolean foundMethod = false;
				methodSignature = singleMethod.split(":");

				methodName = methodSignature[0];
				returnType = methodSignature[1];
				cls = Class.forName(className);
				Method[] methods = cls.getMethods();
				for (Method findMethod : methods) {
					if (methodName.equals(findMethod.getName())) {
						foundMethod = true;
						if (!(findMethod.getReturnType().getSimpleName().equals(returnType))) {
							errorFlag = true;
							LOG.log(Level.SEVERE, " You have changed the " + "return type in '" + methodName
									+ "' method. Please stick to the " + "skeleton provided");

						} else {
							LOG.info("Method signature of " + methodName + " is valid");
						}

					}
				}
				if (!foundMethod) {
					errorFlag = true;
					LOG.log(Level.SEVERE, " Unable to find the given public method " + methodName
							+ ". Do not change the " + "given public method name. " + "Verify it with the skeleton");
				}

			}
			if (!errorFlag) {
				LOG.info("Method signature is valid");
			}

		} catch (Exception e) {
			LOG.log(Level.SEVERE,
					" There is an error in validating the " + "method structure. Please manually verify that the "
							+ "Method signature is same as the skeleton before uploading");
		}
	}

}
