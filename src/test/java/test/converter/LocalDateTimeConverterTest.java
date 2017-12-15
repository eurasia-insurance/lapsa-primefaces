package test.converter;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

import tech.lapsa.lapsa.primefaces.calendar.converter.LocalDateTimeConverter;

public class LocalDateTimeConverterTest {

    @Test
    public void mainTest() {
	final LocalDateTimeConverter cc = new LocalDateTimeConverter();

	{
	    final LocalDateTime source = LocalDateTime.now();
	    System.out.println("Source: " + source);
	    final String string = cc.getAsString(null, null, source);
	    System.out.println("Intermediate (string): " + string);
	    final LocalDateTime target = (LocalDateTime) cc.getAsObject(null, null, string);
	    System.out.println("Target: " + target);

	    assertThat(target, allOf(not(nullValue()), equalTo(source.truncatedTo(ChronoUnit.SECONDS))));

	}

	{
	    final String source = "2017-10-23 09:56:21";
	    System.out.println("Source: " + source);
	    final LocalDateTime string = (LocalDateTime) cc.getAsObject(null, null, source);
	    System.out.println("Intermediate (LocalDateTime): " + string);
	    final String target = cc.getAsString(null, null, string);
	    System.out.println("Target: " + target);

	    assertThat(target, allOf(not(nullValue()), equalTo(target)));
	}
    }
}
