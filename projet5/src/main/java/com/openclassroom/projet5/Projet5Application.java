package com.openclassroom.projet5;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication

public class Projet5Application {
	
	  private static final Logger logger = LogManager.getLogger("AlertsApplication");

	    public static void main(String[] args) throws IOException {
		SpringApplication.run(Projet5Application.class, args);
	    }

}