package se.emanuel.gamelibrary.controller;
//Emanuel sleyman
//2024-04-06
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.emanuel.gamelibrary.service.AdminService;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("admin")
    public String returnPage() {
        return"redirect:/adminpage.html";
    }

    @PostMapping("asignadmin")
    public String addAdmin(Model model,
                           @RequestParam String name,
                           @RequestParam String lastname,
                           @RequestParam String address,
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam int age) {
        model.addAttribute("admin",adminService.createAdmin(name, lastname, address, username, password, age));
        return "redirect:/adminpage.html";
    }
    @GetMapping("orders")
    public String getAllOrders(Model model) {
        if (!adminService.getOrders().isEmpty()) {
            model.addAttribute("orders", adminService.getOrders());
            return "allorderspage";
        } else return "redirect:/adminpage.html";
    }
}
