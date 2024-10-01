package org.example.utils;

import java.util.Map;

public enum AnimalType {
    CAT(1), DOG(2), HAMSTER(3);

    private final int ID;
    static final Map<Integer, AnimalType> ID_FOR_ANIMAL_TYPE = Map.of(
            1, CAT,
            2, DOG,
            3, HAMSTER
    );

    AnimalType(int id) {
        this.ID = id;
    }

    public int getId() {
        return ID;
    }

    public static AnimalType get(int id) {
        return ID_FOR_ANIMAL_TYPE.get(id);
    }
}
