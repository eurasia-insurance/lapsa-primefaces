package test.converter;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import tech.lapsa.lapsa.primefaces.converter.LocalDateConverter;

public class LocalDateConverterTest {

    @Test
    public void mainTest() {
	LocalDateConverter cc = new LocalDateConverter();

	{
	    LocalDate source = LocalDate.now();
	    System.out.println("Source: " + source);
	    String string = cc.getAsString(null, null, source);
	    System.out.println("Intermediate (string): " + string);
	    LocalDate target = (LocalDate) cc.getAsObject(null, null, string);
	    System.out.println("Target: " + target);

	    assertThat(target, allOf(not(nullValue()), equalTo(source)));

	}

	{
	    String source = "2017-05-04";
	    System.out.println("Source: " + source);
	    LocalDate string = (LocalDate) cc.getAsObject(null, null, source);
	    System.out.println("Intermediate (LocalDate): " + string);
	    String target = cc.getAsString(null, null, string);
	    System.out.println("Target: " + target);

	    assertThat(target, allOf(not(nullValue()), equalTo(target)));
	}
    }
}
