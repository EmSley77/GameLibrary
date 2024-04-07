package se.emanuel.gamelibrary.service;
//Emanuel sleyman
//2024-04-06

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
        List<Customer> findPerson = customerRepo.findCustomerByUsernameAndPassword(username, password);
        if (findPerson == null || findPerson.isEmpty()) {
            return "User not existent or wrong credentials";
        }

        for (Customer customer : findPerson) {
            for (Game game : basket) {
                for (Order order1 : order) {
                    if (game.getGameid() == order1.getGameId()) {
                        if (!orderAlreadyExists(order1, customer.getCustomerId())) {
                            createOrder(game, customer);
                            break;
                        }
                    }
                }
            }
        }
        return "Success";
    }

    private boolean orderAlreadyExists(Order order, int customerId) {
        return order.getCustomerId() == customerId;
    }

    public void createOrder(Game game, Customer customer) {
        Order newOrder = new Order();
        newOrder.setGameId(game.getGameid());
        newOrder.setCustomerId(customer.getCustomerId());
        int newTotalP = game.getPrice() * game.getAmount();
        newOrder.setTotalPrice(newTotalP);
        newOrder.setTime(Timestamp.valueOf(LocalDateTime.now()));
        newOrder.setAmount(game.getAmount());
        orderRepo.save(newOrder);
    }

    public List<Game> addBasket(int id) {
        List<Game> product = gameRepository.findGameByGameid(id);
        if (product.isEmpty()) {
            throw new IllegalArgumentException("could not match id with gameId");
        }
        basket.addAll(product);
        return basket;
    }


    public List<Game> changeAmount(int id, int newAmount) {
        List<Game> findGame = gameRepository.findGameByGameid(id);
            if (findGame == null && findGame.isEmpty() ) {
                throw new IllegalArgumentException("Cannot find game with given ID");
            }
                for (Game game : findGame) {
                game.setAmount(newAmount);
                int newPrice = newAmount * game.getPrice();
                game.setPrice(newPrice);
            }

        return basket;
    }

    public List<Game> remove(int id) {
        List<Game> product = gameRepository.findGameByGameid(id);
        for (Game game : product) {
            if (game.getGameid() == id) {
                basket.remove(game);
                break;
            }
        }
        return basket;
    }

    public int getTotalCost() {
        int totalC = 0;
        for (Game game: basket) {
            totalC += game.getPrice() * game.getAmount();
        }
        return totalC;
    }

    public List<Game> getBasket() {
        return basket;
    }


}
