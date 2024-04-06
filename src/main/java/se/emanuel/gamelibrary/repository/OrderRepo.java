package se.emanuel.gamelibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.emanuel.gamelibrary.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
