package tech.lapsa.lapsa.primefaces.calendar.converter;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.faces.convert.FacesConverter;

/**
 * Converter for Primefaces p:calendar converting values loosing nano-seconds
 * part because p:calendar does not allow to enter a nano-second part of the
 * Instant value
 * 
 * @author Vadim.Isaev
 *
 */
@FacesConverter(value = "tech.lapsa.lapsa.primefaces.calendar.converter.InstantConverter")
public class InstantConverter extends ATemporalConverter<Instant> {

    public static final ZoneId DEFAULT_ZONE_ID = ZoneId.systemDefault();

    public InstantConverter() {
	super(Instant.class);
    }

    @Override
    protected Instant convertString(String value) {
	try {
	    return LocalDateTime.from( //
		    Formatters.DATE_TIME_FORMATTER.parse(value)) //
		    .atZone(DEFAULT_ZONE_ID) //
		    .toInstant();
	} catch (DateTimeException e) {
	    return LocalDate.from( //
		    Formatters.DATE_FORMATTER.parse(value)) //
		    .atStartOfDay() //
		    .atZone(DEFAULT_ZONE_ID)
		    .toInstant();
	}

    }

    @Override
    protected String convertObject(Instant value) {
	return Formatters.DATE_TIME_FORMATTER //
		.format(value.atZone(DEFAULT_ZONE_ID).toLocalDateTime());
    }
}
