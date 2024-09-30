package org.example.animals;

import org.example.utils.Gender;
import org.example.utils.AnimalType;

import java.time.LocalDate;
import java.util.HashSet;

public abstract class Pet implements Animal {
    private int id;
    private String name;
    private LocalDate birthDate;
    private HashSet<String> commands;
    private Gender gender;
    private AnimalType petType;

    protected Pet(String name, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    protected void setPetType(AnimalType petType) {
        this.petType = petType;
    }

    public AnimalType getPetType() {
        return petType;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public HashSet<String> getCommands() {
        return commands;
    }

    public Gender getGender() {
        return gender;
    }
}
