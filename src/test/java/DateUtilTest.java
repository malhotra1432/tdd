import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DateUtilTest {

    @Test
    void shouldReturnTrueIfAnYearIsLeap(){
        assertTrue(DateUtil.isLeapYear(1992));
    }

    @Test
    void ShouldReturnFalseIfAnYearIsNotLeap(){
        assertFalse(DateUtil.isLeapYear(1991));
    }

    @Test
    void shouldReturnFalseForCenturyNonLeapYear(){
        assertFalse(DateUtil.isLeapYear(1900));
    }

    @Test
    void shouldReturnTrueForCenturyLeapYear(){
        assertTrue(DateUtil.isLeapYear(2000));
    }

}
