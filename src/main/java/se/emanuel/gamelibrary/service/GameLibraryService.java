package se.emanuel.gamelibrary.service;
//Emanuel sleyman
//2024-03-21
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import se.emanuel.gamelibrary.entity.Game;
import se.emanuel.gamelibrary.repository.GameRepository;

import java.util.List;

@Service
@SessionScope
public class GameLibraryService {

    @Autowired
    GameRepository repository;

    public String addGameToLibrary(String name, String maker, String franchise, String category, int pegi, int year, int price) {
        Game game = new Game();

        game.setName(name);
        game.setMaker(maker);
        game.setFranchise(franchise);
        game.setCategory(category);
        game.setPegi(pegi);
        game.setReleaseyear(year);
        game.setPrice(price);

        if (!repository.existsByName(name)) {
            synchronized (this) {
                repository.save(game);
                return "game saved";
            }
        }
        else return "Could not save game, already exists!";
    }

    public String removeGameFromLibrary(int id) {
        getAllGames();
        for (Game game : getAllGames()) {
            if (id == game.getGameid()) {
                repository.delete(game);
                return "Deletion successful!";
            }
        }
        return "Could not match id with game";
    }

    public List<Game> getAllGames() {
        return repository.findAll();
    }

    public List<Game> getAction() {
        return repository.findGamesByCategoryContainingIgnoreCase("Action, fps");
    }
    public List<Game> getAdventure() {
        return repository.findGamesByCategoryContainingIgnoreCase("Adventure, free play");
    }
    public List<Game> getSneaky() {
        return repository.findGamesByCategoryContainingIgnoreCase("Sneaky, free play");
    }
}
