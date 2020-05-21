package pLaptimesAssignment;

import java.time.LocalDate;

public class Lap implements Comparable<Lap>{
	
	private String length;
	private String time;
	private Type type; //make enum
	private String manufacturer; //make enum
	private String model;
	private String driver;
	private LocalDate date; //make LocalDate


		Lap(String length, String time, Type type, String manufacturer, String model, String driver, LocalDate date) {
			
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
		public void setManufacturer(String manufacturer) {this.manufacturer = manufacturer;}
		public void setModel(String model){this.model = model;}
		public void setDriver(String driver){this.driver = driver;}
		public void setDate(LocalDate date){this.date = date;}
		
		public String getLength(){return length;}
		public String getTime(){return time;}
		public Type getType() {return type;}
		public String getManufacturer() {return manufacturer;}
		public String getModel(){return model;}
		public String getDriver(){return driver;}
		public LocalDate getDate(){return date;}
	        
	    public String toString(){
	        return length +" "+ time +" "+ type +" "+ manufacturer + " "+ model + " "+ driver + " "+ date + "\n";
	        }

		@Override
		public int compareTo(Lap o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
