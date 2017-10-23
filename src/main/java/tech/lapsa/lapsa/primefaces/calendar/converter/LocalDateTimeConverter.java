package tech.lapsa.lapsa.primefaces.calendar.converter;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.faces.convert.FacesConverter;

/**
 * Converter for Primefaces p:calendar converting values loosing nano-seconds
 * part because p:calendar does not allow to enter a nano-second part of the
 * Instant value
 * 
 * @author Vadim.Isaev
 *
 */
@FacesConverter(value = "tech.lapsa.lapsa.primefaces.calendar.converter.LocalDateTimeConverter")
public class LocalDateTimeConverter extends ATemporalConverter<LocalDateTime> {

    public LocalDateTimeConverter() {
	super(LocalDateTime.class);
    }

    @Override
    protected LocalDateTime convertString(String value) {
	try {
	    return LocalDateTime.from(Formatters.DATE_TIME_FORMATTER.parse(value));
	} catch (DateTimeException e) {
	    return LocalDate.from(Formatters.DATE_FORMATTER.parse(value)).atStartOfDay();
	}
    }

    @Override
    protected String convertObject(LocalDateTime value) {
	return Formatters.DATE_TIME_FORMATTER.format(value);
    }
}
