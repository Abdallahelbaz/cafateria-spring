package edu.cafeteria.Controllers;

import edu.cafeteria.model.Role;
import edu.cafeteria.model.User;
import edu.cafeteria.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping("/auth")
public class homeController {

	
	@GetMapping
    public String home(Model model) {
		 return "redirect:/auth/login";
    }
	
	@GetMapping("/HomeAdmin")
    public String homeAdmin(Model model) {
		 return "HomeAdmin";
    }
	@GetMapping("/HomeEmployee")
    public String HomeEmployee(Model model) {
		 return "HomeEmployee";
    }
	@GetMapping("/HomeGuest")
    public String HomeGuest(Model model) {
		 return "HomeGuest";
    }
}
