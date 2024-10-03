package org.example.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public enum Gender {
    MALE("Male"), FEMALE("Female");
    private final String TITLE;
    public static final Map<String, Gender> TITLE_FOR_GENDER = new LinkedHashMap<>();

    static {
        TITLE_FOR_GENDER.put("Male", MALE);
        TITLE_FOR_GENDER.put("Female", FEMALE);
    }
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
