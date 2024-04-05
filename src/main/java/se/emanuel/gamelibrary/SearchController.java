package se.emanuel.gamelibrary;
//Emanuel sleyman
//2024-04-05
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
    @Autowired
    SearchService service;

    @GetMapping("searchgames")
    public String search(Model model, @RequestParam String s) {
        if (!service.search(s).isEmpty()) {
            model.addAttribute("searchresult",service.search(s));
            return "searchpage";
        } else return "gamelibrarypage";

    }
}
