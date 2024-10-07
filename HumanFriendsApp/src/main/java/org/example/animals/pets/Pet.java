package org.example.animals.pets;

import org.example.animals.Animal;
import org.example.utils.Command;
import org.example.utils.Gender;
import org.example.utils.AnimalType;

import java.time.LocalDate;
import java.util.HashSet;

public abstract class Pet implements Animal {
    public static final String TABLE_NAME = "pets";
    private static final String COMMAND_TABLE_NAME = "pet_commands";
    private static final String COMMAND_TABLE_COLUMN_NAME = "pet_id";

    private int id;
    private String name;
    private LocalDate birthDate;
    private HashSet<Command> commands;
    private Gender gender;
    private AnimalType type;

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
    public AnimalType getType() {
        return type;
    }

    @Override
    public HashSet<Command> getCommands() {
        return commands;
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
