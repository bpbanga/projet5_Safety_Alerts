package com.openclassroom.projet5.utils;


import java.util.Date;
import java.util.GregorianCalendar;

public class AgeHandler {

    /*
     * Return the age, the difference between a given date and the current date in
     * year
     * 
     * @param dateString The date to check as a string in the format "DD/MM/YYYY"
     * 
     * @param currentDate The current date, use new Date() to generate it
     */
    public static int computeAge(String dateString, Date currentDate) {
	String[] dateElements = dateString.split("/");
	Date inputDate = new GregorianCalendar(Integer.parseInt(dateElements[2]), Integer.parseInt(dateElements[1]),
		Integer.parseInt(dateElements[0])).getTime();

	long timeDiffInMillies = Math.abs(currentDate.getTime() - inputDate.getTime());
	int timeDiffInYear = Math.round(timeDiffInMillies / 31556952000L);

	return timeDiffInYear;
    }
}

