package pLaptimesAssignment;

import java.util.ArrayList;

public class LaptimesApp {
	/** Creates a new instance of LaptimesApp */
	public LaptimesApp() {

	}

	/**
	 * creates the arraylist based on the base Lap class and loads the lapreader
	 * class into the arraylist
	 */
	public static void main(String[] args) {
		ArrayList<Lap> laptimes = new ArrayList<Lap>();
		LapReader.load(laptimes);
/**
 * initializes the app class launching the GUI with the 
 */
		LapGUI gui = new LapGUI(laptimes);
		gui.setVisible(true);
	}
}
