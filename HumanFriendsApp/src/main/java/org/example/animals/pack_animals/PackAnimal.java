package org.example.animals.pack_animals;

import org.example.animals.Animal;
import org.example.utils.AbstractAnimalType;
import org.example.utils.AnimalType;
import org.example.utils.Command;
import org.example.utils.Gender;

import java.time.LocalDate;
import java.util.HashSet;

public abstract class PackAnimal implements Animal {
    private int id;
    private final String name;
    private final LocalDate birthDate;
    private HashSet<Command> commands;
    private final Gender gender;
    private AnimalType animalType;

    protected PackAnimal(String name, LocalDate birthDate, Gender gender) {
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
    public AnimalType getAnimalType() {
        return animalType;
    }

    @Override
    public AbstractAnimalType getAbstractAnimalType() {
        return AbstractAnimalType.PACK_ANIMAL;
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
        return AbstractAnimalType.PACK_ANIMAL.getCommandTableName();
    }

    @Override
    public String getCommandTableColumnName() {
        return AbstractAnimalType.PACK_ANIMAL.getCommandTableColumnName();
    }

    @Override
    public String getParentTableName() {
        return AbstractAnimalType.PACK_ANIMAL.getTableName();
    }

    @Override
    public String getTableName() {
        return animalType.getTableName();
    }
}
