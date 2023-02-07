package com.cts.propts.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cts.propts.exception.PropertyTaxPytException;

public class ApplicationUtil {

	public static List<String> readFile(String propTaxPytFile) throws PropertyTaxPytException {

		List<String> propTaxPytList = new ArrayList<String>();

		// TYPE YOUR CODE HERE
		FileReader fr;
		try {
			fr = new FileReader(propTaxPytFile);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			Date dateOfPyt = null, dueDate = null;

			while ((line = br.readLine()) != null) {
				String[] arr = line.split(",");
				dateOfPyt = stringToDateConverter(arr[5]);
				dueDate = stringToDateConverter(arr[6]);

				if (checkIfDateOfPytIsLessThanDueDate(dateOfPyt, dueDate)) {
					propTaxPytList.add(line);
				}
			}
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("readFile() : FileNotFoundException -> " + e.getMessage());
		} catch (IOException e) {
			System.out.println("readFile() : IOException -> " + e.getMessage());
		}

		return propTaxPytList;
	}

	public static java.sql.Date utilToSqlDateConverter(java.util.Date utDate) {
		java.sql.Date sqlDate = null;

		// TYPE YOUR CODE HERE
		sqlDate = new java.sql.Date(utDate.getTime());

		return sqlDate;
	}

	public static java.util.Date stringToDateConverter(String stringDate) {

		java.util.Date utDate = null;
		// TYPE YOUR CODE HERE
		try {
			utDate = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
		} catch (ParseException e) {
			System.out.println("String to Date ParseException");
		}
		return utDate;
	}

	public static boolean checkIfDateOfPytIsLessThanDueDate(Date dateOfPyt, Date dueDate) {

		// TYPE YOUR CODE HERE

		long difference_In_Time = dueDate.getTime() - dateOfPyt.getTime();
		// System.out.println(difference_In_Time);
		if (difference_In_Time > 0) {
			return true;
		}
		return false;
	}
}
