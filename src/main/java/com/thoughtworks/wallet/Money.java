package com.thoughtworks.wallet;

public class Money {

    public enum Currency {
        INR {@Override public double exchangeRate() {return 1;}},
        USD {@Override public double exchangeRate() {return 80;}};
        public abstract double exchangeRate();
        protected double getMoneyInRupees(Money money) {
            return money.value * money.currency.exchangeRate();
        }
    }

    private final Currency currency;
    private final double value;

    public Money(double amount, Currency currency) throws Exception {
        if (amount < 0)
            throw new Exception();
        this.value = amount;
        this.currency = currency;
    }

    public Money add(Money sum) throws Exception {
        return new Money((currency.getMoneyInRupees(sum)) + this.value, Currency.INR);
    }

    public Money withdraw(Money sum) throws Exception {
        return new Money(sum.value, sum.currency);
    }

    public Money deduct(Money sum) throws Exception {
        return new Money(this.value - (currency.getMoneyInRupees(sum)), Currency.INR);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o == this)
            return true;
        if (!(o.getClass() == Money.class))
            return false;
        Money amount = (Money) o;
        return this.value == amount.value;
    }

    @Override
    public int hashCode() {
        return (int)(Math.sqrt(this.value * Math.random()));
    }
}
