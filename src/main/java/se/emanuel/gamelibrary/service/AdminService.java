package se.emanuel.gamelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.emanuel.gamelibrary.entity.Customer;
import se.emanuel.gamelibrary.repository.CustomerRepo;

@Service
public class AdminService {

    @Autowired
    CustomerRepo customerRepo;
    @Transactional
    public String createAdmin(String name, String lastname, String address, String username, String password, int age) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setLastname(lastname);
        customer.setAddress(address);
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setAge(age);
        customer.setRole(1);

        if (!customerRepo.existsByUsername(username) && age > 18) {
            customerRepo.save(customer);
            return "Successfull saved";
        } else return "already exists";
    }
}
