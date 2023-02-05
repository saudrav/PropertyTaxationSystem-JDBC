// Java program for the above approach

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class TestGFG {

	// Function to print difference in
	// time start_date and end_date
	static void findDifference(String start_date, String end_date) {

		// SimpleDateFormat converts the
		// string format to date object
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		// Try Block
		try {

			// parse method is used to parse
			// the text from a string to
			// produce the date
			Date d1 = sdf.parse(start_date);
			Date d2 = sdf.parse(end_date);

			// Calculate time difference
			// in milliseconds
			long difference_In_Time = d2.getTime() - d1.getTime();

			// Calculate time difference in
			// seconds, minutes, hours, years,
			// and days

			// Print the date difference in
			// years, in days, in hours, in
			// minutes, and in seconds

			System.out.print("Difference " + "between two dates is: "+difference_In_Time);
		}

		// Catch the Exception
		catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// Driver Code
	public static void main(String[] args) {
		// Given start Date
		String start_date = "2018-12-20";

		// Given end Date
		String end_date = "2018-12-19";

		// Function Call
		findDifference(start_date, end_date);
	}
}
