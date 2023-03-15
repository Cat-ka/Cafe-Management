package com.cafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CafeManagementSystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(CafeManagementSystemApplication.class, args);
		System.out.println("Starting code...");
	}

}
