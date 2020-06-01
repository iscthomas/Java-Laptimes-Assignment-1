package pLaptimesAssignment;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Isaac Thomas
 * @date 1/6/2020 The LapUtitilies test is used to test the calculation methods
 *       found in the LapUtilities Class.
 */
class LapUtilitiesTest {

	/**
	 * Defines an array to be tested and create 3 instances of lap to be added to
	 * the array.
	 */
	ArrayList<Lap> laptimes = new ArrayList<Lap>();
	Lap One = new Lap("21.123 km", "1:23.45", Type.Production, Manufacturer.Nissan, "Test Car 123", "Test Driver",
			(LocalDate.of(1996, 9, 14)));
	Lap Two = new Lap("25.378 km", "8:09.1", Type.Racing, Manufacturer.Porsche, "Porsche 911 GT3 R (991)",
			"Laurens Vanthoor/Romain Dumas/Kevin Estre", (LocalDate.of(2018, 05, 11)));
	Lap Three = new Lap("21.123 km", "1:23.45", Type.Racing, Manufacturer.Nissan, "Test Car 123", "Test Driver",
			(LocalDate.of(2010, 11, 12)));

	/**
	 * Ensures that each laptime is added to the array before each test so the
	 * dataset is not empty.
	 */
	@BeforeEach
	void setUp() throws Exception {
		laptimes.add(One);
		laptimes.add(Two);
		laptimes.add(Three);
	}

	/**
	 * tests that the age calculation method works properly with data provided and
	 * covers the method in the util class. laptime 3 is 9 years old as it was set
	 * in 2010, (as of 1/6/2020) so it should return a value of 9 in this test.
	 */
	@Test
	void testCalcAge() {
		String expected = "9";
		assertEquals(expected, LapUtilities.calcAge(laptimes, Three.getDate()));
	}

	/**
	 * tests the type calculation method works properly with data provided and
	 * covers the method in the util class. there are 2 instances of Type.Racing in
	 * the test dataset, so this test should return a value of 2.
	 */
	@Test
	void testCalcType() {
		String expected = "2";
		assertEquals(expected, LapUtilities.calcType(laptimes, Two.getType()));
	}

	/**
	 * tests the manufacturer calculation method works properly with data provided
	 * and covers the method in the util class. there are 2 instances of
	 * Manufacturer.Nissan in the test dataset, so this test should return a value
	 * of 2.
	 **/
	@Test
	void testCalcManufacturer() {
		String expected = "2";
		System.out.println(laptimes.size());
		assertEquals(expected, LapUtilities.calcManufacturer(laptimes, One.getManufacturer()));
	}

}
