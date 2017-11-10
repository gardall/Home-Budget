package com.lechowiczfamily.homebudget.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transctions")
public class MoneyTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trans_id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "*Please provide name of transaction")
    private String name;

    @Column(name = "amount")
    @NotEmpty(message = "*Please provide the amount of the transaction")
    private int amount;

    @Column(name = "target_users")
    private String targetUsers;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "trans_buyer", joinColumns = @JoinColumn(name = "trans_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> buyer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTargetUsers() {
        return targetUsers;
    }

    public void setTargetUsers(String targetUsers) {
        this.targetUsers = targetUsers;
    }

    public List<User> getBuyer() {
        return buyer;
    }

    public void setBuyer(List<User> buyer) {
        this.buyer = buyer;
    }
}

