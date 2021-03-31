package com.jcastillo.exchanger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EntityScan(basePackages = {"com.jcastillo.exchanger.model"} )
@EnableJpaRepositories(basePackages = {"com.jcastillo.exchanger.repository"})
@EnableScheduling
public class Exchanger2Application {

	public static void main(String[] args) {
		SpringApplication.run(Exchanger2Application.class, args);
	}

}
