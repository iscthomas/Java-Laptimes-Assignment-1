package pLaptimesAssignment;

import java.util.Comparator;

public class ModelCompare  implements Comparator<Lap> {

	@Override
	public int compare(Lap m1, Lap m2) {
		if(m1.getModel()==null && m2.getModel()==null)
			return 0;
		if(m1.getModel()==null)
			return 1;
		if(m2.getModel()==null)
			return -1;
		return m1.getModel().compareTo(m2.getModel());
	}

}
