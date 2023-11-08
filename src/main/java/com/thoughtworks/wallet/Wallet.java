package com.thoughtworks.wallet;

import com.thoughtworks.wallet.NegativeRupeeException;


public class Wallet {

    private double balance = 0;

    public Wallet(double balance) {       
        this.balance = balance;
    }

    public double balance() {
        return this.balance;
    }

    public void put(double amount) throws Exception {
        if (amount < 0)
            throw new Exception();

        this.balance += amount;
    }
}
