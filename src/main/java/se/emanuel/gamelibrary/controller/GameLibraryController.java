package se.emanuel.gamelibrary.controller;
//Emanuel sleyman
//2024-03-21
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.emanuel.gamelibrary.entity.Game;
import se.emanuel.gamelibrary.service.GameLibraryService;

import java.util.List;

@Controller
public class GameLibraryController {

    @Autowired
    GameLibraryService service;

    @GetMapping("gamelibrary")
    public String getLibrary(Model model) {
        model.addAttribute("getsite", "");
        return "redirect:/gamelibrarypage.html";
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
        String game = service.addGameToLibrary(name,maker,franchise,category,pegi,year,price);
        model.addAttribute("gametolibrary", game);
        return "redirect:/adminpage.html";
    }

    @PostMapping("removegame")
    public String removeGame(@RequestParam int id, Model model) {
        model.addAttribute("removal", service.removeGameFromLibrary(id));
        return "redirect:/adminpage.html";
    }

    @GetMapping("allgames")
    public String allGame(Model model) {
       List<Game> games = service.getAllGames();
        if (!games.isEmpty()) {
            model.addAttribute("list", games);
            return "allgamespageadmin";
        } else return "redirect:/adminpage.html";
    }

    @GetMapping("action")
    public String action(Model model) {
        List<Game> games = service.getAction();
        if (!games.isEmpty()) {
            model.addAttribute("actionlist", games);
            return "actiongamespage";
        } else return "gamelibrarypage";
    }


}
