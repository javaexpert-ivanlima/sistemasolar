package br.com.il.sistemasolar.config;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@RunWith(JUnit4.class)
public class SwaggerConfigTest {

	@Mock
	private ResourceHandlerRegistry registry;
	
	@Mock
	private ResourceHandlerRegistration registration;

	@Before	
	public void before() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void testSwaggerConfiguration() {
		when(registry.addResourceHandler(any())).thenReturn(registration);
		SwaggerConfig configuration = new SwaggerConfig();
		configuration.api();
		configuration.addResourceHandlers(registry);
		assertNotNull("Configuration not should to be null", configuration);	
	
		
	}


}
