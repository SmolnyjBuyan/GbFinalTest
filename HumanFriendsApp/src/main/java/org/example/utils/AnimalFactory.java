package org.example.utils;

import org.example.animals.Animal;
import org.example.animals.pack_animals.Camel;
import org.example.animals.pack_animals.Donkey;
import org.example.animals.pack_animals.Horse;
import org.example.animals.pets.Cat;
import org.example.animals.pets.Dog;
import org.example.animals.pets.Hamster;

import java.time.LocalDate;
import java.util.Map;

public class AnimalFactory {

    private static final Map<AnimalType, Factory<String, LocalDate, Gender, Animal>> FACTORY_MAP = Map.of(
            AnimalType.CAT, Cat::new,
            AnimalType.DOG, Dog::new,
            AnimalType.HAMSTER, Hamster::new,
            AnimalType.CAMEL, Camel::new,
            AnimalType.HORSE, Horse::new,
            AnimalType.DONKEY, Donkey::new
    );

    public static Animal create(String name, LocalDate birthDate, Gender gender, AnimalType animalType) {
        return FACTORY_MAP.get(animalType).create(name, birthDate, gender);
    }

    @FunctionalInterface
    private interface Factory<T, R, U, S> {
        S create(T obj1, R obj2, U obj3);
    }
}
