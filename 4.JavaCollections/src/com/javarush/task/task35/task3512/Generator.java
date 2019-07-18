package com.javarush.task.task35.task3512;

public class Generator<T> {
    Class<T> klas;
    public Generator(Class<T> klas) {
        this.klas = klas;
    }
    T newInstance() throws IllegalAccessException, InstantiationException {
        return (T) klas.newInstance();
    }
}
