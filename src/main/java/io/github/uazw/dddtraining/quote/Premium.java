package io.github.uazw.dddtraining.quote;


import static java.lang.String.valueOf;

public class Premium {
    private double amount;

    public Premium(double amount) {
        this.amount = amount;
    }

    public Premium multiple(double rate) {
        return new Premium(amount * rate);
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return valueOf(amount);
    }
}

