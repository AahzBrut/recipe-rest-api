package ru.aahzbrut.reciperestapi.tools;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public interface MatcherHelpers {

    static List<Integer> getLocalDateTimeAsList(LocalDateTime localDateTime) {
        List<Integer> result = new LinkedList<>();
        result.add(localDateTime.getYear());
        result.add(localDateTime.getMonthValue());
        result.add(localDateTime.getDayOfMonth());
        result.add(localDateTime.getHour());
        result.add(localDateTime.getMinute());
        result.add(localDateTime.getSecond());
        result.add(localDateTime.getNano());

        return result;
    }

}
