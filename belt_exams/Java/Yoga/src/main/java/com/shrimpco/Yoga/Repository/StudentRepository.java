package com.shrimpco.Yoga.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.shrimpco.Yoga.Model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	
	List<Student> findAll();
	Optional<Student> findByName(String name);

}
