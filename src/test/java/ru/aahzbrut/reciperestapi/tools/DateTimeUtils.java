package ru.aahzbrut.reciperestapi.tools;

import java.time.format.DateTimeFormatter;

import static ru.aahzbrut.reciperestapi.utils.Constants.ISO_DATE_TIME_PATTERN;

public class DateTimeUtils {

    public static final DateTimeFormatter FORMATTER  = DateTimeFormatter.ofPattern(ISO_DATE_TIME_PATTERN);
}
