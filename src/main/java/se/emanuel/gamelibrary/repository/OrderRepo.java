package se.emanuel.gamelibrary.repository;
//Emanuel sleyman
//2024-04-06
import org.springframework.data.jpa.repository.JpaRepository;
import se.emanuel.gamelibrary.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
