package org.example.view;

import org.example.db.DataBaseController;
import org.example.utils.AbstractAnimalType;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class AnimalsMenu {
    private static final Map<Integer, Option> OPTION_MAP = new LinkedHashMap<>();
    static {
        OPTION_MAP.put(1, new Option("Select an animal", AnimalsMenu::selectAnimal));
        OPTION_MAP.put(0, new Option("Back", () -> {}));
    }

    private static void selectAnimal() {
        AbstractAnimalType.print();
        AbstractAnimalType type = AbstractAnimalType.prompt();

        try {
            int id = ConsolePrompt.getId();
            AnimalMenu.animal = DataBaseController.getAnimal(id, type);
            AnimalMenu.render();
        } catch (SQLException e) {
            System.err.println(e.getClass());
            System.err.println(e.getMessage());
        }
    }

    public static void showAnimals() throws SQLException {
        System.out.println("\n PETS");
        ConsolePrinter.render(DataBaseController.getPets());
        System.out.println("\n PACK_ANIMALS");
        ConsolePrinter.render(DataBaseController.getPackAnimals());
    }

    public static void render(){
        int option = 0;

         do {
            try {
                showAnimals();
                ConsolePrompt.pause();
                ConsolePrinter.render(OPTION_MAP);
                option = ConsolePrompt.getOption(OPTION_MAP);
                OPTION_MAP.get(option).execute();
            } catch (SQLException e) {
                System.err.println(e.getClass());
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println("An unexpected error happened. Please try again");
                System.err.println(e.getClass() + e.getMessage());
            }
        } while (option != 0);
    }
}
