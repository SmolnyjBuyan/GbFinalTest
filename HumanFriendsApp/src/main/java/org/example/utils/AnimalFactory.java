package org.example.utils;

import org.example.animals.Animal;
import org.example.animals.Cat;
import org.example.animals.Dog;
import org.example.animals.Hamster;

import java.time.LocalDate;
import java.util.Map;

public class AnimalFactory {

    private static final Map<AnimalType, Factory<String, LocalDate, Gender, Animal>> FACTORY_MAP = Map.of(
            AnimalType.CAT, Cat::new,
            AnimalType.DOG, Dog::new,
            AnimalType.HAMSTER, Hamster::new
    );

    public static Animal create(String name, LocalDate birthDate, Gender gender, AnimalType animalType) {
        return FACTORY_MAP.get(animalType).create(name, birthDate, gender);
    }

    @FunctionalInterface
    private interface Factory<T, R, U, S> {
        S create(T obj1, R obj2, U obj3);
    }
}
