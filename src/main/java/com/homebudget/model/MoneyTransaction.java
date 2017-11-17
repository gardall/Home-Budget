package com.homebudget.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "*Please provide the amount of the transaction")
    private int amount;

    @ManyToOne(optional = false)
    private User buyer;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "transaction_targetUsers",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "trans_id")
    )
    private List<User> targetUsres;

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

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public List<User> getTargetUsres() {
        return targetUsres;
    }

    public void setTargetUsres(List<User> targetUsres) {
        this.targetUsres = targetUsres;
    }
}

