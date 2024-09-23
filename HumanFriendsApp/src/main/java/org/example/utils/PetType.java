package org.example.utils;

public enum PetType {
    CAT(1), DOG(2), HAMSTER(3);

    private int id;

    PetType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
