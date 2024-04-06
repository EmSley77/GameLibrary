package se.emanuel.gamelibrary.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "customerid", nullable = false)
    private int customerId;
    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Basic
    @Column(name = "lastname", nullable = false, length = 45)
    private String lastname;
    @Basic
    @Column(name = "address", nullable = false, length = 45)
    private String address;
    @Basic
    @Column(name = "username", nullable = false, length = 45)
    private String username;
    @Basic
    @Column(name = "password", nullable = false, length = 45)
    private String password;
    @Basic
    @Column(name = "age", nullable = false)
    private int age;
    @Basic
    @Column(name = "role", nullable = false)
    private int role;

    public Customer(String name, String lastname, String address, String username, String password, int age, int role) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.username = username;
        this.password = password;
        this.age = age;
        this.role = role;
    }

    public Customer() {

    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerid) {
        this.customerId = customerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId && age == customer.age && role == customer.role && Objects.equals(name, customer.name) && Objects.equals(lastname, customer.lastname) && Objects.equals(address, customer.address) && Objects.equals(username, customer.username) && Objects.equals(password, customer.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, name, lastname, address, username, password, age, role);
    }
}
