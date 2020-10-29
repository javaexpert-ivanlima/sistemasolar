package br.com.il.sistemasolar;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import javax.validation.ValidationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("junit")
public class AppTest {
		
	  @SuppressWarnings("static-access")
	  @Test
	  public void testRunSpringApplication() {
		  ValidationException be = new ValidationException("test exception");
		  be.getMessage();
		  new ValidationException("test exception", new IOException());
		  String[] args = {"spring.profiles.active=junit"};
		  App app = new App();
		  app.main(args);
		  assertNotNull("Arguments not should to be null", args);
	  }
}