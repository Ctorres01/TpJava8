package java8.ex02;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Exercice 02 - LocalDate
 */
public class DateAndTime_02_Test {

    @Test
    public void test_localDate_of() {

        LocalDate result = LocalDate.of(2050, 12, 24);

        int year = result.getYear();
        Month month = result.getMonth();
        int dayOfMonth = result.getDayOfMonth();
        DayOfWeek dayOfWeek = result.getDayOfWeek();
        int dayOfYear = result.getDayOfYear();

        assertThat(year, is(2050));
        assertThat(month, is(Month.DECEMBER));
        assertThat(dayOfMonth, is(24));
        assertThat(dayOfWeek, is(DayOfWeek.SATURDAY));
        assertThat(dayOfYear, is(358));
    }

    @Test
    public void test_localDate_parse() {

        LocalDate result = LocalDate.parse("10/01/1990", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        

        int year = result.getYear();
        Month month = result.getMonth();
        int dayOfMonth = result.getDayOfMonth();


        assertThat(year, is(1990));
        assertThat(month, is(Month.JANUARY));
        assertThat(dayOfMonth, is(10));
    }

    @Test
    public void test_localDate_format() {

        LocalDate localDate = LocalDate.of(2015, 3, 11);
        String result = localDate.format(DateTimeFormatter.ofPattern("dd - MM - yyyy"));
        assertThat(result, is("11 - 03 - 2015"));
    }

    @Test(expected = UnsupportedTemporalTypeException.class)
    public void test_localDate_format_with_hour() {

        LocalDate localDate = LocalDate.of(2015, 3, 11);
        localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    @Test
    public void test_with() {

        // TODO créer un objet LocalDate à la date 10/01/2000
        // TODO utiliser la méthode of
        LocalDate localDate = LocalDate.of(2000, 01, 10);

        // TODO transformer la date précédente en 05/02/2015
        LocalDate result = localDate.withDayOfMonth(5)
        							.withMonth(2)
        							.withYear(2015);

        assertThat(result.getYear(), is(2015));
        assertThat(result.getMonth(), is(Month.FEBRUARY));
        assertThat(result.getDayOfMonth(), is(5));
    }

}
