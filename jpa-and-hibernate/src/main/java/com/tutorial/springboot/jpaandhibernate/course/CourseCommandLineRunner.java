package com.tutorial.springboot.jpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tutorial.springboot.jpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
/*
 * This class implements the CommandLineRunner interface, which is used to run a block of code(method) at the start of a spring boot application (at startup)
 *
 *This method will run the  insert method of the CourseJdbcRepository class to insert data in the H2 database at the start of the application 
 * */
@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//	@Autowired
//	private CourseJdbcRepository repository;
	
//	@Autowired
//	private CourseJpaRepository repository;

	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		repository.save(new Course(111, "Learn Azure", "in28minutes"));
		repository.save(new Course(222, "Learn AWS", "in28minutes"));
		repository.save(new Course(333, "Learn Full Stack Development", "in28minutes"));
		repository.save(new Course(333, "Learn DevOps", "Java Brains"));
		
		repository.deleteById(222l);
		
		System.out.println(repository.findById(111l));
		System.out.println(repository.findById(333l));
		
		System.out.println("All Rows : ");
		System.out.println(repository.findAll());
		
		System.out.println("Total Count of Rows : " + repository.count());
		
		System.out.println("Finding by Author : ");
		System.out.println(repository.findByAuthor("Java Brains"));
		
		System.out.println("Finding by Name : ");
		System.out.println(repository.findByName("Learn DevOps"));
		
	}

}
