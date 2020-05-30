package pLaptimesAssignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;


public class LapReader {
	
	// Creates a new instance of LapReader
	
	public LapReader() {
		
	}

	public static void load(ArrayList<Lap> laptimes) {
		String length;
		String time;
		Type type; //make enum
		Manufacturer manufacturer; //make enum
		String model;
		String driver;
		LocalDate date;
		String line;
		
		try {
			BufferedReader in = new BufferedReader(new FileReader("LaptimesV4.csv"));
			while ((line = in.readLine()) != null) {
				String[] fields = line.split(",");
				length = fields[0];
				time = fields[1];
				//removes first character of time string if it is "0" for cleaner data output
				time = time.startsWith("0") ? time.substring(1) : time; //https://stackoverflow.com/questions/4503656/java-removing-first-character-of-a-string
				type = Type.valueOf(fields[2]);
				manufacturer = Manufacturer.valueOf(fields[3]);
				model = fields[4];
				driver = fields[5];
				date = LocalDate.parse(fields[6], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				laptimes.add(new Lap(length, time, type, manufacturer, model, driver, date));
			}
		}catch (IOException e)
		{
			System.out.println("There was a problem with the file");
			e.printStackTrace();
		}
		for (Lap item:laptimes)
		{
			//System.out.println(laptimes);
		}
	}

}
