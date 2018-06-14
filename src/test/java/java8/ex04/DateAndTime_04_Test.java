package java8.ex04;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 04 - LocalDateTime
 */
public class DateAndTime_04_Test {

    @Test
    public void test_localDateTime_of() {

        LocalDateTime result = LocalDateTime.of(2018, 1, 1, 12, 0);

        int hour = result.getHour();
        int minutes = result.getMinute();
        int second = result.getSecond();
        int year = result.getYear();
        Month month = result.getMonth();
        int dayOfMonth = result.getDayOfMonth();

        assertThat(hour, is(12));
        assertThat(minutes, is(0));
        assertThat(second, is(0));
        assertThat(year, is(2018));
        assertThat(month, is(Month.JANUARY));
        assertThat(dayOfMonth, is(1));
    }

    @Test
    public void test_localDateTime_parse() {

        LocalDateTime result = LocalDateTime.parse("02/03/2009 09:30:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

        int hour = result.getHour();
        int minutes = result.getMinute();
        int second = result.getSecond();
        int year = result.getYear();
        Month month = result.getMonth();
        int dayOfMonth = result.getDayOfMonth();

        assertThat(year, is(2009));
        assertThat(month, is(Month.MARCH));
        assertThat(dayOfMonth, is(2));

        assertThat(hour, is(9));
        assertThat(minutes, is(30));
        assertThat(second, is(0));
    }

    @Test
    public void test_localDateTime_format() {

        LocalDateTime localDateTime = LocalDateTime.of(2017, 11, 27, 12, 0);;

        String result = localDateTime.format(DateTimeFormatter.ofPattern("yyyy - MM/dd HH:mm"));

        assertThat(result, is("2017 - 11/27 12:00"));
    }
}
