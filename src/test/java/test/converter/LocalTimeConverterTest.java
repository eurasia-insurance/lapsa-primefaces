package test.converter;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

import tech.lapsa.lapsa.primefaces.calendar.converter.LocalTimeConverter;

public class LocalTimeConverterTest {

    @Test
    public void mainTest() {
	final LocalTimeConverter cc = new LocalTimeConverter();

	{
	    final LocalTime source = LocalTime.now();
	    System.out.println("Source: " + source);
	    final String string = cc.getAsString(null, null, source);
	    System.out.println("Intermediate (string): " + string);
	    final LocalTime target = (LocalTime) cc.getAsObject(null, null, string);
	    System.out.println("Target: " + target);

	    assertThat(target, allOf(not(nullValue()), equalTo(source.truncatedTo(ChronoUnit.SECONDS))));

	}

	{
	    final String source = "09:56:21";
	    System.out.println("Source: " + source);
	    final LocalTime string = (LocalTime) cc.getAsObject(null, null, source);
	    System.out.println("Intermediate (LocalTime): " + string);
	    final String target = cc.getAsString(null, null, string);
	    System.out.println("Target: " + target);

	    assertThat(target, allOf(not(nullValue()), equalTo(target)));
	}
    }
}
