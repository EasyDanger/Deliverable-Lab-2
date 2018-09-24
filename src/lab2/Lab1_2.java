package lab2;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Lab1_2 {
// This program will read two dates entered by month, date, and year, respectively, and print the difference between those two dates in Months, days, and years. Program SHOULD be able to handle any inputs without crashing, instead looping back to previous user input opportunities. 

//The variables that are used in multiple methods should all appear here. They've been moved us here as they became necessary to use in a second method.	
	static Scanner read = new Scanner(System.in); // Calls in the scanner

//Variables to define the first user inputed date.		
	static String firstMonth;
	static String firstMonthNum;
	static int firstDate;
	static int firstYear;

//Variables to define the second user inputed date.		
	static String secMonth;
	static String secMonthNum;
	static int secDate;
	static int secYear;
	static LocalDate date;
	static LocalDate date2;

//Variables to aid formatting dates to be read by program.		
	static String firstDateString;
	static String secDateString;

	public static void main(String args[]) {

		weStarting();
		/*
		 * This program makes extensive use of distinct classes in order to provide
		 * simple returns to the tops of menus for the user in the case of an errant
		 * input. We've recently become better acquainted with loops which could have
		 * better served this function, as demonstrated in the other part of this
		 * deliverable, however, this code was completed first and the distinct methods
		 * were a cleaner option at the time.
		 */
	}

	public static void weStarting() { // This class represents the first menu allowing the user to choose to enter the
										// program.
		System.out.println(
				"Hi! We're going to calculate the difference in years, months, and days, between two dates that you're going to input. Sounds like fun, right? Go ahead and type 'y' if you're ready to start. Type 'n' if you're not ready for this sort of commitment."); // Greeting designed to explain and disarm user.
																																																																			
		String starting = read.next(); // stores the user-entered text

//Switch gives user choice to abort the program or continue.		
		switch (starting) {
		case "y":
			dateOne(); // Allows user to choose to start the program
			break;
		case "n":
			System.out.println(
					"We're sorry. We're not equipped to do anything else. Hope the rest of your day goes well, though!");
			break; // Allows user to opt out.
		default:
			System.out.println("Sorry, we don't recognize that answer. Please try again with 'y' or 'n.'");
			weStarting();
			break; // Returns user to beginning. "break" should be unnecessary.
		}
	}

	public static void dateOne() { // This allows the user to begin inputing dates. Multiple potential calls to this method exist within this method for looping purposes in the event of invalid input.
		System.out.println("Okay. We're going to start by having you enter in the month of the first date. You can enter the number of the month, or the name:");
		firstMonth = read.next(); // Accepts month of first date

		System.out.println("Now, can you give us the date (day of the month):");
		firstDate = read.nextInt(); // Accepts day of first date

//If statement handles cheeky users who try to input impossible calendar dates.
		if (firstDate > 31) {
			System.out.println(
					"Sorry, that's not a valid date number. Your date can't be higher than 31. Let's try that again.");
			dateOne(); // Will not accept dates over 31.
		} else if ((firstMonth.equals("February") || firstMonth.equals("April") || firstMonth.equals("June")
				|| firstMonth.equals("September") || firstMonth.equals("Novemeber") || firstMonth.equals("2")
				|| firstMonth.equals("4") || firstMonth.equals("6") || firstMonth.equals("9")
				|| firstMonth.equals("11")) && (firstDate > 30)) {
			System.out.println( // Will not accept date that doesn't exist in entered month.
					"Sorry, you entered too high of a number. That month doesn't have that many days. Here, let's try again from the top.");
			dateOne();
		} else {
			// That's fine. For now.
		}

		System.out.println("And, now, how about that year:");
		firstYear = read.nextInt(); // Accepts year of first date
		int lengthYear = (int) (Math.log10(firstYear) + 1); //Our methods of counting years can only handle 4 digit years. This gives a variable to check this.
		//If statement checks if year is a leap year and disallows nonexistent dates, such as non leap year February 29ths. 
		if ((((firstYear % 100 == 0) && (firstYear % 400 != 0)) || (firstYear % 4 != 0))
				&& (firstMonth.equals("February") || firstMonth.equals("2")) && (firstDate > 28)) {
			System.out.println(
					"Nice try. But there are no leap days in the year you chose. We're going back to the top. Would you kindly enter a real February date this time?");
			dateOne();
		} else if ((lengthYear > 4) || (lengthYear < 4)) {//Else if statement restricts years to 4 digits.
			System.out.println(
					"While we apreciate your interest in the far future and/or distant past (depending on how you tend to look at time, so to speak), that date's a little bit beyond the scope of this excercise. So, why don't we try this again from the beginning, huh?");
			dateOne();
		} else {
			// This is fine, keep going. Nothing needs changing if the previous conditions aren't met.
		}
		firstDateString = Integer.toString(firstDate);
//Previous line converts the date to a string to alleviate bug that occurred further down in code with program considering 2 digit integers to be in octal, rather than decimal. Following if statement simply adds an '0' to the string for formating necessities. 
		if (firstDate < 10) {
			firstDateString = "0" + firstDateString;
		} else {
			// Continue. This is messy, but works for time being.
		}
//Allows user to purposefully loop back in case of a mistaken date. 
		System.out.println("Okay. Just to make sure we've understood you correctly, the date you've entered is "
				+ firstMonth + " " + firstDate + ", " + firstYear + ". Is that correct? ('y'/'n')");
		String firstRight = read.next(); //Variable will ultimately determine whether the program progresses to the second date inputs.

		switch (firstMonth) { // This switch assigns each months string to a string format readable by the formatter.
		case "January":
			firstMonthNum = "01";
			break;
		case "1":
			firstMonthNum = "01";
			break;
		case "February":
			firstMonthNum = "02";
			break;
		case "2":
			firstMonthNum = "02";
			break;
		case "March":
			firstMonthNum = "03";
			break;
		case "3":
			firstMonthNum = "03";
			break;
		case "April":
			firstMonthNum = "04";
			break;
		case "4":
			firstMonthNum = "04";
			break;
		case "May":
			firstMonthNum = "05";
			break;
		case "5":
			firstMonthNum = "05";
			break;
		case "June":
			firstMonthNum = "06";
			break;
		case "6":
			firstMonthNum = "06";
			break;
		case "July":
			firstMonthNum = "07";
			break;
		case "7":
			firstMonthNum = "07";
			break;
		case "August":
			firstMonthNum = "08";
			break;
		case "8":
			firstMonthNum = "08";
			break;
		case "September":
			firstMonthNum = "09";
			break;
		case "9":
			firstMonthNum = "09";
			break;
		case "October":
			firstMonthNum = "10";
			break;
		case "10":
			firstMonthNum = "10";
			break;
		case "November":
			firstMonthNum = "11";
			break;
		case "11":
			firstMonthNum = "11";
			break;
		case "December":
			firstMonthNum = "12";
			break;
		case "12":
			firstMonthNum = "12";
			break;
		default:
			firstRight = "n";
			break;
		}
//This switch is how the earlier if statements with empty else statements probably should have been. 
		switch (firstRight) { // this switch simply confirms that the date was input correctly.
		case "y":
			dateTwo(); // Sends user to enter second date
			break;
		default:
			System.out.println(
					"Somthing went wrong, sorry about that. For safety, let's start from the top. Remember to put in a real month name or number. Please don't include leading zeros. And only use the number for dates (e.g. '1,' not '1st.'"); //Consider a method to allow '1st,' '2nd," etc.
			dateOne(); // returns user to start of first date entry
			break;
		}
	}

	public static void dateTwo() { // This allows the user to put in their second date. Most of the code in this method is copied form the previous method, swapping variables as necessary.
		System.out.println("Okay. So, now we need you to give us that second starting with the month:");
		secMonth = read.next(); // Accepts month of second date
		System.out.println("Now, can you give us the date (day of the month):");
		secDate = read.nextInt(); // Accepts day of second date

		if (secDate > 31) {
			System.out.println(
					"Sorry, that's not a valid date number. Your date can't be higher than 31. Let's try that again.");
			dateTwo();
		} else if ((secMonth.equals("February") || secMonth.equals("April") || secMonth.equals("June")
				|| secMonth.equals("September") || secMonth.equals("Novemeber") || secMonth.equals("4")
				|| secMonth.equals("2")	|| secMonth.equals("6") || secMonth.equals("9") || secMonth.equals("11")) && (secDate > 30)) {
			System.out.println(
					"Sorry, you entered too high of a number. Those months don't have that many days. Here, let's try again from the top.");
			dateTwo();
		} else {
			// That's fine. For now.
		}

		System.out.println("Finally, how about that second year:");
		secYear = read.nextInt(); // Accepts year of second date
		int lengthYear = (int) (Math.log10(secYear) + 1);
		if (((((secYear % 100 == 0) && (secYear % 400 != 0)) || (secYear % 4 != 0))
				&& (secMonth.equals("February") || secMonth.equals("2"))) && (secDate > 28)) {
			System.out.println(
					"Nice try. But there are no leap days in the year you chose. We're going back to redo this second date. Would you kindly enter a real February date this time?");
			dateTwo();
		} else if ((lengthYear > 4) || (lengthYear < 4)) {
			System.out.println(
					"While we apreciate your interest in the far future and/or the distant past (depending on how you consider time), that date's a little bit beyond the scope of this excercise. So, why don't we try this again from the beginning, huh?");
			dateTwo();
		} else {
			// This is fine, keep going.
		}
		secDateString = Integer.toString(secDate);

		if (secDate < 10) {
			secDateString = "0" + secDateString;
		} else {
			// Continue. This is messy, but works for time being.
		}

		System.out
				.println("Okay. Just to make sure we've understood you correctly, the date you've entered this time is "
						+ secMonth + " " + secDate + ", " + secYear + ". Is that correct? ('y'/'n')");
		String secRight = read.next();

		switch (secMonth) {
		case "January":
			secMonthNum = "01";
			break;
		case "1":
			secMonthNum = "01";
			break;
		case "February":
			secMonthNum = "02";
			break;
		case "2":
			secMonthNum = "02";
			break;
		case "March":
			secMonthNum = "03";
			break;
		case "3":
			secMonthNum = "03";
			break;
		case "April":
			secMonthNum = "04";
			break;
		case "4":
			secMonthNum = "04";
			break;
		case "May":
			secMonthNum = "05";
			break;
		case "5":
			secMonthNum = "05";
			break;
		case "June":
			secMonthNum = "06";
			break;
		case "6":
			secMonthNum = "06";
			break;
		case "July":
			secMonthNum = "07";
			break;
		case "7":
			secMonthNum = "07";
			break;
		case "August":
			secMonthNum = "08";
			break;
		case "8":
			secMonthNum = "08";
			break;
		case "September":
			secMonthNum = "09";
			break;
		case "9":
			secMonthNum = "09";
			break;
		case "October":
			secMonthNum = "10";
			break;
		case "10":
			secMonthNum = "10";
			break;
		case "November":
			secMonthNum = "11";
			break;
		case "11":
			secMonthNum = "11";
			break;
		case "December":
			secMonthNum = "12";
			break;
		case "12":
			secMonthNum = "12";
			break;
		default:
			secRight = "n";
			break;
		}

		switch (secRight) { // this switch simply confirms that the date was input correctly.
		case "y":
			allTheMath(); // moves us to where all the math is going to be performed and the answers
							// given.
			break;
		default:
			System.out.println(
					"Somthing went wrong, sorry about that. For safety, let's put in that second date again. Remember to put in a real month name or number. Please don't include leading zeros..");
			dateTwo(); // returns user to start of second date entry
			break;
		}
	}

	public static void allTheMath() { // This is where the actual calculations take place.
		//Formats the date information into a format that DateTimeFormatter can read. This is why it was necessary to give the isngle digit dates two digits and why we can only accept years between 1000 and 9999.
		String mathDate1 = firstDateString + "-" + firstMonthNum + "-" + firstYear; 
		try {//These try/catch statements were a part of the code as I originally found it when researching how to work with dates in Java. The code should not allow for an unformattable input at this point. This legacy catch is here now only in case of the event in which someone manages to intentionally do something extraordinarily clever that breaks the program.
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); //defines the format program will read as a date.
			date = LocalDate.parse(mathDate1, formatter); //Accepts the date info AS a date.

		} catch (DateTimeParseException exc) { //Last chance to atch any strange surprises.
			System.out.printf("%s is not parsable!%n", mathDate1);
			System.out.println("You've done something exceptionally clever! We don't know how, exactly, you managed to break the code in precisely this way. It's remarkable! Anyway, congrats. As a reward, you get to go all the way back up, to the top. \n \n \n");
			dateOne(); //Rewards clever users with a loop to the beginning.
		}
//Repeats all the above for the second date.
		String mathDate2 = secDateString + "-" + secMonthNum + "-" + secYear;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			date2 = LocalDate.parse(mathDate2, formatter);
		} catch (DateTimeParseException exc) {
			System.out.printf("%s is not parsable!%n", mathDate2);
			System.out.println("You've done something exceptionally clever! We don't know how, exactly, you managed to break the code in precisely this way. It's remarkable! Anyway, congrats. As a reward, you get to go all the way back up, to the top. \n \n \n");
			dateOne();
			}
//Actual comparisons.
		Period duration = Period.between(date, date2); //Takes the time period delta info from the two dates.
		int diffYear = Math.abs(duration.getYears());  //Returns the date difference in years.
		int diffMonth = Math.abs(duration.getMonths()); //Returns difference remaining in months.
		int diffDay = Math.abs(duration.getDays()); //Returns difference remaining in days.

		System.out.println("The difference between those two dates is " + diffYear + " years, " + diffMonth
				+ " months, and " + diffDay + " days."); //Gives us our answer!
	}
}