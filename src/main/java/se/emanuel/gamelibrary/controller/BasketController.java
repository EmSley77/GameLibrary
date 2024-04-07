package se.emanuel.gamelibrary.controller;
//Emanuel sleyman
//2024-04-06
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("baskets")
    public String getBasket(Model model) {
        if(!basketService.getBasket().isEmpty()) {
            model.addAttribute("basket", basketService.getBasket());
            model.addAttribute("total", basketService.getTotalPrice());
            return "basketpage";
        } else return "searchpage";
    }

    @PostMapping("addbaskets")
    public String addB(Model model, @RequestParam int id) {
        model.addAttribute("basketadd", basketService.addBasket(id));
        model.addAttribute("basket", basketService.getBasket());
        model.addAttribute("total", basketService.getTotalPrice());

        return "basketpage";
    }

    @PostMapping("removebaskets")
    public String removeB(Model model, @RequestParam int id) {
        model.addAttribute("remove", basketService.remove(id));
        model.addAttribute("basket", basketService.getBasket());
        model.addAttribute("total", basketService.getTotalPrice());
        return "basketpage";
    }

    @PostMapping("changes")
    public String changeAmount(Model model, @RequestParam int id, @RequestParam int newAmount) {
        model.addAttribute("change", basketService.addAmount(id,newAmount ));
        model.addAttribute("basket", basketService.getBasket());
        model.addAttribute("total", basketService.getTotalPrice());
        return "basketpage";
    }

    @PostMapping("change")
    public String removeAmount(Model model, @RequestParam int id, @RequestParam int newAmountDel) {
        model.addAttribute("change", basketService.removeAmount(id,newAmountDel ));
        model.addAttribute("basket", basketService.getBasket());
        model.addAttribute("total", basketService.getTotalPrice());
        return "basketpage";
    }

}
