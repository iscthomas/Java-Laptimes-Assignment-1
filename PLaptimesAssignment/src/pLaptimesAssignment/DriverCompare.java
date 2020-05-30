package pLaptimesAssignment;

import java.util.Comparator;

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
