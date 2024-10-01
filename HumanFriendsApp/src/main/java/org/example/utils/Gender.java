package org.example.utils;

import java.util.Map;

public enum Gender {
    MALE("Male"), FEMALE("Female");
    private final String TITLE;
    static final Map<String, Gender> TITLE_FOR_GENDER = Map.of(
            "Male", MALE,
            "Female", FEMALE
    );

    Gender(String title) {
        this.TITLE = title;
    }

    public String getTitle() {
        return TITLE;
    }

    public static Gender get(String title) {
        return TITLE_FOR_GENDER.get(title);
    }
}
