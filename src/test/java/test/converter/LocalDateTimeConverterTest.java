package test.converter;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

import tech.lapsa.lapsa.primefaces.converter.LocalDateTimeConverter;

public class LocalDateTimeConverterTest {

    @Test
    public void mainTest() {
	LocalDateTimeConverter cc = new LocalDateTimeConverter();

	{
	    LocalDateTime source = LocalDateTime.now();
	    System.out.println("Source: " + source);
	    String string = cc.getAsString(null, null, source);
	    System.out.println("Intermediate (string): " + string);
	    LocalDateTime target = (LocalDateTime) cc.getAsObject(null, null, string);
	    System.out.println("Target: " + target);

	    assertThat(target, allOf(not(nullValue()), equalTo(source.truncatedTo(ChronoUnit.SECONDS))));

	}

	{
	    String source = "2017-10-23 09:56:21";
	    System.out.println("Source: " + source);
	    LocalDateTime string = (LocalDateTime) cc.getAsObject(null, null, source);
	    System.out.println("Intermediate (LocalDateTime): " + string);
	    String target = cc.getAsString(null, null, string);
	    System.out.println("Target: " + target);

	    assertThat(target, allOf(not(nullValue()), equalTo(target)));
	}
    }
}
