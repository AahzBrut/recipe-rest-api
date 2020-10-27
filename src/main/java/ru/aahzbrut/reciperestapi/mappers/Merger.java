package ru.aahzbrut.reciperestapi.mappers;

public interface Merger<T, S> {

    T merge(T source1, S source2);
}
