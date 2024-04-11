package se.emanuel.gamelibrary.controller;
//Emanuel sleyman
//2024-04-06
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.emanuel.gamelibrary.service.CustomerService;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/create")
    public String getLoginCreate() {
        return "redirect:/registerpage.html";
    }
    @PostMapping("createlogin")
    public String addUser(Model model,
                           @RequestParam String name,
                           @RequestParam String lastname,
                           @RequestParam String address,
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam int age) {
        model.addAttribute("admin",customerService.createLogin(name, lastname, address, username, password, age));
        return "redirect:/loginp.html";
    }
}
