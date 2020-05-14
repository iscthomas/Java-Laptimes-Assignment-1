package pLaptimesAssignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class LapReader {
	
	// Creates a new instance of LapReader
	
	public LapReader() {
		
	}
	public static void load(ArrayList<Lap> laptimes) {
		String length;
		String time;
		String type; //make enum
		String manufacturer; //make enum
		String model;
		String driver;
		String date; //make LocalDate
		String line;
		
		try {
			BufferedReader in = new BufferedReader(new FileReader("LaptimesV1.csv"));
			while ((line = in.readLine()) != null) {
				String[] fields = line.split(",");
				length = fields[0];
				time = fields[1];
				type = fields[2];
				manufacturer = fields[3];
				model = fields[4];
				driver = fields[5];
				date = fields[6];
				laptimes.add(new Lap(length, time, type, manufacturer, model, driver, date));
			}
		}catch (IOException e)
		{
			System.out.println("There was a problem with the file");
			e.printStackTrace();
		}
		for (Lap item:laptimes)
		{
			System.out.println(laptimes);
		}
	}

}
