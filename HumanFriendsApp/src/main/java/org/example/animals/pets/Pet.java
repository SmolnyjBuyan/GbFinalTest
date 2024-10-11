package org.example.animals.pets;

import org.example.animals.Animal;
import org.example.utils.AbstractAnimalType;
import org.example.utils.Command;
import org.example.utils.Gender;
import org.example.utils.AnimalType;

import java.time.LocalDate;
import java.util.HashSet;

public abstract class Pet implements Animal {
    private int id;
    private final String name;
    private final LocalDate birthDate;
    private HashSet<Command> commands;
    private final Gender gender;
    private AnimalType animalType;

    protected Pet(String name, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
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
    public AbstractAnimalType getAbstractAnimalType() {
        return AbstractAnimalType.PET;
    }

    @Override
    public AnimalType getAnimalType() {
        return animalType;
    }

    @Override
    public HashSet<Command> getCommands() {
        return commands;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    @Override
    public void setCommands(HashSet<Command> commands) {
        this.commands = commands;
    }

    @Override
    public String getCommandTableName() {
        return AbstractAnimalType.PET.getCommandTableName();
    }

    @Override
    public String getCommandTableColumnName() {
        return AbstractAnimalType.PET.getCommandTableColumnName();
    }

    @Override
    public String getParentTableName() {
        return AbstractAnimalType.PET.getTableName();
    }

    public String getTableName() {
        return animalType.getTableName();
    }
}
