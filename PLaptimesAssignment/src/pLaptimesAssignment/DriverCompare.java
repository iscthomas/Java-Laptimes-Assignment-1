package pLaptimesAssignment;

import java.util.Comparator;

/**
 * @author Isaac Thomas
 * @date 1/6/2020 The DriverCompare class is used by the program to compare
 *       drivers in the laptimes array to sort the data alphabetically by driver
 *       name.
 */
public class DriverCompare implements Comparator<Lap> {

	@Override
	public int compare(Lap d1, Lap d2) {
		if (d1.getDriver() == null && d2.getDriver() == null)
			return 0;
		if (d1.getDriver() == null)
			return 1;
		if (d2.getDriver() == null)
			return -1;
		return d1.getDriver().compareTo(d2.getDriver());
	}
}
