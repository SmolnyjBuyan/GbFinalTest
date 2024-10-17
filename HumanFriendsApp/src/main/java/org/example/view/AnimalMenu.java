package org.example.view;

import org.example.db.DataBaseController;
import org.example.animals.Animal;
import org.example.utils.Command;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class AnimalMenu {
    static Animal animal;
    public static final Map<Integer, Option> OPTION_MAP = new LinkedHashMap<>();
    static {
        OPTION_MAP.put(1, new Option("Teach an animal a new command", AnimalMenu::teachAnimal));
        OPTION_MAP.put(0, new Option("Back", () -> {}));
    }

    private static void teachAnimal() {
        Command.print();
        Command command = Command.prompt();

        try {
            DataBaseController.addCommandToAnimal(command, animal);
        } catch (SQLException e) {
            System.err.println(e.getClass());
            System.err.println(e.getMessage());
        }

        update();
    }

    private static void update() {
        try {
            animal = DataBaseController.getAnimal(animal.getId(), animal.getAbstractAnimalType());
        } catch (SQLException e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }

    public static void render() {
        int option;

        do {
            ConsolePrinter.render(animal);
            ConsolePrinter.render(OPTION_MAP);
            option = ConsolePrompt.getOption(OPTION_MAP);
            OPTION_MAP.get(option).execute();

        } while (option != 0);
    }
}
