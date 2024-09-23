package org.example.utils;

public enum Gender {
    MALE("Male"), FEMALE("Female");
    private final String title;

    Gender(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
