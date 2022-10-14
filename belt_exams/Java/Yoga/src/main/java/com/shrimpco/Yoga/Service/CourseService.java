package com.shrimpco.Yoga.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.shrimpco.Yoga.Model.Course;
import com.shrimpco.Yoga.Model.Student;
import com.shrimpco.Yoga.Repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	//create, find all, find 1, delete
	
	public Course createCourse(Course course, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		} else {
			courseRepository.save(course);
			return course;
		}
	}
	
	public List<Course> allCourses(){
		return courseRepository.findAll();
	}
	
	public Course singleCourse(Long id) {
		Optional<Course> optionalCourse = courseRepository.findById(id);
			if(optionalCourse.isPresent()) {
				return optionalCourse.get();
			} else {
				return null;
			}
	}
	
	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);
	}
	
	public Course updateCourse(Course course) {
		courseRepository.save(course);
		return course;
	}
}
