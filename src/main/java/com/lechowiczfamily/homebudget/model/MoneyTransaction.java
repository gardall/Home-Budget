package com.lechowiczfamily.homebudget.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "transaction")
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "transaction_buyer", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "trans_id"))
    private List<User> buyer;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "transaction_target", joinColumns = @JoinColumn(name = "trans_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> targetUsers;

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

    public List<User> getTargetUsers() {
        return targetUsers;
    }

    public void setTargetUsers(List<User> targetUsers) {
        this.targetUsers = targetUsers;
    }
    
    public List<User> getBuyer() {
        return buyer;
    }

    public void setBuyer(List<User> buyer) {
        this.buyer = buyer;
    }
}

