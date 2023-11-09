package com.thoughtworks.wallet;

public class Wallet {

    private Rupee balance;

    public Wallet(double balance) throws Exception {  
        Rupee rupee = new Rupee(balance);     
        this.balance = rupee;
    }

    public Rupee balance() {
        return this.balance;
    }

    public void put(Rupee amount) throws Exception {
        Rupee newAmount = new Rupee(0);
        this.balance = newAmount.add(this.balance, amount);
    }
}
