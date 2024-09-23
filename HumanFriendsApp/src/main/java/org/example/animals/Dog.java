package org.example.animals;

import org.example.utils.Gender;

import java.time.LocalDate;

public class Dog extends Pet{
    public Dog(String name, LocalDate birthDate, Gender gender) {
        super(name, birthDate, gender);
    }
}
