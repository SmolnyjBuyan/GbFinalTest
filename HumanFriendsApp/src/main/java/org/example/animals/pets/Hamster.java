package org.example.animals.pets;

import org.example.utils.Gender;
import org.example.utils.AnimalType;

import java.time.LocalDate;

public class Hamster extends Pet{
    public Hamster(String name, LocalDate birthDate, Gender gender) {
        super(name, birthDate, gender);
        setAnimalType(AnimalType.HAMSTER);
    }
}
