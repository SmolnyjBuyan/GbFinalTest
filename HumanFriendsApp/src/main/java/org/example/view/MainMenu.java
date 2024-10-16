package org.example.view;

import org.example.db.DataBaseController;
import org.example.utils.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public final class MainMenu {

    public static final Map<Integer, Option> OPTION_MAP = new LinkedHashMap<>();
    static {
        OPTION_MAP.put(1, new Option("Show animals", AnimalsMenu::render));
        OPTION_MAP.put(2, new Option("Add an animal", MainMenu::addAnimal));
        OPTION_MAP.put(0, new Option("Exit", () -> {}));
    }

    public static void addAnimal() {
        AnimalType.print();
        AnimalType type = AnimalType.prompt();
        Gender.print();
        Gender gender = Gender.prompt();
        String name = ConsolePrompt.getName();
        LocalDate birthDate  = ConsolePrompt.getDate();

        try (Counter counter = new Counter()) {
            DataBaseController.insert(AnimalFactory.create(name, birthDate, gender, type));
            counter.add();
        } catch (SQLException e) {
            System.err.println(e.getClass());
            System.err.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void render() {
        int option;

        do {
            ConsolePrinter.render(OPTION_MAP);
            option = ConsolePrompt.getOption(OPTION_MAP);
            OPTION_MAP.get(option).execute();
        } while (option != 0);

        stop();
    }

    public static void stop() {
        System.exit(0);
    }
}
