package com.thoughtworks.wallet;

public class Dollar{

    private final double value;

    public Dollar(double amount) throws Exception {
        if (amount < 0)
            throw new Exception();
        this.value = amount;
    }

    public double amount() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o == this)
            return true;
        if (!(o.getClass() == Dollar.class))
            return false;
        Dollar amount = (Dollar) o;
        return this.amount() == amount.amount();
    }

    @Override
    public int hashCode() {
        return (int)(Math.sqrt(this.value * Math.random()));
    }

    public Dollar add(Dollar sum1, Dollar sum2) throws Exception {
        return new Dollar(sum1.value+sum2.value);
    }
}

