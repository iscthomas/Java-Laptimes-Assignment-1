package pLaptimesAssignment;

import java.time.LocalDate;

public class Lap implements Comparable<Lap>{
	
	private String length;
	private String time;
	private String type; //make enum
	private String manufacturer; //make enum
	private String model;
	private String driver;
	private String date; //make LocalDate


		Lap(String length, String time, String type, String manufacturer, String model, String driver, String date) {
			
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
		public void setType(String type) {this.type = type;}
		public void setManufacturer(String manufacturer) {this.manufacturer = manufacturer;}
		public void setModel(String model){this.model = model;}
		public void setDriver(String driver){this.driver = driver;}
		public void setDate(String date){this.date = date;}
		
		public String getLength(){return length;}
		public String getTime(){return time;}
		public String getType() {return type;}
		public String getManufacturer() {return manufacturer;}
		public String getModel(){return model;}
		public String getDriver(){return driver;}
		public String getDate(){return date;}
	        
	    public String toString(){
	        return length +" "+ time +" "+ type +" "+ manufacturer + " "+ model + " "+ driver + " "+ date + "\n";
	        }

		@Override
		public int compareTo(Lap o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
