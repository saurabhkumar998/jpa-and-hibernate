package com.tutorial.springboot.jpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String INSERT_QUERY = 
			"""
			insert into course values (2, 'Learn Azure', 'in28minutes');
			
			""";
	public void insert() {
		springJdbcTemplate.update(INSERT_QUERY);
	}

}
