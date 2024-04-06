package se.emanuel.gamelibrary.controller;
//Emanuel sleyman
//2024-04-06
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.emanuel.gamelibrary.service.LoginService;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("login")
    public String getSite() {
        return "redirect:/loginpage.html";
    }

    @PostMapping("logintry")
    public String login(Model model, @RequestParam String u, @RequestParam String p) {
        String result = loginService.login(u,p);
        if (result.equals("Welcome") && loginService.getRole(u, p) == 0) {
            return "redirect:/gamelibrarypage.html";
        } else return "redirect:/adminpage.html";
    }
}
