package se.emanuel.gamelibrary.repository;
//Emanuel sleyman
//2024-04-06
import org.springframework.data.jpa.repository.JpaRepository;
import se.emanuel.gamelibrary.entity.Customer;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    List<Customer> findCustomerByUsernameAndPassword(String u, String p);
    List<Customer> findCustomerByUsername(String u);
    boolean existsByUsername(String username);
}
