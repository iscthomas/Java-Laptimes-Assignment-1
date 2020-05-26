package pLaptimesAssignment;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class LapUtilities <Lap> {

	public int calcAge() {
		int age = -1;
		
		if(getDate() != null)
		{
			LocalDate currentDate = LocalDate.now();
			age = Period.between(date, currentDate).getYears();
		}
		return age;
	}
	
	public int calcTime() {
		int time = -1;
		
		String s = "46:23:12";
		String[] values = s.split(":");
		// get the hours, minutes and seconds value and add it to the duration
		Duration duration = Duration.ofHours(Integer.parseInt(values[0]));
		duration = duration.plusMinutes(Integer.parseInt(values[1]));
		duration = duration.plusSeconds(Integer.parseInt(values[2]));
		return time;
	}
	
	public int calcLength() {
		int length = -1;
				
		
				
		return length;
	}
}
