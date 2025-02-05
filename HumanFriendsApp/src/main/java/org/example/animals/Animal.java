package org.example.animals;

import org.example.utils.AbstractAnimalType;
import org.example.utils.AnimalType;
import org.example.utils.Command;
import org.example.utils.Gender;

import java.time.LocalDate;
import java.util.HashSet;

public interface Animal {
    int getId();
    String getName();
    LocalDate getBirthDate();
    AnimalType getAnimalType();
    AbstractAnimalType getAbstractAnimalType();
    HashSet<Command> getCommands();
    Gender getGender();
    void setAnimalType(AnimalType animalType);
    void setId(int id);
    void setCommands(HashSet<Command> commands);

    String getCommandTableName();
    String getCommandTableColumnName();
    String getTableName();
    String getParentTableName();
}
