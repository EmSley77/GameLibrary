package se.emanuel.gamelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.emanuel.gamelibrary.service.BasketService;

@Controller
public class OrderController {

    @Autowired
    BasketService basketService;

    @PostMapping("order")
    public String order(Model model, @RequestParam String u, @RequestParam String p) {
        model.addAttribute("order", basketService.order(u,p));

        return "thxpage";
    }
}
