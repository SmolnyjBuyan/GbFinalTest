package org.example.animals.pack_animals;

import org.example.utils.AnimalType;
import org.example.utils.Gender;

import java.time.LocalDate;

public class Camel extends PackAnimal{
    private static final String TABLE_NAME = "camels";
    public Camel(String name, LocalDate birthDate, Gender gender) {
        super(name, birthDate, gender);
        setType(AnimalType.CAMEL);
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}
