package pLaptimesAssignment;

import java.util.Comparator;

public class DateCompare implements Comparator<Lap>{

	@Override
	public int compare(Lap d1, Lap d2) {
		if(d1.getDate()==null && d2.getDate()==null)
			return 0;
		if(d1.getDate()==null)
			return 1;
		if(d2.getDate()==null)
			return -1;
		return d1.calculateAge()-d2.calculateAge());
	}
	

}
