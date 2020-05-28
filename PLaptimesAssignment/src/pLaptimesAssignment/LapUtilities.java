package pLaptimesAssignment;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class LapUtilities<Lap> {

	public static int calcAge() {
		int age = -1;

		if (getDate() != null) {
			LocalDate currentDate = LocalDate.now();
			age = Period.between(date, currentDate).getYears();
		}
		return age;
	}

	public int calcManufacturer() {
		for (Manufacturer manufacturer : Manufacturer.values()) {
			int manCount = 0;
			for (int i = 0; i < 511; i++) {
				if (manufacturer == laptimes.get(i).getManufacturer()) {
					manCount++;
				}
			}
		}
	}

	public int calcType() {
		int length = -1;

		return length;
	}
<<<<<<< HEAD

=======
	
	public static int calcMaxAge() {
		
	}
>>>>>>> 48069d4be5aadc36a61c59e579386f58518fa16e
}
