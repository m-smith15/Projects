package com.shrimpco.Yoga.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shrimpco.Yoga.Model.Course;
import com.shrimpco.Yoga.Model.Student;
import com.shrimpco.Yoga.Model.User;
import com.shrimpco.Yoga.Service.CourseService;
import com.shrimpco.Yoga.Service.StudentService;
import com.shrimpco.Yoga.Service.UserService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;
	
	
	
	@RequestMapping(value="/student/new/create", method=RequestMethod.POST)
	public String createStudent(@Valid @ModelAttribute("student") Student student,
								BindingResult result, Model model) {
		
		Student potentialStudent = studentService.createStudent(student, result);
		if(potentialStudent != null) {
			return "redirect:/dashboard";
		} else {
			model.addAttribute("students", studentService.allStudents());
			model.addAttribute("student", new Student());
			model.addAttribute("existingStudent", new Student());
			return "singlecourse.jsp";
		}
	}
	
	@RequestMapping(value="/student/current/add/{id}", method=RequestMethod.PUT)
	public String addExistingStudent(@Valid @ModelAttribute("existingStudent") Student student,
									BindingResult result,
									@PathVariable("id") Long id, HttpSession session,
									Model model) {
		
		//id is course id
		
		//get user
//		String email = (String) session.getAttribute("email");
//		User currentUser = userService.singleUserByLogin(email);
		
		//model.addAttribute("course", courseService.singleCourse(id));
		//System.out.println(result.getAllErrors());
		Course courseToUpdate = courseService.singleCourse(id);
		System.out.println("updating to this course id " + courseToUpdate.getId());
//		
		Student studentToAdd = studentService.singleStudent(student.getId());
		System.out.println("Student adding id " + studentToAdd.getId());
		System.out.println("Student adding course id " + studentToAdd.getCourse().getId());
		
		studentToAdd.setCourse(courseToUpdate);
		System.out.println("set course" + studentToAdd.getCourse().getId());
		
//		studentToAdd.setCourse(courseToUpdate);
//		System.out.println(studentToAdd.getCourse().getId());
//		studentService.updateStudent(studentToAdd);
//		System.out.println(courseToUpdate.getStudents().add(studentToAdd));
		Student potentialStudent = studentService.updateStudent(studentToAdd);
		if(potentialStudent != null) {
//			courseToUpdate.getStudents().add(studentToAdd);
//			courseService.updateCourse(courseToUpdate);
			//System.out.println(studentToAdd.getCourse().getId());
			System.out.println("student update/added");
			return "redirect:/dashboard";
		} else {
			model.addAttribute("students", studentService.allStudents());
			model.addAttribute("student", new Student());
			model.addAttribute("existingStudent", new Student());
			return "singlecourse.jsp";
		}
	}
}
