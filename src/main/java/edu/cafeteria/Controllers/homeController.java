package edu.cafeteria.Controllers;

import edu.cafeteria.Services.ItemService;
import edu.cafeteria.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class homeController {
	String MaskedEMail;
    @Autowired
    private ItemService itemService;
	public String userNameEmpl;
	public String userNameSTF;

    @GetMapping
    public String home(Model model) {
        return "redirect:/auth/login";
    }

    @GetMapping("/HomeStaff")
    public String homeAdmin(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/auth/login";
        }
        Long idd=(Long) ((User) session.getAttribute("user")).getId();
       
        model.addAttribute("userID", idd);
        model.addAttribute("userNameSTF",userNameSTF  );
        model.addAttribute("items2", itemService.getAllItems());
        return "HomeStaff";
    }

     @GetMapping("/HomeGuest")
    public String HomeGuest(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/auth/login";
        }
        
        Long idd=(Long) ((User) session.getAttribute("user")).getId();
        
        model.addAttribute("userID", idd);
        
       model.addAttribute("MaskedEMail",maskEmail(MaskedEMail)  ); 
        model.addAttribute("items", itemService.getAllItems());
        return "HomeGuest";
    }
    
    
    @GetMapping("/HomeEmployee")
    public String HomeEmployee(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/auth/login";
        }
        model.addAttribute("userNameEmpl",userNameEmpl  );
        return "HomeEmployee";
    }

   
    
    
    private String maskEmail(String email) {
        int atIndex = email.indexOf("@");
        if (atIndex <= 1) {
            return email; // Can't mask an email that has less than 2 characters before the '@'
        }
        StringBuilder maskedEmail = new StringBuilder();
        maskedEmail.append(email.charAt(0));
        maskedEmail.append("*****");
        maskedEmail.append(email.substring(atIndex - 1));
        return maskedEmail.toString();
    }
    
    
    
}
