package pLaptimesAssignment;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class LapUtilities {

	public static String calcAge(ArrayList<Lap> laptimes, LocalDate date) {
		int age = -1;
		LocalDate currentDate = LocalDate.now();
		age = Period.between(date,  currentDate).getYears();
		return Integer.toString(age);
		}

	public static String calcType(ArrayList<Lap> laptimes, Type type) {
	    int typeCount = 0;
	    
	    for (Lap lap : laptimes) {
	        if (lap.getType() == type) {
	            typeCount++;
	        }
	    }
	    return Integer.toString(typeCount);
	}

	public static String calcManufacturer(ArrayList<Lap> laptimes, Manufacturer manufacturer) {
	    int typeCount = 0;
	    
	    for (Lap lap : laptimes) {
	        if (lap.getManufacturer() == manufacturer) {
	            typeCount++;
	        }
	    }
	    return Integer.toString(typeCount);
	}
}
