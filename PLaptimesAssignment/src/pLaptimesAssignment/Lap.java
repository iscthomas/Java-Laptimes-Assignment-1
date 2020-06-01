package pLaptimesAssignment;

import java.time.LocalDate;

/**
 * @author Isaac Thomas
 * @date 1/6/2020 
 * The Lap class is the base class for the laptimes program, 
 * this class creates a Lap object to be stored in the laptimes array. 
 * all of the data pertaining to the dataset is defined here.
 */
public class Lap implements Comparable<Lap>{
	
	private String length;
	private String time;
	private Type type; //make enum
	private Manufacturer manufacturer; //make enum
	private String model;
	/**
	 * 
	 */
	private String driver;
	private LocalDate date; //make LocalDate



	/**
	 * @param length		is the length of the track in km
	 * @param time   	    is the time set by the car for each lap, this is the main variable for the basis of the dataset (laptime records)
	 * @param type			type of vehicle used for the record, enum value.
	 * @param manufacturer	manufacturer of the vehicle used for the record lap, enum value.
	 * @param model			model of vehicle in the record.
	 * @param driver		driver of the vehicle, can be multiple if it was during a race/racing laptime.
	 * @param date			Localdate value of date record was set, some records may have default dates set if only year or month was specified.
	 */
		Lap(String length, String time, Type type, Manufacturer manufacturer, String model, String driver, LocalDate date) {
			
			this.length = length;
			this.time = time;
			this.type = type;
			this.manufacturer = manufacturer;
			this.model = model;
			this.driver = driver;
			this.date = date;
			}
		
		public void setLength(String length){this.length = length;}
		public void setTime(String time){this.time = time;}
		public void setType(Type type) {this.type = type;}
		public void setManufacturer(Manufacturer manufacturer) {this.manufacturer = manufacturer;}
		public void setModel(String model){this.model = model;}
		public void setDriver(String driver){this.driver = driver;}
		public void setDate(LocalDate date){this.date = date;}
		
		public String getLength(){return length;}
		public String getTime(){return time;}
		public Type getType() {return type;}
		public Manufacturer getManufacturer() {return manufacturer;}
		public String getModel(){return model;}
		public String getDriver(){return driver;}
		public LocalDate getDate(){return date;}
	        
	    /**
	     * @return a string that can be useful for debugging via console output of each record in the array.
	     */
	    public String toString(){
	        return length +" "+ time +" "+ type +" "+ manufacturer + " "+ model + " "+ driver + " "+ date + "\n";
	        }

		/**
		 * sorts the records by time, and date (by earliest date set) if time is the same, 
		 * favours older records over new ones as they were set first
		 */
		@Override
		public int compareTo(Lap l1) {
			if (time.equals(l1.getTime()))
				return date.compareTo(l1.getDate());
			else
				return time.compareTo(l1.getTime());
		}
		
	}
