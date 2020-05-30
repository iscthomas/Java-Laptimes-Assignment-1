package pLaptimesAssignment;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class LapUtilities {

	public static int calcAge(ArrayList<Lap> laptimes) {
		int age = -1;
		for (int i = 0; i < laptimes.size(); i++) {
			LocalDate currentDate = LocalDate.now();
			age = Period.between(laptimes.get(i).getDate(), currentDate).getYears();
		}
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

	public static int calcType(ArrayList<Lap> laptimes) {
		int typeCount = 0;
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
