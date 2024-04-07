package se.emanuel.gamelibrary.entity;
//Emanuel sleyman
//2024-04-06
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "game", schema = "gamelibrary", catalog = "")
public class Game {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "gameid", nullable = false)
    private int gameid;
    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Basic
    @Column(name = "maker", nullable = false, length = 45)
    private String maker;
    @Basic
    @Column(name = "franchise", nullable = false, length = 45)
    private String franchise;
    @Basic
    @Column(name = "category", nullable = false, length = 45)
    private String category;
    @Basic
    @Column(name = "pegi", nullable = false)
    private int pegi;
    @Basic
    @Column(name = "releaseyear", nullable = false)
    private int releaseyear;
    @Basic
    @Column(name = "amount", nullable = false)
    private int amount;
    @Basic
    @Column(name = "price", nullable = false)
    private int price;

    public Game() {

    }

    public Game(String name, String maker, String franchise, String category, int pegi, int releaseyear, int price, int amount) {
        this.name = name;
        this.maker = maker;
        this.franchise = franchise;
        this.category = category;
        this.pegi = pegi;
        this.releaseyear = releaseyear;
        this.price = price;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGameid() {
        return gameid;
    }

    public void setGameid(int gameid) {
        this.gameid = gameid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getFranchise() {
        return franchise;
    }

    public void setFranchise(String franchise) {
        this.franchise = franchise;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPegi() {
        return pegi;
    }

    public void setPegi(int pegi) {
        this.pegi = pegi;
    }

    public int getReleaseyear() {
        return releaseyear;
    }

    public void setReleaseyear(int releaseyear) {
        this.releaseyear = releaseyear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game that = (Game) o;
        return gameid == that.gameid && pegi == that.pegi && releaseyear == that.releaseyear && Objects.equals(name, that.name) && Objects.equals(maker, that.maker) && Objects.equals(franchise, that.franchise) && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameid, name, maker, franchise, category, pegi, releaseyear);
    }
}
