package pLaptimesAssignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * @author Isaac Thomas
 * @date 1/6/2020 The LapReader class is used to read in data from a csv file
 *       and parse this data through to an arraylist. This data is formatted
 *       with comma seperators and no blank data provided to prevent errors.
 */
public class LapReader {

	public LapReader() {

	}

	/**
	 * @param laptimes creates fields for laptimes to be used in the bufferedreader
	 */
	public static void load(ArrayList<Lap> laptimes) {
		String length;
		String time;
		Type type; // make enum
		Manufacturer manufacturer; // make enum
		String model;
		String driver;
		LocalDate date;
		String line;
		/**
		 * Reads the .csv file in using a bufferedreader and parses the values from each
		 * field into the specified variables. each variable is split by a comma, and
		 * iterates a new instance of each object with a new line.
		 */
		try {
			BufferedReader in = new BufferedReader(new FileReader("LaptimesV4.csv"));
			while ((line = in.readLine()) != null) {
				String[] fields = line.split(",");
				length = fields[0];
				time = fields[1];
				/**
				 * removes first character of time string if it is "0" for cleaner data output
				 * https://stackoverflow.com/questions/4503656/java-removing-first-character-of-a-string
				 */
				time = time.startsWith("0") ? time.substring(1) : time;
				type = Type.valueOf(fields[2]);
				manufacturer = Manufacturer.valueOf(fields[3]);
				model = fields[4];
				driver = fields[5];
				date = LocalDate.parse(fields[6], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				laptimes.add(new Lap(length, time, type, manufacturer, model, driver, date));
			}
		} catch (IOException e) {
			System.out.println("There was a problem with the file");
			e.printStackTrace();
		}
		for (Lap item : laptimes) {
		}
	}

}
