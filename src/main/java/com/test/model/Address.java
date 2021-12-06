//package com.test.model;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "address")
//public class Address {
//
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @Column(name = "id")
//    private int id;
//
//    @Column(name = "street", nullable = false)
//    private String street;
//
//    @Column(name = "number", nullable = false)
//    private String number;
//
//    @Column(name = "city", nullable = false)
//    private String city;
//
//    @OneToMany(mappedBy = "address")
//    @JsonBackReference
//    private List<User> users;
//
//
//    public Address() {
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Address(String street, String number, String city) {
//        this.street = street;
//        this.number = number;
//        this.city = city;
//
//    }
//
//    public Address(String street, String number, String city, List<User> users) {
//        this.street = street;
//        this.number = number;
//        this.city = city;
//        this.users = users;
//    }
//
//    public Address(int id, String street, String number, String city, List<User> users) {
//        this.id = id;
//        this.street = street;
//        this.number = number;
//        this.city = city;
//        this.users = users;
//    }
//
//    public String getStreet() {
//        return street;
//    }
//
//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//    public String getNumber() {
//        return number;
//    }
//
//    public void setNumber(String number) {
//        this.number = number;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }
//}
