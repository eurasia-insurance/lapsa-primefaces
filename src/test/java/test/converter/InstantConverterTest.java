package test.converter;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

import tech.lapsa.lapsa.primefaces.converter.InstantConverter;

public class InstantConverterTest {

    @Test
    public void mainTest() {
	InstantConverter cc = new InstantConverter();

	{
	    Instant source = Instant.now();
	    System.out.println("Source: " + source);
	    String string = cc.getAsString(null, null, source);
	    System.out.println("Intermediate (string): " + string);
	    Instant target = (Instant) cc.getAsObject(null, null, string);
	    System.out.println("Target: " + target);

	    assertThat(target, allOf(not(nullValue()), equalTo(source.truncatedTo(ChronoUnit.SECONDS))));

	}

	{
	    System.out.println();
	    String source = "2017-05-04 14:13:21";
	    System.out.println("Source: " + source);
	    Instant string = (Instant) cc.getAsObject(null, null, source);
	    System.out.println("Intermediate (Instant): " + string);
	    String target = cc.getAsString(null, null, string);
	    System.out.println("Target: " + target);

	    assertThat(target, allOf(not(nullValue()), equalTo(target)));
	}
    }
}
