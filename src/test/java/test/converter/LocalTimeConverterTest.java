package test.converter;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

import tech.lapsa.lapsa.primefaces.converter.LocalTimeConverter;

public class LocalTimeConverterTest {

    @Test
    public void mainTest() {
	LocalTimeConverter cc = new LocalTimeConverter();

	{
	    LocalTime source = LocalTime.now();
	    System.out.println("Source: " + source);
	    String string = cc.getAsString(null, null, source);
	    System.out.println("Intermediate (string): " + string);
	    LocalTime target = (LocalTime) cc.getAsObject(null, null, string);
	    System.out.println("Target: " + target);

	    assertThat(target, allOf(not(nullValue()), equalTo(source.truncatedTo(ChronoUnit.SECONDS))));

	}

	{
	    String source = "09:56:21";
	    System.out.println("Source: " + source);
	    LocalTime string = (LocalTime) cc.getAsObject(null, null, source);
	    System.out.println("Intermediate (LocalTime): " + string);
	    String target = cc.getAsString(null, null, string);
	    System.out.println("Target: " + target);

	    assertThat(target, allOf(not(nullValue()), equalTo(target)));
	}
    }
}
