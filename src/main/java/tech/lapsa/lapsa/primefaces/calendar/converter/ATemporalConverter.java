package tech.lapsa.lapsa.primefaces.calendar.converter;

import java.time.DateTimeException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import tech.lapsa.java.commons.function.MyObjects;

public abstract class ATemporalConverter<T> implements Converter {

    private final Class<T> clazz;

    protected ATemporalConverter(final Class<T> clazz) {
	this.clazz = MyObjects.requireNonNull(clazz, "clazz");
    }

    protected abstract T convertString(String value);

    protected abstract String convertObject(T value);

    @Override
    public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {
	if (MyObjects.isNull(value))
	    return null;
	try {
	    return convertString(value);
	} catch (final DateTimeException e) {
	    throw new ConverterException(e);
	}
    }

    @Override
    public String getAsString(final FacesContext context, final UIComponent component, final Object value) {
	if (MyObjects.isNull(value))
	    return null;
	try {
	    return convertObject(MyObjects.requireA(value, clazz, "value"));
	} catch (IllegalArgumentException | DateTimeException e) {
	    throw new ConverterException(e);
	}
    }

}
