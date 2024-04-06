package se.emanuel.gamelibrary.service;
//Emanuel sleyman
//2024-04-06
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.SessionScope;
import se.emanuel.gamelibrary.entity.Customer;
import se.emanuel.gamelibrary.repository.CustomerRepo;

@Service
@SessionScope
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    @Transactional
    public String createLogin(String name, String lastname, String address, String username, String password, int age) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setLastname(lastname);
        customer.setAddress(address);
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setAge(age);
        customer.setRole(0);

        if (!customerRepo.existsByUsername(username) && age > 15) {
            customerRepo.save(customer);
            return "Successfull saved";
        } else return "already exists";
    }
}
