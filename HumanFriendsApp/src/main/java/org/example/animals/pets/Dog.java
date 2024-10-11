package org.example.animals.pets;

import org.example.utils.Gender;
import org.example.utils.AnimalType;

import java.time.LocalDate;

public class Dog extends Pet{
    public Dog(String name, LocalDate birthDate, Gender gender) {
        super(name, birthDate, gender);
        setAnimalType(AnimalType.DOG);
    }
}
