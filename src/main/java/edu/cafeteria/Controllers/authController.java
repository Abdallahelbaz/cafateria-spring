package edu.cafeteria.Controllers;


import edu.cafeteria.model.Role;
import edu.cafeteria.model.User;
import edu.cafeteria.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class authController {

	
	@Autowired
    private UserService userService;
	 @Autowired
	    private ValidationService validationService;
	 

@GetMapping("/signup")
public String signupForm(Model model) {
    model.addAttribute("user", new User());
    return "signup";
}

@PostMapping("/signup")
public String signup(@ModelAttribute User user, Model model) {
	 String s="TTTTTTTTTTTTTTTTTTTT";
	 
	 System.out.println(s);
	 System.out.println(user.getEmail());
	 if ("employee".equals(user.getRole())) {
         if (!validationService.isValidEmployeeID(user.getEmployeeID().toString())) {
        	 s="TTTTTTTTTTTTTTTTTTTTEmployee";System.out.println(s);
             model.addAttribute("error", "Invalid Employee ID.");
             return "signup";
         }
//         User user3=new User();
//         user3.setFirstName(user.getFirstName());
//         user3.setLastName(user.getLastName());
//         user3.setEmail(user.getEmail());
//         user3.setUserName(user.getUserName());
//         user3.setPassword(user.getPassword());
//         user3.setPhone(user.getPhone());
//         user3.setStaffID(user.getStaffID());
//         user3.setRole(user.getRole());//Role.guest);//user.getRole());  
//         userService.signup(user3);
         
         
         
     } else if ("staff".equals(user.getRole())) {
         if (!validationService.isValidStaffID(user.getStaffID().toString())) {
        	 s="TTTTTTTTTTTTTTTTTTTTInvalid Staff ID";System.out.println(s);
             model.addAttribute("error", "Invalid Staff ID.");
             return "signup"; 
         }
     }
//         User user4=new User();
//         user4.setFirstName(user.getFirstName());
//         user4.setLastName(user.getLastName());
//         user4.setEmail(user.getEmail());
//         user4.setUserName(user.getUserName());
//         user4.setPassword(user.getPassword());
//         user4.setPhone(user.getPhone());
//         user4.setStaffID(user.getStaffID());
//         
//         
//         user4.setRole(user.getRole());//Role.guest);//user.getRole());  
//         userService.signup(user4);
//     }else {
//    	  System.out.println("99999999999999"+s);
//    	  User user1=new User();
//	user1.setRole(user.getRole()); 
//	  
//	user1.setEmail(user.getEmail());
//    userService.signup(user1);
//    return "redirect:/auth/login";
//     }
         
   	  
    
       userService.signup(user );
	return "redirect:/auth/login";
	
   
	 
}

@GetMapping("/login")
public String loginForm(Model model) {
    model.addAttribute("user", new User());
    return "login";
}

@PostMapping("/login")
public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
    return userService.login(email, password).map(user -> {
        session.setAttribute("user", user);
        return "redirect:/users";
    }).orElseGet(() -> {
        model.addAttribute("error", "Invalid email or password");
        return "login";
    });
}

@GetMapping("/logout")
public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/auth/login";
}
}