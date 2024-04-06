package se.emanuel.gamelibrary.entity;
//Emanuel sleyman
//2024-04-06
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "`order`")
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idorder", nullable = false)
    private int orderId;
    @Basic
    @Column(name = "customerid", nullable = false)
    private int customerId;
    @Basic
    @Column(name = "gameid", nullable = false)
    private int gameId;
    @Basic
    @Column(name = "amount", nullable = false)
    private int amount;
    @Basic
    @Column(name = "time", nullable = false)
    private Timestamp time;

    public Order(int customerId, int gameId, int amount, Timestamp time) {
        this.customerId = customerId;
        this.gameId = gameId;
        this.amount = amount;
        this.time = time;
    }

    public Order() {

    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int idorder) {
        this.orderId = idorder;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerid) {
        this.customerId = customerid;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameid) {
        this.gameId = gameid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
