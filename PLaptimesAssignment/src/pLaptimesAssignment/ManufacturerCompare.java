package pLaptimesAssignment;

import java.util.Comparator;

/**
 * @author Isaac Thomas
 * @date 1/6/2020 The ManufacturerCompare class is used by the program to
 *       compare Manufacturers in the laptimes array to sort the data by
 *       manufacturer alphabetically.
 */
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
