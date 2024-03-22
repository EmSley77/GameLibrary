package se.emanuel.gamelibrary;
//Emanuel sleyman
//2024-03-21
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameLibraryController {

    @Autowired
    GameLibraryService service;

    @GetMapping("gamelibrary")
    public String getLibrary(Model model) {
        model.addAttribute("getsite", "");
        return "gamelibrarypage";
    }

    @PostMapping("addgame")
    public String addGame(Model model,
                          @RequestParam String name,
                          @RequestParam  String maker,
                          @RequestParam  String franchise,
                          @RequestParam  String category,
                          @RequestParam  int pegi,
                          @RequestParam  int year,
                          @RequestParam  int price)
    {
        String game =  service.addGameToLibrary(name,maker,franchise,category,pegi,year,price);
        model.addAttribute("gametolibrary", game);
        return "gamelibrarypage";
    }

    @PostMapping("removegame")
    public String removegame(@RequestParam int id, Model model) {
        model.addAttribute("removal", service.removeGameFromLibrary(id));
        service.getAllGames();
        return "gamelibrarypage";
    }

    @GetMapping("allGames")
    public String allGame(Model model) {

        model.addAttribute("gamelist", service.getAllGames());
        return "gamelibrarypage";
    }

}
