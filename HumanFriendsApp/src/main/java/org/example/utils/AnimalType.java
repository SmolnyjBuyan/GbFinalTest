package org.example.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public enum AnimalType {
    CAT(1, "Cat"), DOG(2, "Dog"), HAMSTER(3, "Hamster"),
    CAMEL(4, "Camel"), HORSE(5, "Horse"), DONKEY(6, "Donkey");

    private final String title;
    private final int id;
    private static final Map<Integer, AnimalType> ID_FOR_ANIMAL_TYPE = new LinkedHashMap<>();

    static {
        ID_FOR_ANIMAL_TYPE.put(1, CAT);
        ID_FOR_ANIMAL_TYPE.put(2, DOG);
        ID_FOR_ANIMAL_TYPE.put(3, HAMSTER);
        ID_FOR_ANIMAL_TYPE.put(4, CAMEL);
        ID_FOR_ANIMAL_TYPE.put(5, HORSE);
        ID_FOR_ANIMAL_TYPE.put(6, DONKEY);
    }

    AnimalType(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public static AnimalType get(int id) {
        return ID_FOR_ANIMAL_TYPE.get(id);
    }

    public static Map<Integer, AnimalType> getAnimalTypes(){
        return ID_FOR_ANIMAL_TYPE;
    }

    @Override
    public String toString() {
        return title;
    }
}
