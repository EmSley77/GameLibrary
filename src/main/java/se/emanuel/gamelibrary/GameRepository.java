package se.emanuel.gamelibrary;
//Emanuel sleyman
//2024-03-21
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {

    List<Game> findGamesByNameContainingOrCategoryContainingOrMakerContaining (String search, String sea, String shdh);

    boolean existsByName(String name);
}
