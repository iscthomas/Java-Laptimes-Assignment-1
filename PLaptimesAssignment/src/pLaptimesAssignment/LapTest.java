package pLaptimesAssignment;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Isaac Thomas
 * @date 1/6/2020 The LapTest test is used to test the methods, gets and sets
 *       found in the LapTest Class.
 */
class LapTest {
	/**
	 * Create 3 instances of lap to be tested in the lap class.
	 */
	Lap One = new Lap("21.123 km", "1:23.45", Type.Racing, Manufacturer.Nissan, "Test Car 123", "Test Driver",
			(LocalDate.of(1996, 9, 14)));
	Lap Two = new Lap("25.378 km", "8:09.1", Type.Racing, Manufacturer.Porsche, "Porsche 911 GT3 R (991)",
			"Laurens Vanthoor/Romain Dumas/Kevin Estre", (LocalDate.of(2018, 05, 11)));
	Lap Three = new Lap("21.123 km", "1:23.45", Type.Racing, Manufacturer.Nissan, "Test Car 123", "Test Driver",
			(LocalDate.of(2010, 11, 12)));

	/**
	 * tests the sets in the Lap class by manually defining them here.
	 */
	void setUp() throws Exception {
		Three.setLength("21.123 km");
		Three.setTime("1:23.45");
		Three.setType(Type.Racing);
		Three.setManufacturer(Manufacturer.Nissan);
		Three.setModel("Test Car 123");
		Three.setDriver("Test Driver");
		Three.setDate(LocalDate.of(2010, 11, 12));
	}

	/**
	 * tests the gets in conjunction with the sets in the Lap class by manually
	 * defining them here.
	 */
	@Test
	void testgetset() {
		assertEquals("21.123 km", Three.getLength());
		assertEquals("1:23.45", Three.getTime());
		assertEquals(Type.Racing, Three.getType());
		assertEquals(Manufacturer.Nissan, Three.getManufacturer());
		assertEquals("Test Car 123", Three.getModel());
		assertEquals("Test Driver", Three.getDriver());
		assertEquals(LocalDate.of(2010, 11, 12), Three.getDate());
	}

	/**
	 * tests the toString method, note that "\n" must be at the end of the expected
	 * result as the lap class returns a new line in console for ease of
	 * readability. expected result is a combination of the output of lap entry One.
	 */
	@Test
	void testToString() {
		String expected = "21.123 km 1:23.45 Racing Nissan Test Car 123 Test Driver 1996-09-14\n";
		assertEquals(expected, One.toString());
	}

	/**
	 * tests the compareTo method, expected value is -7 as the threes time is 7
	 * minutes faster than Two. therefore three will be sorted before two
	 */
	@Test
	void testCompareTo() {
		int expected = -7;
		assertEquals(expected, Three.compareTo(Two));
	}

	/**
	 * Tests the compareTo method, expected value is 14 as the times are the same so
	 * sorted by date, where the expected value is 14 as lap three is 14 years older
	 * than lap one. therefore lap three will be sorted after one.
	 */
	@Test
	void testCompareTo2() {
		int expected = 14;
		assertEquals(expected, Three.compareTo(One));
	}

}
