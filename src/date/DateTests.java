package date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.*;
import static org.junit.Assert.*;
import date.Date;

/**
 *
 * @author tuf18513
 */
public class DateTests {

    public DateTests() {

    }

    @Test
    public void DaysToJanSecondFromJanFirst() throws DatePastException {
        Date d1 = new Date(2017, 1, 1);
        Date d2 = new Date(2017, 1, 2);
        assertEquals(1, d1.daysTo(d2));
    }

    @Test
    public void DaysToJanThirdFromJanFirst() throws DatePastException {
        Date d1 = new Date(2017, 1, 1);
        Date d2 = new Date(2017, 1, 3);
        assertEquals(2, d1.daysTo(d2));
    }

    @Test
    public void DaysToFebFristFromJanFirst() throws DatePastException {
        Date d1 = new Date(2017, 1, 1);
        Date d2 = new Date(2017, 2, 1);
        assertEquals(30, d1.daysTo(d2));
    }

    @Test
    public void DaysToFebFourthFromJanFirst() throws DatePastException {
        Date d1 = new Date(2017, 1, 1);
        Date d2 = new Date(2017, 2, 4);
        assertEquals(33, d1.daysTo(d2));
    }

    @Test
    public void DaysToJanFirstOneYearFromNow() throws DatePastException {
        Date d1 = new Date(2017, 1, 1);
        Date d2 = new Date(2018, 1, 1);
        assertEquals(365, d1.daysTo(d2));
    }

    @Test
    public void DaysToJanFirstOneYearAndOneDayFromNow() throws DatePastException {
        Date d1 = new Date(2017, 1, 1);
        Date d2 = new Date(2018, 1, 2);
        assertEquals(366, d1.daysTo(d2));
    }

    @Test
    public void DaysToJanFirst2017toFebEighth2018() throws DatePastException {
        Date d1 = new Date(2017, 1, 1);
        Date d2 = new Date(2018, 2, 8);
        assertEquals(402, d1.daysTo(d2));
    }

    @Test(expected = DatePastException.class)
    public void DaysToJanFirst2017toJanFirst2016() throws DatePastException {
        Date d1 = new Date(2017, 1, 1);
        Date d2 = new Date(2016, 1, 1);
        d1.daysTo(d2);
    }

    @Test(expected = DatePastException.class)
    public void DaysToUsingTheSameDateTwice() throws DatePastException {
        Date d1 = new Date(2017, 1, 1);
        d1.daysTo(d1);
    }

    //Expecting the error, this test is intentionally wrong.
    @Test
    public void DaysToJanFirst2017toFebEighth2018WrongValue() throws DatePastException {
        Date d1 = new Date(2017, 1, 1);
        Date d2 = new Date(2018, 2, 8);
        assertEquals(400, d1.daysTo(d2));
    }

    //Expecting the error, this test is intentionally wrong.
    @Test
    public void DaysToJanSecondFromJanFirstWrongValue() throws DatePastException {
        Date d1 = new Date(2017, 1, 1);
        Date d2 = new Date(2017, 1, 2);
        assertEquals(0, d1.daysTo(d2));
    }
}
