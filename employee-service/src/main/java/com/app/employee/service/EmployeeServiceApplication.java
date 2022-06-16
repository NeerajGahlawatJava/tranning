package com.app.employee.service;

import com.app.employee.service.entity.Student;
import com.app.employee.service.entity.StudentIdentity;
import com.app.employee.service.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class EmployeeServiceApplication {

	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

	@PostConstruct
	public void saveStudent(){
		studentRepository.save(new Student(new StudentIdentity(101,201), "Neeraj", "JAVA"));
	}

}
