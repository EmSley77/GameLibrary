package se.emanuel.gamelibrary.service;
//Emanuel sleyman
//2024-04-06

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    public String order(String username, String password) {
            List<Customer> findPerson = customerRepo.findCustomerByUsernameAndPassword(username, password);
            if (findPerson == null || findPerson.isEmpty()) {
                return "user not existent";
            } else {
                for (Customer customer : findPerson) {
                    for (Game game : basket) {
                        for (Order order1 : order) {
                            if (game.getGameid() == order1.getGameId()) {
                                if(!orderAlreadyExists(order1, customer.getCustomerId()) && !basket.isEmpty()) {
                                    Order newOrder = new Order();
                                    newOrder.setGameId(game.getGameid());
                                    newOrder.setCustomerId(customer.getCustomerId());
                                    int newTotalP = game.getPrice() * game.getAmount();
                                    newOrder.setTotalPrice(newTotalP);
                                    newOrder.setTime(Timestamp.valueOf(LocalDateTime.now()));
                                    newOrder.setAmount(game.getAmount());
                                    orderRepo.save(newOrder);
                                    break;
                                } else return "basket is empty";
                            }
                        }
                    }
                }
                return "success";
            }
    }
    private boolean orderAlreadyExists(Order order, int customerId) {
        return order.getCustomerId() == customerId;
    }


    public List<Game> addBasket(int id) {
        List<Game> product = gameRepository.findGameByGameid(id);
        if (product == null) {
            throw new IllegalArgumentException("product with id not found");
        }
        for (Game game : product) {
            game.setAmount(1);
            game.setPrice(game.getPrice());
        }
        basket.addAll(product);
        return basket;
    }


    public List<Game> changeAmount(int id, int newAmount) {
        for (Game game : basket) {
            if (game.getGameid() == id) {
                int oldAmount = game.getAmount();
                game.setAmount(newAmount + oldAmount);
                int singleGamePrice = game.getPrice();
                int newPrice = (newAmount + oldAmount) * singleGamePrice;
                game.setPrice(newPrice);
                break;
            } else {
                throw new IllegalArgumentException("Game with ID " + id + " not found in the basket");
            }
        }
        return basket;
    }

    public List<Game> removeAmount(int id, int delAmount) {
        for (int i = 0; i < basket.size();i++) {
            Game game = basket.get(i);
            if (game.getGameid() == id) {
                int oldAmount = game.getAmount();
                if (game.getAmount() < 1) {
                    basket.remove(i);
                }else {
                    int newAmount = oldAmount - delAmount;
                    game.setAmount(newAmount);
                    int singleGamePrice = game.getPrice() / oldAmount;
                    int newPrice = newAmount * singleGamePrice;
                    game.setPrice(newPrice);
                    break;
                }
            }
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
