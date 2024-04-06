package se.emanuel.gamelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import se.emanuel.gamelibrary.entity.Customer;
import se.emanuel.gamelibrary.entity.Game;
import se.emanuel.gamelibrary.entity.Order;
import se.emanuel.gamelibrary.repository.CustomerRepo;
import se.emanuel.gamelibrary.repository.GameRepository;
import se.emanuel.gamelibrary.repository.OrderRepo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@SessionScope
public class BasketService {
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    GameRepository gameRepository;

    public ArrayList<Game> basket = new ArrayList<>();
    public ArrayList<Order> order = new ArrayList<>();

    public String order(String username, String password) {
        try {
            List<Customer> findPerson = customerRepo.findCustomerByUsernameAndPassword(username, password);
            for (Customer customer : findPerson) {
                for (Game game : basket) {
                    Order order = new Order();
                    order.setAmount(1);
                    order.setGameId(game.getGameid());
                    order.setCustomerId(customer.getCustomerId());
                    order.setTime(Timestamp.valueOf(LocalDateTime.now()));
                    orderRepo.save(order);
                }
            }
            return "success";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public List<Game> addBasket(int id) {
        List<Game> product = gameRepository.findGameByGameid(id);
        for (Game game:product) {
            if (game.getGameid() == id) {
                basket.add(game);
                break;
            }
        }
        return basket;
    }

    public List<Game> remove(int id) {
        List<Game> product = gameRepository.findGameByGameid(id);
        for (Game game:product) {
            if (game.getGameid() == id) {
                basket.remove(game);
                break;
            }
        }
        return basket;
    }

    public int getTotalCost() {
        int totalC =0;
        for (int i = 0; i < basket.size(); i++) {
             totalC += basket.get(i).getPrice();
        }
        return totalC;
    }

    public List<Game> getBasket() {
        return basket;
    }
}
