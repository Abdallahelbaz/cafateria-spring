package edu.cafeteria.Controllers;
 

import edu.cafeteria.model.Notification; 
import edu.cafeteria.model.Role;
import edu.cafeteria.Services.NotificationService;
import edu.cafeteria.Services.OrderService;
import edu.cafeteria.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestMapping; 

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional; 
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    

    @GetMapping("/{userID}")
    public String viewNotifications(@PathVariable Long userID,Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null || !(user.getRole() == Role.guest || user.getRole() == Role.staff)) {
            return "redirect:/auth/login";
        }
        
        Optional<List<Notification>> notifications = notificationService.findByUserId(userID);
        List<Notification> L=notifications.get();
        model.addAttribute("notifications", L);
        return "notifications";
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.noContent().build();
    }
 
}
