package com.lpras.lombok;

import com.lpras.lombok.model.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LombokModelApplication implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(LombokModelApplication.class);
	@Autowired
	private Email email;

	public static void main(String[] args) {
		SpringApplication.run(LombokModelApplication.class, args);
	}
	@Override
	public void run(String... args) {
	    //for(int i=0; i<Integer.MAX_VALUE; i++)
            logger.debug(email.toString());
	}


}
