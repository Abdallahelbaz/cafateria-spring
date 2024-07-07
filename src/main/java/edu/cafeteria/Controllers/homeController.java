package edu.cafeteria.Controllers;

import edu.cafeteria.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class homeController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public String home(Model model) {
        return "redirect:/auth/login";
    }

    @GetMapping("/HomeStaff")
    public String homeAdmin(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/auth/login";
        }
        model.addAttribute("items2", itemService.getAllItems());
        return "HomeStaff";
    }

    @GetMapping("/HomeEmployee")
    public String HomeEmployee(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/auth/login";
        }
        return "HomeEmployee";
    }

    @GetMapping("/HomeGuest")
    public String HomeGuest(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/auth/login";
        }
        
        model.addAttribute("items", itemService.getAllItems());
        return "HomeGuest";
    }
}
