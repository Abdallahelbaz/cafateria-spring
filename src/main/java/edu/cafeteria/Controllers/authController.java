package edu.cafeteria.Controllers;


import edu.cafeteria.model.User;
import edu.cafeteria.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class authController {

	
	@Autowired
    private UserService userService;
	 

@GetMapping("/signup")
public String signupForm(Model model) {
    model.addAttribute("user", new User());
    return "signup";
}

@PostMapping("/signup")
public String signup(@ModelAttribute User user, Model model) {
    user.setRole(Role.GUEST); // Default role
    userService.signup(user);
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