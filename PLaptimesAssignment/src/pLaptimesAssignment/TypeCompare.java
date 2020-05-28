package pLaptimesAssignment;

import java.util.Comparator;

public class TypeCompare implements Comparator<Lap> {

	@Override
	public int compare(Lap t1, Lap t2) {
		if(t1.getType()==null && t2.getType()==null)
			return 0;
		if(t1.getType()==null)
			return 1;
		if(t2.getType()==null)
			return -1;
		return t1.getType().compareTo(t2.getType());
	}

}
