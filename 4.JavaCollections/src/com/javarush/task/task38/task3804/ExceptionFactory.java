package com.javarush.task.task38.task3804;

public class ExceptionFactory {

    public static Throwable getException(Enum enumeration) {

        if (enumeration != null) {
            if (enumeration instanceof ApplicationExceptionMessage) {
                return new Exception(enumeration.name().charAt(0) + enumeration.name().substring(1).toLowerCase().replace("_", " "));
            } else if (enumeration instanceof DatabaseExceptionMessage) {
                return new RuntimeException(enumeration.name().charAt(0) + enumeration.name().substring(1).toLowerCase().replace("_", " "));
            } else if (enumeration instanceof UserExceptionMessage) {
                return new Error(enumeration.name().charAt(0) + enumeration.name().substring(1).toLowerCase().replace("_", " "));
            }
        }
        return new IllegalArgumentException();
    }
}