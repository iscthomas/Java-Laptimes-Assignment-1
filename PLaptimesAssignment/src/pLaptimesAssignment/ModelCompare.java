package pLaptimesAssignment;

import java.util.Comparator;

/**
 * @author Isaac Thomas
 * @date 1/6/2020 The ModelCompare class is used by the program to compare
 *       Models in the laptimes array to sort the data by model alphabetically.
 */
public class ModelCompare implements Comparator<Lap> {

	@Override
	public int compare(Lap m1, Lap m2) {
		if (m1.getModel() == null && m2.getModel() == null)
			return 0;
		if (m1.getModel() == null)
			return 1;
		if (m2.getModel() == null)
			return -1;
		return m1.getModel().compareTo(m2.getModel());
	}

}
