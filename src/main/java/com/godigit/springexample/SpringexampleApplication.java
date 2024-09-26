package com.godigit.springexample;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringexampleApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringexampleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringexampleApplication.class, args);
		log.info("Info Level");
	}

}
