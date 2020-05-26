package pLaptimesAssignment;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LapTest {
	
	Lap One = new Lap("21.123 km", "1:23.45", Type.Racing, Manufacturer.Nissan, "Test Car 123", "Test Driver", (LocalDate.of(1996, 9, 14)));
	Lap Two = new Lap("25.378 km", "8:09.1", Type.Racing, Manufacturer.Porsche, "Porsche 911 GT3 R (991)", "Laurens Vanthoor/Romain Dumas/Kevin Estre", (LocalDate.of(2018,05,11)));
	Lap Three = new Lap("21.123 km", "1:23.45", Type.Racing, Manufacturer.Nissan, "Test Car 123", "Test Driver", (LocalDate.of(2010, 11, 12)));

	@BeforeEach
	void setUp() throws Exception {
		Three.setLength("21.123 km");
		Three.setTime("1:23.45");
		Three.setType(Type.Racing);
		Three.setManufacturer(Manufacturer.Nissan);
		Three.setModel("Test Car 123");
		Three.setDriver("Test Driver");
		Three.setDate(LocalDate.of(2010, 11, 12));
	}

	@Test
    void testgetset() {
		assertEquals("21.123 km",Three.getLength());
		assertEquals("1:23.45",Three.getTime());
		assertEquals(Type.Racing,Three.getType());
		assertEquals(Manufacturer.Nissan,Three.getManufacturer());
		assertEquals("Test Car 123",Three.getModel());
		assertEquals("Test Driver",Three.getDriver());
		assertEquals(LocalDate.of(2010, 11, 12),Three.getDate());
    }

	@Test
	void testToString() {
        String expected = "25.378 km 8:09.1 Racing Porsche Porsche 911 GT3 R (991) Laurens Vanthoor/Romain Dumas/Kevin Estre 2018-05-11";
        assertEquals(expected, Two.toString());
	}

	@Test
	void testCompareTo() {
		fail("Not yet implemented");
	}

}
