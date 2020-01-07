package ru.aahzbrut.reciperestapi.utils;

public interface ReflectionUtils {

    static String getCurrentMethodName() {

        return new Throwable()
                .getStackTrace()[1]
                .getMethodName();
    }
}
