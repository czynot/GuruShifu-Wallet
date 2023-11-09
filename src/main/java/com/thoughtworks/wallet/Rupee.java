package com.thoughtworks.wallet;

public class Rupee{

    private final double value;

    public Rupee(double amount) throws Exception {
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
        if (!(o.getClass() == Rupee.class))
            return false;
        Rupee amount = (Rupee) o;
        return this.amount() == amount.amount();
    }

    @Override
    public int hashCode() {
        return (int)(Math.sqrt(this.value * Math.random()));
    }

    public Rupee add(Rupee sum1, Rupee sum2) throws Exception {
        return new Rupee(sum1.value+sum2.value);
    }
}
