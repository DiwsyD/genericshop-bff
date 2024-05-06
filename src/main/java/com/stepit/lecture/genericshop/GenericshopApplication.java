package com.stepit.lecture.genericshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GenericshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenericshopApplication.class, args);
	}

}
