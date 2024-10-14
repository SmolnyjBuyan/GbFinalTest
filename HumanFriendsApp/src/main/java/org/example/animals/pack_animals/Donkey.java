package org.example.animals.pack_animals;

import org.example.utils.AnimalType;
import org.example.utils.Gender;

import java.time.LocalDate;

public class Donkey extends PackAnimal{
    public Donkey(String name, LocalDate birthDate, Gender gender) {
        super(name, birthDate, gender);
        setAnimalType(AnimalType.DONKEY);
    }
}
