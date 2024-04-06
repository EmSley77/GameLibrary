package se.emanuel.gamelibrary.service;
//Emanuel sleyman
//2024-04-06
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import se.emanuel.gamelibrary.entity.Customer;
import se.emanuel.gamelibrary.repository.CustomerRepo;

import java.util.List;

@Service
@SessionScope
public class LoginService {

    @Autowired
    CustomerRepo customerRepo;

    public String login(String username, String password) {
        List<Customer> findperson = customerRepo.findCustomerByUsernameAndPassword(username, password);
        if (!findperson.isEmpty() && findperson != null) {
            return "Welcome";
        } else return "failed login";
    }

    public int getRole(String u, String p) {
        int role =0;
        List<Customer> findperson = customerRepo.findCustomerByUsernameAndPassword(u, p);
        for (Customer customer:findperson) {
            role += customer.getRole();
        }
        return role;
    }
}
