package tech.lapsa.lapsa.primefaces.calendar.converter;

import java.time.LocalTime;

import javax.faces.convert.FacesConverter;

/**
 * Converter for Primefaces p:calendar converting values loosing nano-seconds
 * part because p:calendar does not allow to enter a nano-second part of the
 * Instant value
 * 
 * @author Vadim.Isaev
 *
 */
@FacesConverter(value = "tech.lapsa.lapsa.primefaces.calendar.converter.LocalTimeConverter")
public class LocalTimeConverter extends ATemporalConverter<LocalTime> {

    public LocalTimeConverter() {
	super(LocalTime.class);
    }

    @Override
    protected LocalTime convertString(String value) {
	return LocalTime.from(Formatters.TIME_FORMATTER.parse(value));
    }

    @Override
    protected String convertObject(LocalTime value) {
	return Formatters.TIME_FORMATTER.format(value);
    }
}
