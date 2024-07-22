package edu.cafeteria.Controllers;


import edu.cafeteria.model.Role;
import edu.cafeteria.model.User;
import edu.cafeteria.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
 

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class authController {
	@Autowired
    private 	homeController homecontrollerVAR;
	@Autowired
    private UserService userService;
	 @Autowired
	    private ValidationService validationService;
	 @Autowired
	    private homeController homController;
	 

@GetMapping("/signup")
public String signupForm(Model model) {
    model.addAttribute("user", new User());
    return "LandingPage";   
}
@GetMapping("/signup/guest")
public String guestSignup(Model model) {
    model.addAttribute("user", new User());
    return "guestSignup";
}

@GetMapping("/signup/staff")
public String staffSignup(Model model) {
    model.addAttribute("user", new User());
    return "staffSignup";
}

@GetMapping("/signup/employee")
public String employeeSignup(Model model) {
    model.addAttribute("user", new User());
    return "employeeSignup";
}

@GetMapping("/error")
public String error(Model model) {
    
    return "error";
}
 
@PostMapping("/signup")
 public String signupSubmit(@ModelAttribute User user, Model model) {
	
	 
    try {
        if (user.getRole() == Role.employee) {
            if (!validationService.isValidEmployeeID(user.getEmployeeID().toString())) {
                model.addAttribute("error", "Invalid Employee ID.");
                return user.getRole() == Role.employee ? "employeeSignup" : user.getRole() == Role.staff ? "staffSignup" : "guestSignup";
            }
            if (validationService.isEmployeeIDTaken(user.getEmployeeID())) { 
 
            return "LandingPageBIS";
            }
        } else if (user.getRole() == Role.staff) {
            if (!validationService.isValidStaffID(user.getStaffID().toString())) {
                model.addAttribute("error", "Invalid Staff ID.");
                return user.getRole() == Role.staff ? "staffSignup" : "guestSignup";
            }
            if (validationService.isStaffIDTaken(user.getStaffID())) {

            return "LandingPageBIS";
            }
        }
        userService.signup(user);
        if (user.getRole() == Role.guest) {
        	return "redirect:/HomeGuest";
        	}else
        return "redirect:/auth/login";
    } catch (ConversionFailedException e) {
    	
        model.addAttribute("error", "Invalid Staff ID or Employee ID.");
        return user.getRole() == Role.employee ? "employeeSignup" : user.getRole() == Role.staff ? "staffSignup" : "guestSignup";
    }
 
 
}

@GetMapping("/guestLogin")
public String guestLoginForm(Model model) {
    model.addAttribute("user", new User());  
    return "guestLogin";  
}

@PostMapping("/guestLogin")
public String guestLogin(@RequestParam String email, HttpSession session,Model model) {
 
	 return userService.guestLogin(email ).map(user -> {
	        session.setAttribute("user", user);
	        session.setAttribute("userRole", user.getRole());
	        
	        switch (user.getRole()) {
	            case employee:
	                return "redirect:/HomeEmployee";
	            case staff:
	                return "redirect:/HomeStaff";
	            case guest:
	                 {  
	                	  homecontrollerVAR.MaskedEMail=user.getEmail();
	                	  return "redirect:/HomeGuest"; 
	                   
	            	 }
	            default:
	                model.addAttribute("error", "Unknown role");
	                return "login";
	        }
	    }).orElseGet(() -> {
	        model.addAttribute("error", "Invalid email or password");
	        
	        return "login";
	    });
	 
}

@GetMapping("/login")
public String loginForm(Model model) {
    model.addAttribute("user", new User());
    return "login";
}

@PostMapping("/login")
public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
   System.out.println("herlloo login");
	return userService.login(email, password).map(user -> {
        session.setAttribute("user", user);
        switch (user.getRole()) {
            case employee:
            {
            	homecontrollerVAR.userNameEmpl=user.getUserName();
            return "redirect:/HomeEmployee";
            }
                
            case staff:
            {
            	homecontrollerVAR.userNameSTF=user.getUserName();
                return "redirect:/HomeStaff";
            }
                
            case guest:
                return "redirect:/HomeGuest";
            default:
                model.addAttribute("error", "Unknown role");
                return "login";
        }
    }).orElseGet(() -> {
        model.addAttribute("error", "Invalid email or password");
        return "login";
    });
}


@PostMapping("/logout")
public String logout(HttpSession session) {
    session.invalidate();
    homController.google=false;
   
    return "redirect:/auth/login";
}

@PostMapping("/auth/deleteUser")
@ResponseBody
public ResponseEntity<?> deleteUser(@ModelAttribute User user) {
    userService.deleteUser(user.getId());
    return ResponseEntity.ok("User deleted");
}


}