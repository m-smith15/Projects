package com.shrimpco.Yoga.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.shrimpco.Yoga.Model.Student;
import com.shrimpco.Yoga.Repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public Student createStudent(Student student, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		} else {
			studentRepository.save(student);
			return student;
		}
	}
	
	public List<Student> allStudents(){
		return studentRepository.findAll();
	}
	
	public Student singleStudent(Long id) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if(optionalStudent.isPresent()) {
			return optionalStudent.get();
		} else {
			return null;
		}
	}
	public Student updateStudent(Student student) {
		studentRepository.save(student);
		return student;
	}

}
