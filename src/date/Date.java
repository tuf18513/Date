/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author tuf18513
 */
public class Date {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(DateTests.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }
    private int year, month, day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int daysTo(Date d) throws DatePastException {
        int days = (d.getDay() - day) * 1 + (d.getMonth() - month) * 30 + (d.getYear() - year) * 365;
        if (days > 0) {
            return days;
        } else {
            throw new DatePastException("the date was " + days + "past");
        }
    }
}
