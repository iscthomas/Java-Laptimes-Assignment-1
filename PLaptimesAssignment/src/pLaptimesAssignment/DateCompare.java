package pLaptimesAssignment;

import java.util.Comparator;

/**
 * @author Isaac Thomas
 * @date 1/6/2020 The DateCompare class is used by the program to compare dates
 *       in the laptimes array to sort the data by date from oldest to newest.
 */
public class DateCompare implements Comparator<Lap> {

	@Override
	public int compare(Lap d1, Lap d2) {
		if (d1.getDate() == null && d2.getDate() == null)
			return 0;
		if (d1.getDate() == null)
			return 1;
		if (d2.getDate() == null)
			return -1;
		return d1.getDate().compareTo(d2.getDate());
	}

}
