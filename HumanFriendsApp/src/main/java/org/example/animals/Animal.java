package org.example.animals;

import org.example.utils.AnimalType;
import org.example.utils.Gender;

import java.time.LocalDate;
import java.util.HashSet;

public interface Animal {
    public void setId(int id);
    public int getId();
    public String getName();
    public LocalDate getBirthDate();
    public AnimalType getPetType();
    public HashSet<String> getCommands();
    public Gender getGender();
}
