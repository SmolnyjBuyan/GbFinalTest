package org.example.view;

import org.example.DataBaseController;
import org.example.utils.AnimalFactory;
import org.example.utils.AnimalType;
import org.example.utils.Gender;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public final class MainMenu implements Optionable{

    public static final Map<Integer, Option> OPTION_MAP = new LinkedHashMap<>();
    static {
        OPTION_MAP.put(1, new Option("Show animals", AnimalsMenu::render));
        OPTION_MAP.put(2, new Option("Add an animal", MainMenu::addAnimal));
        OPTION_MAP.put(0, new Option("Exit", MainMenu::stop));
    }

    public static void addAnimal() {
        Optionable.print(AnimalType.getAnimalTypes());
        AnimalType type = AnimalType.get(Prompt.getOption(AnimalType.getAnimalTypes()));
        Optionable.print(Gender.getGenderIdentities());
        Gender gender = Gender.get(Prompt.getOption(Gender.getGenderIdentities()));
        String name = Prompt.getName();
        LocalDate birthDate  = Prompt.getDate();

        try {
            DataBaseController.insert(AnimalFactory.create(name, birthDate, gender, type));
        } catch (SQLException e) {
            System.err.println(e.getClass());
            System.err.println(e.getMessage());
        }

        render();
    }

    public static void render() {
        Optionable.print(OPTION_MAP);
        OPTION_MAP.get(Prompt.getOption(OPTION_MAP)).execute();
    }

    public static void stop() {
        System.exit(0);
    }
}
