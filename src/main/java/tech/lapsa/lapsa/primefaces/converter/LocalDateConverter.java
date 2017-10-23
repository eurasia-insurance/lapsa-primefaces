package tech.lapsa.lapsa.primefaces.converter;

import java.time.LocalDate;

import javax.faces.convert.FacesConverter;

@FacesConverter(value = "tech.lapsa.lapsa.primefaces.converter.LocalDateConverter")
public class LocalDateConverter extends ATemporalConverter<LocalDate> {

    public LocalDateConverter() {
	super(LocalDate.class);
    }

    @Override
    protected LocalDate convertString(String value) {
	return LocalDate.from(Formatters.DATE_FORMATTER.parse(value));
    }

    @Override
    protected String convertObject(LocalDate value) {
	return Formatters.DATE_FORMATTER.format(value);
    }
}
