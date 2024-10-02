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
    private AnimalType type;

    protected Pet(String name, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    @Override
    public HashSet<String> getCommands() {
        return commands;
    }
}
