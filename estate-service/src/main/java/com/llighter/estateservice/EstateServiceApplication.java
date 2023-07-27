package com.llighter.estateservice;

import com.llighter.estateservice.model.Customer;
import com.llighter.estateservice.model.Items;
import com.llighter.estateservice.repository.CustomerRepository;
import com.llighter.estateservice.repository.ItemsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EstateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstateServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customers, ItemsRepository items) {
		return args -> {
			items.save(new Items("아파트", 100000000, "001", "001", "001", "001", "001"));
			customers.save(new Customer("John", "1990-01-01", "1234567890"));
		};
	}

}
