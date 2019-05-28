package com.javarush.task.task14.task1417;

public class Ruble extends Money {
    @Override
    public double getAmount() {
        return 0.0D;
    }

    @Override
    public String getCurrencyName() {
        return "RUB";
    }

    public Ruble (double a) {
        super(a);
    }
}
