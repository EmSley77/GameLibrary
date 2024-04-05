package se.emanuel.gamelibrary;
//Emanuel sleyman
//2024-04-05
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    GameRepository gameRepository;

    public List<Game> search(String s) {
        List<Game> search = gameRepository.findGamesByNameContainingOrCategoryContainingOrMakerContaining(s,s ,s);
        return search;
    }
}
