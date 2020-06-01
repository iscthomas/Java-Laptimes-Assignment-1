package pLaptimesAssignment;

import java.util.Comparator;

/**
 * @author Isaac Thomas
 * @date 1/6/2020 The LengthCompare class is used by the program to compare the
 *       track length in the laptimes array to sort the data by track length
 *       from shortest to longest.
 */

public class LengthCompare implements Comparator<Lap> {
	@Override

	public int compare(Lap l1, Lap l2) {
		if (l1.getLength() == null && l2.getLength() == null)
			return 0;
		if (l1.getLength() == null)
			return 1;
		if (l2.getLength() == null)
			return -1;
		return l1.getLength().compareTo(l2.getLength());
	}

}
