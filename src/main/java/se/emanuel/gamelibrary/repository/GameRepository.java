package se.emanuel.gamelibrary.repository;
//Emanuel sleyman
//2024-03-21
import org.springframework.data.jpa.repository.JpaRepository;
import se.emanuel.gamelibrary.entity.Game;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {

    List<Game> findGamesByNameContainingOrCategoryContainingOrMakerContaining (String search, String sea, String shdh);
    List<Game> findGamesByCategoryContainingIgnoreCaseOrNameContainingIgnoreCaseOrNameEndingWithOrNameContainsIgnoreCaseOrMakerContainsIgnoreCaseOrMakerEndingWithOrNameBetween(String s, String f, String d, String h, String i, String o, String oo, String pl);
    List<Game> findGameByGameid(int id);
    boolean existsByName(String name);
    List<Game> findGamesByCategoryContainingIgnoreCase(String category);
}
