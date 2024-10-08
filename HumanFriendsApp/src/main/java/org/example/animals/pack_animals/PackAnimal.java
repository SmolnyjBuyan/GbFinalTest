package org.example.animals.pack_animals;

import org.example.animals.Animal;
import org.example.utils.AnimalType;
import org.example.utils.Command;
import org.example.utils.Gender;

import java.time.LocalDate;
import java.util.HashSet;

public abstract class PackAnimal implements Animal {
    public static final String TABLE_NAME = "pack_animals";
    private static final String COMMAND_TABLE_NAME = "pack_animal_commands";
    private static final String COMMAND_TABLE_COLUMN_NAME = "pack_animal_id";

    private int id;
    private final String name;
    private final LocalDate birthDate;
    private HashSet<Command> commands;
    private final Gender gender;
    private AnimalType type;

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
    public AnimalType getType() {
        return type;
    }

    @Override
    public HashSet<Command> getCommands() {
        return commands;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }


    @Override
    public void setCommands(HashSet<Command> commands) {
        this.commands = commands;
    }

    @Override
    public String getCommandTableName() {
        return COMMAND_TABLE_NAME;
    }

    @Override
    public String getCommandTableColumnName() {
        return COMMAND_TABLE_COLUMN_NAME;
    }

    public String getParentTableName() {
        return TABLE_NAME;
    }
}
