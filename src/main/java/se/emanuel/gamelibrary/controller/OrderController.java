package se.emanuel.gamelibrary.controller;
//Emanuel sleyman
//2024-04-06
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
        if (!basketService.getBasket().isEmpty()) {
            model.addAttribute("order", basketService.order(u,p));
            return "thxpage";
        } else{
            model.addAttribute("basket", basketService.getBasket());
            return "basketpage";
        }

    }
}
