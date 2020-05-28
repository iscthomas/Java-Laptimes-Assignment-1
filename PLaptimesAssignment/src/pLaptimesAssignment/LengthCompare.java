package pLaptimesAssignment;

import java.util.Comparator;

public class LengthCompare implements Comparator<Lap>   {
	@Override
	public int compare(Lap l1, Lap l2) {
		if(l1.getLength()==null && l2.getLength()==null)
			return 0;
		if(l1.getLength()==null)
			return 1;
		if(l2.getLength()==null)
			return -1;
		return l1.getLength().compareTo(l2.getLength());
	}
}
