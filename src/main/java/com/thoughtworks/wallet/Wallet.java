package com.thoughtworks.wallet;

public class Wallet {
    private Money balance;

    public Wallet(double balance) throws Exception {
        Money money = new Money(balance, Money.Currency.INR);
        this.balance = money;
    }

    public Money balance() {
        return this.balance;
    }

    public void put(Money amount) throws Exception {
        this.balance = this.balance.add(amount);
    }

    public Money withdraw(Money withdrawlAmount) throws Exception{
        this.balance = this.balance.deduct(withdrawlAmount);
        Money withdrawl = this.balance.withdraw(withdrawlAmount);
        return withdrawl;

    }
}
