package org.example.utils;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Locale;

public class DateValidator {
    private final DateTimeFormatter dateTimeFormatter;

    public DateValidator() {
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd", Locale.US).
                withResolverStyle(ResolverStyle.STRICT);
    }

    public boolean isValid(String date) {
        try {
            this.dateTimeFormatter.parse(date);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}
