package pLaptimesAssignment;

import java.util.ArrayList;

public class LaptimesApp {
	/** Creates a new instance of LaptimesApp */
	public LaptimesApp() {
		
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main (String[] args) {
		ArrayList<Lap> laptimes = new ArrayList<Lap>();
		LapReader.load(laptimes);
		
		//Complex gui = new ComplexGui (laptimes);
		//gui.setVisible(true);
	}
}
