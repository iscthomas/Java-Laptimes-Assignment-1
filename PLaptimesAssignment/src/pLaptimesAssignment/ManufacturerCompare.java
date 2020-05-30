package pLaptimesAssignment;

import java.util.Comparator;

public class ManufacturerCompare implements Comparator<Lap> {

	@Override
	public int compare(Lap l1, Lap l2) {
		if (l1.getManufacturer() == null && l2.getManufacturer() == null)
			return 0;
		if (l1.getManufacturer() == null)
			return 1;
		if (l2.getManufacturer() == null)
			return -1;
		return l1.getManufacturer().compareTo(l2.getManufacturer());
	}

}
