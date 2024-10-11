package org.example.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public enum AnimalType {
    CAT(1, "Cat", "cats"), DOG(2, "Dog", "dogs"),
    HAMSTER(3, "Hamster", "hamsters"), CAMEL(4, "Camel", "camels"),
    HORSE(5, "Horse", "horses"), DONKEY(6, "Donkey", "donkeys");

    private final int id;
    private final String title;
    private final String tableName;
    private static final Map<Integer, AnimalType> ID_FOR_ANIMAL_TYPE = new LinkedHashMap<>();

    static {
        ID_FOR_ANIMAL_TYPE.put(1, CAT);
        ID_FOR_ANIMAL_TYPE.put(2, DOG);
        ID_FOR_ANIMAL_TYPE.put(3, HAMSTER);
        ID_FOR_ANIMAL_TYPE.put(4, CAMEL);
        ID_FOR_ANIMAL_TYPE.put(5, HORSE);
        ID_FOR_ANIMAL_TYPE.put(6, DONKEY);
    }

    AnimalType(int id, String title, String tableName) {
        this.id = id;
        this.title = title;
        this.tableName = tableName;
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

    public String getTableName() {
        return tableName;
    }

    @Override
    public String toString() {
        return title;
    }
}
