package com.example.springbootmongodb;

import com.example.springbootmongodb.constants.Gender;
import com.example.springbootmongodb.model.Address;
import com.example.springbootmongodb.model.Student;
import com.example.springbootmongodb.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

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
	CommandLineRunner runner(StudentRepository repository,
							 MongoTemplate mongoTemplate){
		return args -> {
			Address address=new Address("India","110025","Delhi");
			String email = "ahmad@gmail.com";
			Student student=new Student("Ishteyaque",
					"Ahmad",
					email,
					Gender.MALE,
					address,
					List.of("Computer science","Maths"),
					BigDecimal.TEN,
					LocalDateTime.now());

			Query query=new Query();
			query.addCriteria(Criteria.where("email").is(email));

			List<Student> students = mongoTemplate.find(query, Student.class);
			if (students.size()>1)
				throw new IllegalStateException("found many students with email"+email);

			if (students.isEmpty())
			repository.insert(student);
		};

	}
}
