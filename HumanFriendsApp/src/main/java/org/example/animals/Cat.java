package org.example.animals;

import org.example.utils.Gender;
import org.example.utils.PetType;

import java.time.LocalDate;

public class Cat extends Pet{

    public Cat(String name, LocalDate birthDate, Gender gender) {
        super(name, birthDate, gender);
        setPetType(PetType.CAT);
    }
}
