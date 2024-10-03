package org.example.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public enum AnimalType {
    CAT(1, "Cat"), DOG(2, "Dog"), HAMSTER(3, "Hamster");

    private final int ID;
    private final String TITLE;
    public static final Map<Integer, AnimalType> ID_FOR_ANIMAL_TYPE = new LinkedHashMap<>();

    static {
        ID_FOR_ANIMAL_TYPE.put(1, CAT);
        ID_FOR_ANIMAL_TYPE.put(2, DOG);
        ID_FOR_ANIMAL_TYPE.put(3, HAMSTER);
    }

    AnimalType(int id, String title) {
        this.ID = id;
        this.TITLE = title;
    }

    public int getId() {
        return ID;
    }

    public static AnimalType get(int id) {
        return ID_FOR_ANIMAL_TYPE.get(id);
    }

    @Override
    public String toString() {
        return TITLE;
    }
}
