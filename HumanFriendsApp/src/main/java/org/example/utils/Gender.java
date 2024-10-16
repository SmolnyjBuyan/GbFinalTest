package org.example.utils;

import org.example.view.ConsolePrinter;
import org.example.view.ConsolePrompt;

import java.util.LinkedHashMap;
import java.util.Map;

public enum Gender {
    MALE(1, "Male"), FEMALE(2,"Female");
    private final String title;
    private final int id;
    private static final Map<Integer, Gender> ID_FOR_GENDER = new LinkedHashMap<>();

    static {
        ID_FOR_GENDER.put(1, MALE);
        ID_FOR_GENDER.put(2, FEMALE);
    }
    Gender(int id, String title) {
        this.title = title;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Gender get(int id) {
        return ID_FOR_GENDER.get(id);
    }

    public static Map<Integer, Gender> getGenderIdentities(){
        return ID_FOR_GENDER;
    }

    public static Gender prompt(){
        return get(ConsolePrompt.getOption(ID_FOR_GENDER));
    }

    public static void print() {
        ConsolePrinter.render(ID_FOR_GENDER);
    }
    @Override
    public String toString() {
        return title;
    }
}
