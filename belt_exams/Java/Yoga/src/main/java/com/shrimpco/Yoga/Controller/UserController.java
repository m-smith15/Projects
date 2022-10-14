package com.shrimpco.Yoga.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shrimpco.Yoga.Model.User;
import com.shrimpco.Yoga.Service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping( value="/", method=RequestMethod.GET)
	private String loginPage(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("user", new User());
		return "index.jsp";
	}
	
	@RequestMapping( value="/register", method=RequestMethod.POST)
	private String register(@Valid @ModelAttribute("newUser") User newUser,
							BindingResult bindingResult,
							HttpSession session,
							RedirectAttributes redirectAttribute,
							Model model) {
		
		 
		 if(userService.registerUser(newUser, bindingResult) != null){
			//no errors create user and add email/id to session
			userService.createUser( newUser );
			session.setAttribute("email", newUser.getEmail() );
			session.setAttribute("id", newUser.getId() );
			session.setAttribute("first_name", newUser.getFirst_name() );
			session.setAttribute("last_name", newUser.getLast_name() );
			return "redirect:/dashboard";
		}
		 else {
			 model.addAttribute("user", new User());
			 return "index.jsp";
		 }
	}
	
	@RequestMapping( value="/login", method=RequestMethod.POST)
	private String login(@Valid @ModelAttribute("user") User user,
						BindingResult bindingResult,
						HttpSession session,
						Model model) {
		//if errors
		User potentialUser = userService.login(user, bindingResult);
		if(potentialUser != null) {
			session.setAttribute("email", potentialUser.getEmail() );
			session.setAttribute("id", potentialUser.getId() );
			session.setAttribute("first_name", potentialUser.getFirst_name() );
			session.setAttribute("last_name", potentialUser.getLast_name() );
			return "redirect:/dashboard";
		}
		else {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
	} 
	
	
	@RequestMapping (value="/logout", method=RequestMethod.GET)
	private String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
