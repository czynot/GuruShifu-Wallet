package com.thoughtworks.wallet;

public class Wallet {
    private Currency balance;

    public Wallet(double balance) throws Exception {
        Currency money = new Currency(balance, Currency.currencyType.INR);
        this.balance = money;
    }

    public Currency balance() {
        return this.balance;
    }

    public void put(Currency amount) throws Exception {
        this.balance = this.balance.add(amount);
    }
}
