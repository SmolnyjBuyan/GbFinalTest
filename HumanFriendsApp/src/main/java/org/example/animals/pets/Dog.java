package org.example.animals.pets;

import org.example.utils.Gender;
import org.example.utils.AnimalType;

import java.time.LocalDate;

public class Dog extends Pet{
    private static final String TABLE_NAME = "dogs";

    public Dog(String name, LocalDate birthDate, Gender gender) {
        super(name, birthDate, gender);
        setType(AnimalType.DOG);
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}
