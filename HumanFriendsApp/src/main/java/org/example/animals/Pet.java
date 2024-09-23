package org.example.animals;

import org.example.utils.Gender;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;

public abstract class Pet implements Animal {
    private int id;
    private String name;
    private LocalDate birthDate;
    private HashSet<String> commands;
    private Gender gender;

    public Pet(String name, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
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
