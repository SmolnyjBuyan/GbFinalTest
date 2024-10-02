package org.example.animals;

import org.example.utils.Gender;
import org.example.utils.AnimalType;

import java.time.LocalDate;

public class Hamster extends Pet{

    public Hamster(String name, LocalDate birthDate, Gender gender) {
        super(name, birthDate, gender);
        setType(AnimalType.HAMSTER);
    }
}
