package com.llighter.estateservice;

import com.llighter.estateservice.model.Customer;
import com.llighter.estateservice.model.Items;
import com.llighter.estateservice.repository.CustomerRepository;
import com.llighter.estateservice.repository.ItemsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class EstateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstateServiceApplication.class, args);
	}

	@Bean
	@Profile("local")
	CommandLineRunner commandLineRunner(CustomerRepository customers, ItemsRepository items) {
		return args -> {

			items.save(new Items("극동 아파트", 110000000, "001", "001", "001", "001", "001"));
			items.save(new Items("중곡 아파트", 120000000, "001", "001", "001", "001", "001"));
			items.save(new Items("여의도 빌라", 130000000, "002", "001", "001", "001", "001"));


			customers.save(new Customer("John", "1990-01-01", "1234567890"));
		};
	}

}
