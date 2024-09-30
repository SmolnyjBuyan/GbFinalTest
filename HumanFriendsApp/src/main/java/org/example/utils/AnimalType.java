package org.example.utils;

public enum AnimalType {
    CAT(1), DOG(2), HAMSTER(3);

    private final int ID;

    AnimalType(int id) {
        this.ID = id;
    }

    public int getId() {
        return ID;
    }

}
