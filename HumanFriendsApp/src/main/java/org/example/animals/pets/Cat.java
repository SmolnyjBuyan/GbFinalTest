package org.example.animals.pets;

import org.example.utils.Gender;
import org.example.utils.AnimalType;

import java.time.LocalDate;

public class Cat extends Pet{

    public Cat(String name, LocalDate birthDate, Gender gender) {
        super(name, birthDate, gender);
        setType(AnimalType.CAT);
    }
}
