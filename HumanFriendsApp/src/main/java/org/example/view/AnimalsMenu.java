package org.example.view;

import org.example.DataBaseController;
import org.example.animals.Animal;
import org.example.utils.AbstractAnimalType;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class AnimalsMenu implements Optionable{
    private static final Map<Integer, Option> OPTION_MAP = new LinkedHashMap<>();
    static {
        OPTION_MAP.put(1, new Option("Select an animal", AnimalMenu::render));
        OPTION_MAP.put(0, new Option("Back", MainMenu::render));
    }

    public static void showAnimals(){
        try {
            System.out.println("\n PETS");
            Optionable.print(DataBaseController.getPets());
            System.out.println("\n PACK_ANIMALS");
            Optionable.print(DataBaseController.getPackAnimals());
        } catch (SQLException e) {
            System.err.println("Database error happened");
            System.err.println(e.getClass());
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error happened. Please try again");
            System.err.println(e.getClass() + e.getMessage());
        }
    }

    public static void render(){
        showAnimals();
        Prompt.pause();
        Optionable.print(OPTION_MAP);
        OPTION_MAP.get(Prompt.getOption(OPTION_MAP)).execute();
    }
}
