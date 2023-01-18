package com.tutorial.springboot.jpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tutorial.springboot.jpaandhibernate.course.Course;
/*
 * This class implements the CommandLineRunner interface, which is used to run a block of code(method) at the start of a spring boot application (at startup)
 *
 *This method will run the  insert method of the CourseJdbcRepository class to insert data in the H2 database at the start of the application 
 * */
@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseJdbcRepository repository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		repository.insert(new Course(111, "Learn Azure", "in28minutes"));
		repository.insert(new Course(222, "Learn AWS", "in28minutes"));
		repository.insert(new Course(333, "Learn Full Stack Development", "in28minutes"));
		
		repository.deleteById(222);
		
		System.out.println(repository.findById(111));
		System.out.println(repository.findById(333));
		
	}

}
