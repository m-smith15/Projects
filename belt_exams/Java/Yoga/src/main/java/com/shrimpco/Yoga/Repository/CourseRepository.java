package com.shrimpco.Yoga.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.shrimpco.Yoga.Model.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {
	
	List<Course> findAll();
	Optional<Course> findByName(String name);

}
