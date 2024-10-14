package org.example.view;

import org.example.db.DataBaseController;
import org.example.animals.Animal;
import org.example.utils.AbstractAnimalType;
import org.example.utils.Command;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnimalMenu implements Optionable{
    static Animal animal;
    public static final Map<Integer, Option> OPTION_MAP = new LinkedHashMap<>();
    static {
        OPTION_MAP.put(1, new Option("Teach an animal a new command", AnimalMenu::teachAnimal));
        OPTION_MAP.put(0, new Option("Back", AnimalsMenu::render));
    }

    private static void selectAnimal() {
        Optionable.print(AbstractAnimalType.getAnimalTypes());
        AbstractAnimalType type = AbstractAnimalType.get(Prompt.getOption(AbstractAnimalType.getAnimalTypes()));

        while (true) {
            try {
                int id = Prompt.getId();
                animal = DataBaseController.getAnimal(id, type);
                return;
            } catch (SQLException e) {
                System.err.println("There is no animal with such id");
            }
        }
    }

    private static void update() {
        try {
            animal = DataBaseController.getAnimal(animal.getId(), animal.getAbstractAnimalType());
            printMenu();
        } catch (SQLException e) {
            System.err.println("Update error");
            System.err.println(e.getClass());
            System.err.println(e.getMessage());
        }
    }

    private static void teachAnimal() {
        Optionable.print(Command.getCommands());
        Command command = Command.get(Prompt.getOption(Command.getCommands()));
        System.out.println();
        try {
            DataBaseController.addCommandToAnimal(command, animal);
        } catch (SQLException e) {
            System.err.println("Insert into commands failed");
            System.err.println(e.getClass());
            System.err.println(e.getMessage());
        }
        update();
    }

    private static void printMenu(){
        Optionable.print(List.of(animal));
        Optionable.print(OPTION_MAP);
        OPTION_MAP.get(Prompt.getOption(OPTION_MAP)).execute();
    }

    public static void render() {
        selectAnimal();
        printMenu();
    }
}
