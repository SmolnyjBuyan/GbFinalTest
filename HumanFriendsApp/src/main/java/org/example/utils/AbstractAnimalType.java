package org.example.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public enum AbstractAnimalType {
    PET(1, "Pet", "pets"), PACK_ANIMAL(2, "Pack Animal", "pack_animals");
    private final String title;
    private final int id;
    private final String tableName;
    private static final Map<Integer, AbstractAnimalType> ID_FOR_ABSTRACT_ANIMAL_TYPE = new LinkedHashMap<>();

    static {
        ID_FOR_ABSTRACT_ANIMAL_TYPE.put(1, PET);
        ID_FOR_ABSTRACT_ANIMAL_TYPE.put(2, PACK_ANIMAL);
    }

    AbstractAnimalType(int id, String title, String tableName) {
        this.id = id;
        this.title = title;
        this.tableName = tableName;
    }

    public int getId() {
        return id;
    }
    public String getTableName() {
        return tableName;
    }

    public static AbstractAnimalType get(int id) {
        return ID_FOR_ABSTRACT_ANIMAL_TYPE.get(id);
    }

    public static Map<Integer, AbstractAnimalType> getAnimalTypes(){
        return ID_FOR_ABSTRACT_ANIMAL_TYPE;
    }

    @Override
    public String toString() {
        return title;
    }
}
