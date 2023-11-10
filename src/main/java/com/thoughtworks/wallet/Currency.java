package com.thoughtworks.wallet;

public class Currency{

    public enum currencyType{
        INR, USD;
    }

    private final currencyType currency;
    private final double value;

    public Currency(double amount, currencyType currency) throws Exception {
        if (amount < 0)
            throw new Exception();
        this.value = amount;
        this.currency = currency;
    }

    public Currency add(Currency sum) throws Exception {
        switch (sum.currency){
            case INR:
                return new Currency(sum.value + this.value, currencyType.INR);
            case USD:
                return new Currency((sum.value * 80) + this.value, currencyType.INR);
            default:
                throw new Exception();
        }
    }


    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o == this)
            return true;
        if (!(o.getClass() == Currency.class))
            return false;
        Currency amount = (Currency) o;
        return this.value == amount.value;
    }

    @Override
    public int hashCode() {
        return (int)(Math.sqrt(this.value * Math.random()));
    }
}
