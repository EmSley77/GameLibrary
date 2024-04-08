package se.emanuel.gamelibrary.service;
//Emanuel sleyman
//2024-04-05
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.emanuel.gamelibrary.entity.Game;
import se.emanuel.gamelibrary.repository.GameRepository;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    GameRepository gameRepository;
    // needs better search function, empty space gets removed! easier finding
    public List<Game> search(String s) {
        List<Game> search = gameRepository.findGamesByCategoryContainingIgnoreCaseOrNameContainingIgnoreCaseOrNameEndingWithOrNameContainsIgnoreCaseOrMakerContainsIgnoreCaseOrMakerEndingWithOrNameBetween(s,s,s,s,s,s,s,s);
        return search;
    }
}
