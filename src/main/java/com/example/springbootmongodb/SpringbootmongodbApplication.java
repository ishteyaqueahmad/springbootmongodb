package com.example.springbootmongodb;

import com.example.springbootmongodb.constants.Gender;
import com.example.springbootmongodb.model.Address;
import com.example.springbootmongodb.model.Student;
import com.example.springbootmongodb.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class SpringbootmongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootmongodbApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository){
		return args -> {
			Address address=new Address("India","110025","Delhi");
			Student student=new Student("Ishteyaque",
					"Ahmad",
					"ahmad@gmail.com",
					Gender.MALE,
					address,
					List.of("Computer science","Maths"),
					BigDecimal.TEN,
					LocalDateTime.now());

			repository.insert(student);
		};

	}
}
