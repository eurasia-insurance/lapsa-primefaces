package tech.lapsa.lapsa.primefaces.calendar.converter;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public final class Formatters {

    private Formatters() {
    }

    public static final DateTimeFormatter DATE_FORMATTER = new DateTimeFormatterBuilder() //
	    .appendValue(ChronoField.YEAR, 4) //
	    .appendLiteral('-') //
	    .appendValue(ChronoField.MONTH_OF_YEAR, 2) //
	    .appendLiteral('-') //
	    .appendValue(ChronoField.DAY_OF_MONTH, 2) //
	    .toFormatter();

    public static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder() //
	    .appendValue(ChronoField.HOUR_OF_DAY, 2) //
	    .appendLiteral(':') //
	    .appendValue(ChronoField.MINUTE_OF_HOUR, 2) //
	    .appendLiteral(':') //
	    .appendValue(ChronoField.SECOND_OF_MINUTE, 2) //
	    .toFormatter();

    public static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder() //
	    .append(DATE_FORMATTER) //
	    .appendLiteral(' ') //
	    .append(TIME_FORMATTER) //
	    .toFormatter();
}
