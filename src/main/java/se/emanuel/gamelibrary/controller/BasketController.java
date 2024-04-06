package se.emanuel.gamelibrary.controller;
//Emanuel sleyman
//2024-04-06
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.emanuel.gamelibrary.service.BasketService;

@Controller
public class BasketController {

    @Autowired
    BasketService basketService;

    @GetMapping("basket")
    public String getBasket(Model model) {
        model.addAttribute("basket", basketService.getBasket());
        return "basketpage";
    }

    @PostMapping("addbasket")
    public String addB(Model model, @RequestParam int id) {
        model.addAttribute("basketadd", basketService.addBasket(id));
        model.addAttribute("basket", basketService.getBasket());
        return "basketpage";
    }

    @PostMapping("removebasket")
    public String removeB(Model model, @RequestParam int id) {
        model.addAttribute("remove", basketService.remove(id));
        model.addAttribute("basket", basketService.getBasket());
        return "basketpage";
    }

    @GetMapping("cost")
    public String getTotal(Model model) {
        model.addAttribute("cost", basketService.getTotalCost());
        return "basketpage";
    }

}
