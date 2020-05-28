package pLaptimesAssignment;

import java.util.Comparator;

public class ModelCompare  implements Comparator<Lap> {

	@Override
<<<<<<< HEAD
	public int compare(Lap m1, Lap m2) {
		if(m1.getModel()==null && m2.getModel()==null)
			return 0;
		if(m1.getModel()==null)
			return 1;
		if(m2.getModel()==null)
			return -1;
		return m1.getModel().compareTo(m2.getModel());
=======
	public int compare(Lap o1, Lap o2) {
		// TODO Auto-generated method stub
		return 0;
>>>>>>> 48069d4be5aadc36a61c59e579386f58518fa16e
	}

}
