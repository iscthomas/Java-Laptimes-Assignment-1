package pLaptimesAssignment;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 * @author Isaac Thomas
 * @date 1/6/2020 The LapUtitilies class is used to calculation methods using
 *       data passed from the GUI that will return values calculated to be shown
 *       to the user.
 */
public class LapUtilities {
	/**
	 * Calculates how old the specific record shown on screen in record view is.
	 * 
	 * @param laptimes is used to define the array of the dataset in the calculation
	 * @param date     is passed from the GUI to be compared to the current date.
	 * @return how old the record is in years
	 */

	public static String calcAge(ArrayList<Lap> laptimes, LocalDate date) {
		int age = -1;
		LocalDate currentDate = LocalDate.now();
		age = Period.between(date, currentDate).getYears();
		return Integer.toString(age);
	}

	/**
	 * calculates how many occurances of the type of vehicle shown in record view
	 * 
	 * @param laptimes is used to define the array of the dataset in the calculation
	 * @param type     is passed from the gui as an enum value and counted
	 * @return how many occurances of this records type there is
	 */
	public static String calcType(ArrayList<Lap> laptimes, Type type) {
		int typeCount = 0;
		for (Lap lap : laptimes) {
			if (lap.getType() == type) {
				typeCount++;
			}
		}
		return Integer.toString(typeCount);
	}

	/**
	 * 
	 * @param laptimes     is used to define the array of the dataset in the
	 *                     calculation
	 * @param manufacturer is an enum passed from the gui and counted in this method
	 * @return how many occurances of this manufacturers type there is
	 */
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
