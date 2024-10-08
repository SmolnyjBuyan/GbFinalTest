package org.example.animals.pack_animals;

import org.example.utils.AnimalType;
import org.example.utils.Gender;

import java.time.LocalDate;

public class Donkey extends PackAnimal{
    private static final String TABLE_NAME = "donkeys";

    public Donkey(String name, LocalDate birthDate, Gender gender) {
        super(name, birthDate, gender);
        setType(AnimalType.DONKEY);
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}
