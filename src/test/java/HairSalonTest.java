import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class HairSalonTest {

    HairSalon hairSalon = new HairSalon();

    @Test
    public void testGetOpeningDays() {
        // compare arrays

        String[] expected = new String[]{"Monday", "Tuesday"};

        String[] actual = hairSalon.getOpeningDays();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void testSalonIsOpenOnMonday() {
        // boolean

        boolean actual = hairSalon.isOpen("Monday");

        assertTrue(actual);
    }

    @Test
    public void testSalonIsClosedOnWednesday() {
        // boolean

        boolean actual = hairSalon.isOpen("Wednesday");

        assertFalse(actual);
    }

    @Test
    public void testExceptionIsThrownIfWeekdayDoesNotEndInDay() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> hairSalon.isOpen("June"));

        String expected = "Only weekdays are valid";

        String actual = exception.getMessage();

        assertEquals(expected, actual);

    }

}