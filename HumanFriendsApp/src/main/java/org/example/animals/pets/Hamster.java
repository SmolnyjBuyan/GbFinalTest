package org.example.animals.pets;

import org.example.utils.Gender;
import org.example.utils.AnimalType;

import java.time.LocalDate;

public class Hamster extends Pet{
    private static final String TABLE_NAME = "hamsters";

    public Hamster(String name, LocalDate birthDate, Gender gender) {
        super(name, birthDate, gender);
        setType(AnimalType.HAMSTER);
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}
