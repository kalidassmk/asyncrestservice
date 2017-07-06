package com.asyncrestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Kalidass Mahalingam
 *
 */
@SpringBootApplication
@EnableAsync
public class AsyncRestserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncRestserviceApplication.class, args);
	}
}
