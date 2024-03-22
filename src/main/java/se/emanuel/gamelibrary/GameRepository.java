package se.emanuel.gamelibrary;
//Emanuel sleyman
//2024-03-21
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {

    boolean existsByName(String name);
}
