package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Double sum;

    @ManyToOne
    @JoinColumn(name = "account_cbu")
    private Account account;

    public Transaction() {

    }

    public Transaction(Double sum, Account account) {
        this.sum = sum;
        this.account = account;
    }

    public Long getId() {
        return this.id;
    }

    public Account getAccount() {
        return this.account;
    }

    public Double getSum() {
        return this.sum;
    }

    public String getType() {
        String type = "DEPOSIT";
        if (this.sum < 0) {
            type = "WITHDRAW";
        }
        return type;
    }

}
