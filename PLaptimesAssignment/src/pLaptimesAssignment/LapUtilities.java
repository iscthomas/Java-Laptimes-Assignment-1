package pLaptimesAssignment;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class LapUtilities {

	public static int calcAge(ArrayList<Lap> laptimes) {
		int age = -1;
		LocalDate currentDate = LocalDate.now();
		age = Period.between(Date,  currentDate).getYears();
		return age;
		}

	public static int calcManufacturer(ArrayList<Lap> laptimes) {
		int manCount = 0;
		for (Manufacturer manufacturer : Manufacturer.values()) {
			for (int i = 0; i < laptimes.size(); i++) {
				if (manufacturer == laptimes.get(i).getManufacturer()) {
					manCount++;
				}
			}
		}
		return manCount;
	}

	public static int calcType(ArrayList<Lap> laptimes, String text) {
		int typeCount = 0;
		Type type = Type.valueOf(text);
		for (Type type : Type.values()) {
			for (int i = 0; i < laptimes.size(); i++) {
				if (type == laptimes.get(i).getType()) {
					typeCount++;
				}
			}
		}
		return typeCount;
	}
}
