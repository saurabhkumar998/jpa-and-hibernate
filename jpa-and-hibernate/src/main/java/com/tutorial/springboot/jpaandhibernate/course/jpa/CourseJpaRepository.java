package com.tutorial.springboot.jpaandhibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.tutorial.springboot.jpaandhibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {
	
	//@Autowired			   // Autowired annotation will also work fine
	@PersistenceContext       // similar to Autowired annotation but more specific to EntityManager
	private EntityManager entityManager;
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public Course findById(long id) {
		return  entityManager.find(Course.class, id);
	}
	
	public void deleteById(long id) {
		Course course = findById(id);
		entityManager.remove(course);
		return;
	}

}
