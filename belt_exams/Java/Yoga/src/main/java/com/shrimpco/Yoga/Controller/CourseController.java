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
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping( value="/dashboard", method=RequestMethod.GET)
	private String dashboard(Model model, HttpSession session) {
		
		if(userService.validateSession(session) == true) {
			model.addAttribute("courses", courseService.allCourses());
			
			return "dashboard.jsp";
	} else {
		return "redirect:/logout";
	}
	}
	
	@RequestMapping(value="course/new", method=RequestMethod.GET)
	private String newCourse(HttpSession session, Model model) {
		if(userService.validateSession(session) == true) {
			model.addAttribute("course", new Course());
			
			return "newcourse.jsp";
		} else {
			return "redirect:/logout";
		}
		
	}
	
	@RequestMapping(value="course/new/create", method=RequestMethod.POST)
	private String addCourse(@Valid @ModelAttribute("course") Course course,
							BindingResult result,
							Model model) {
		
		Course potentialCourse = courseService.createCourse(course, result);
		if(potentialCourse != null) {
			return "redirect:/dashboard";
		} else {
			return "newcourse.jsp";
		}
	}
	
	@RequestMapping(value="course/view/{id}", method=RequestMethod.GET)
	private String viewCourse(Model model,
							@PathVariable("id") Long id,
							HttpSession session) {
		
		if(userService.validateSession(session) == true) {
		
		//current user
		String email = (String) session.getAttribute("email");
		User currentUser = userService.singleUserByLogin(email);
		model.addAttribute("user", currentUser);
		
		model.addAttribute("course", courseService.singleCourse(id));
		//add more for students
		
		//get current students
		model.addAttribute("students", studentService.allStudents());
		model.addAttribute("student", new Student());
		model.addAttribute("existingStudent", new Student());
		
		//add new student
		
		//add existing student
		
		return "singlecourse.jsp";
		} else {
			return "redirect:/logout";
		}
		
	}
	
	@RequestMapping(value="/course/edit/{id}", method=RequestMethod.GET)
	private String editCourse(Model model,
							@PathVariable("id") Long id,
							HttpSession session) {
		model.addAttribute("course", courseService.singleCourse(id));
		
		if(userService.validateSession(session) == true) {
		//current user
		String email = (String) session.getAttribute("email");
		User currentUser = userService.singleUserByLogin(email);
		model.addAttribute("user", currentUser);
		
		return "editcourse.jsp";
	} else {
		return "redirect:/logout";
	}
	
}
	
	@RequestMapping(value="/course/edit/{id}", method=RequestMethod.PUT)
	private String editACourse(@Valid @ModelAttribute("course") Course course,
								BindingResult result,
								@PathVariable("id") Long id) {
		
		Course potentialCourse = courseService.createCourse(course, result);
		if(potentialCourse != null) {
			return "redirect:/dashboard";
		} else {
			return "editcourse.jsp";
		}
		
	}
	
	@RequestMapping(value="/course/delete/{id}", method=RequestMethod.DELETE)
	private String deleteCourse(@PathVariable("id") Long id) {
		courseService.deleteCourse(id);
		System.out.println("course deleted");
		
		return "redirect:/dashboard";
	}
	
	

}
