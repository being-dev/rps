package com.rps.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.rps"})
public class RpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpsApplication.class, args);
	}

}
