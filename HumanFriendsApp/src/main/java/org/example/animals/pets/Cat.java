package org.example.animals.pets;

import org.example.utils.Gender;
import org.example.utils.AnimalType;

import java.time.LocalDate;

public class Cat extends Pet{
    private static final String TABLE_NAME = "cats";

    public Cat(String name, LocalDate birthDate, Gender gender) {
        super(name, birthDate, gender);
        setType(AnimalType.CAT);
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}
