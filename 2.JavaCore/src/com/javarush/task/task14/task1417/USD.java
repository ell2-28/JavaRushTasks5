package com.javarush.task.task14.task1417;

public class USD extends Money {
    @Override
    public double getAmount() {
        return 11.4;
    }

    @Override
    public String getCurrencyName() {
        return "USD";
    }

    public USD (double a) {
        super(a);
    }

}
