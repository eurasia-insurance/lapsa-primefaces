package test.converter;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import tech.lapsa.lapsa.primefaces.calendar.converter.LocalDateConverter;

public class LocalDateConverterTest {

    @Test
    public void mainTest() {
	final LocalDateConverter cc = new LocalDateConverter();

	{
	    final LocalDate source = LocalDate.now();
	    System.out.println("Source: " + source);
	    final String string = cc.getAsString(null, null, source);
	    System.out.println("Intermediate (string): " + string);
	    final LocalDate target = (LocalDate) cc.getAsObject(null, null, string);
	    System.out.println("Target: " + target);

	    assertThat(target, allOf(not(nullValue()), equalTo(source)));

	}

	{
	    final String source = "2017-05-04";
	    System.out.println("Source: " + source);
	    final LocalDate string = (LocalDate) cc.getAsObject(null, null, source);
	    System.out.println("Intermediate (LocalDate): " + string);
	    final String target = cc.getAsString(null, null, string);
	    System.out.println("Target: " + target);

	    assertThat(target, allOf(not(nullValue()), equalTo(target)));
	}
    }
}
