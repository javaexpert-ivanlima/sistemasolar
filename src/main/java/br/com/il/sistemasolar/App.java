package br.com.il.sistemasolar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.il.sistemasolar.utils.SistemaSolar;

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	System.setProperty("server.servlet.context-path", "/sistemasolar");
    	ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

        context.getBean(SistemaSolar.class).iniciaPrevisao(10L);
    	
    }
    
}
