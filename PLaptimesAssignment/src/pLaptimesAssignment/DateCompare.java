package pLaptimesAssignment;

import java.util.Comparator;

public class DateCompare  implements Comparator<Lap> {

	@Override
<<<<<<< HEAD
	public int compare(Lap d1, Lap d2) {
		if(d1.getDate()==null && d2.getDate()==null)
			return 0;
		if(d1.getDate()==null)
			return 1;
		if(d2.getDate()==null)
			return -1;
		return d1.getDate().compareTo(d2.getDate());
=======
	public int compare(Lap o1, Lap o2) {
		// TODO Auto-generated method stub
		return 0;
>>>>>>> 48069d4be5aadc36a61c59e579386f58518fa16e
	}

}
