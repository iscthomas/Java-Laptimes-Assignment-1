package pLaptimesAssignment;

import java.util.Comparator;

public class LengthCompare implements Comparator<Lap>   {
	@Override
<<<<<<< HEAD
	public int compare(Lap l1, Lap l2) {
		if(l1.getLength()==null && l2.getLength()==null)
			return 0;
		if(l1.getLength()==null)
			return 1;
		if(l2.getLength()==null)
			return -1;
		return l1.getLength().compareTo(l2.getLength());
=======
	public int compare(Lap o1, Lap o2) {
		// TODO Auto-generated method stub
		return 0;
>>>>>>> 48069d4be5aadc36a61c59e579386f58518fa16e
	}
}
