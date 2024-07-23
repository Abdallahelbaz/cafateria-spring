package edu.cafeteria.Controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.cafeteria.Services.ItemService;
import edu.cafeteria.Services.LogService;
import edu.cafeteria.Services.OrderService;
import edu.cafeteria.model.Item;
import edu.cafeteria.model.Order;
import edu.cafeteria.model.Role;
import edu.cafeteria.model.User;
@Controller
@RequestMapping("/items")
public class ItemController {
	 
	 public static String UPLOAD_DIRECTORY =  "c:/uploads";
		 
    @Autowired
    private ItemService itemService;
    
    @Autowired
    private OrderService orderService;
    @Autowired
    private LogService logService;

    
    public ItemController() {
   	 
       Path uploadPath = Paths.get(UPLOAD_DIRECTORY);
       if (!Files.exists(uploadPath)) {
           try {
               Files.createDirectories(uploadPath);
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
}
    
    
    
    @GetMapping
    public String viewProducts(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/auth/login";
        }

        List<Item> items = itemService.getAllItems();
        model.addAttribute("items", items);
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("user", user);
        return "items";
 
    }

    @GetMapping("/order/{itemId}")
    public String orderProduct(@PathVariable Long itemId, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null || user.getRole() == Role.employee) {
            return "redirect:/auth/login";
        }

        Item item = itemService.getItemById(itemId);
        if (user.getRole() == Role.staff) {
            item.setPrice((float) (item.getPrice() * 0.8));  
        }
        model.addAttribute("item", item);
        return "order";
    }

    @PostMapping("/order")
    public String placeOrder(@RequestParam Long itemId, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null || user.getRole() == Role.employee) {
            return "redirect:/auth/login";
        }

       List<Item>  items = itemService.getAllItems( );
        Order order = new Order();
        order.setItems(items);
        order.setUser(user);
        order.setOrderDate(   new Date(System.currentTimeMillis()));
        order.setStatus("NEW");
        
        orderService.save(order);

        model.addAttribute("order", order);
        return "order_confirmation";
    }
    
    
    
    
    
    
    @GetMapping("/new")
    public String createItemForm(Model model) {
    	
        model.addAttribute("item", new Item());
        return "item_form";
    }

    @PostMapping
    public String saveItem(@ModelAttribute("item") Item item, @RequestParam("photoUpload") MultipartFile photoUpload
    		                           ,HttpSession session) {
    	User user = (User) session.getAttribute("user");
    	if (session.getAttribute("user") == null) {
            return "redirect:/auth/login";
        }
    	 if (!photoUpload.isEmpty()) {
             String fileName = photoUpload.getOriginalFilename();
             Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, fileName);
             try {
                 Files.write(fileNameAndPath, photoUpload.getBytes());
                 item.setPhotoUrl("/uploads/" + fileName);
              
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
    	logService.log(user.getUserName(), "added the item " + item.getName(),user.getRole().name());
        itemService.saveItem(item);
        return "redirect:/items";
    }

    @GetMapping("/edit/{id}")
    public String editItemForm(@PathVariable Long id, Model model) {
        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        return "itemUpdateForm";
    }

    @PostMapping("/edit/{id}")
    public String updateItem(@PathVariable Long id, @ModelAttribute("item") Item item,@RequestParam("photoUpload") MultipartFile photoUpload
    		, HttpSession session) {
 
    	User user = (User) session.getAttribute("user");
    	if (session.getAttribute("user") == null) {
            return "redirect:/auth/login";
        }
    	 if (!photoUpload.isEmpty()) {
             String fileName = photoUpload.getOriginalFilename();
             Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, fileName);
             try {
                 Files.write(fileNameAndPath, photoUpload.getBytes());
                item.setPhotoUrl("/uploads/" + fileName); 
             } catch (IOException e) {
                 e.printStackTrace();
             }
         } 
    	logService.log(user.getUserName(), "edited the item " + item.getName(),user.getRole().name()  );
         
    	  itemService.updateItem(id, item);
    	  
    	  return "redirect:/items"; 
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id, HttpSession session) {
    	User user = (User) session.getAttribute("user");
    	if (session.getAttribute("user") == null) {
            return "redirect:/auth/login";
        }
    	 logService.log(user.getUserName(), "deleted the item with id: " + id ,user.getRole().name() );
    	itemService.deleteItem(id);
        return "redirect:/items";
    }
}

