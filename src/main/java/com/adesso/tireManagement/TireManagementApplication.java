package com.adesso.tireManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TireManagementApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(TireManagementApplication.class, args);
	}
}
