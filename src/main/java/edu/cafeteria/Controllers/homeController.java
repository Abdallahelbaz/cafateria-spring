package edu.cafeteria.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/auth")
public class homeController {

	
	@GetMapping
    public String home(Model model) {
		 return "redirect:/auth/login";
    }
	
	
	
}
