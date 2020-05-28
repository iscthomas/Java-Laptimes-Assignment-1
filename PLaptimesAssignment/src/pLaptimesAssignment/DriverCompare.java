package pLaptimesAssignment;

import java.util.Comparator;

public class DriverCompare  implements Comparator<Lap> {

	@Override
<<<<<<< HEAD
	public int compare(Lap d1, Lap d2) {
		if(d1.getDriver()==null && d2.getDriver()==null)
			return 0;
		if(d1.getDriver()==null)
			return 1;
		if(d2.getDriver()==null)
			return -1;
		return d1.getDriver().compareTo(d2.getDriver());
	}
}

=======
	public int compare(Lap o1, Lap o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
>>>>>>> 48069d4be5aadc36a61c59e579386f58518fa16e
