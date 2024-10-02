package org.example.view;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import org.example.DataBaseController;
import org.example.animals.Animal;
import org.example.utils.AnimalType;
import org.example.utils.Gender;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);
    DataBaseController dataBaseManager = new DataBaseController();

    private static final String[] MAIN_MENU = {
            "1. Show animals",
            "2. Add an animal",
            "3. Teach an animal a new command",
            "0. Exit"
    };

    private static final String[] ADD_ANIMAL_MENU = {
            "1. Cat",
            "2. Dog",
            "3. Hamster",
            "0. Exit"
    };


    private static void print(String[] options) {
        System.out.println();
        for (String option : options) {
            System.out.println(option);
        }
    }
    public void start() {
        print(MAIN_MENU);
        navigate(promptOption(MAIN_MENU.length));
    }

    public void pause() {
        System.out.println("\nContinue? [1-Yes, 0-No]");
        switch (promptOption(2)) {
            case 1 -> start();
            case 0 -> System.exit(0);
        }

    }

    private int promptOption(int optionsCount) {
        int option = -1;

        while (!(option >= 0 && option <= optionsCount - 1)) {
            try {
                System.out.print("\nChoose an option [0-" + (optionsCount - 1) + "]: ");
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer value between 0 and " + (optionsCount - 1));
                scanner.next();
            } catch (Exception e) {
                System.out.println("An unexpected error happened. Please try again");
                scanner.next();
            }
        }
        return option;
    }

    private void navigate(int option) {
        switch (option) {
            case 1 -> showAnimals();
            case 2 -> addAnimal();
            case 0 -> System.exit(0);
        }
    }

    private void showAnimals(){
        try {
            System.out.println("\n PETS");
            printAnimalTable(dataBaseManager.getPets());
        } catch (SQLException e) {
            System.out.println("Database error happened");
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error happened. Please try again");
        }
        pause();
    }
    private void printAnimalTable(List<Animal> animals) {
        AsciiTable asciiTable = new AsciiTable();
        asciiTable.addRule();
        asciiTable.addRow("Id", "Name", "Birthdate", "Gender", "Type");
        asciiTable.addRule();
        for (Animal animal : animals) {
            asciiTable.addRow(animal.getId(), animal.getName(),
                    animal.getBirthDate(), animal.getGender(), animal.getType());
            asciiTable.addRule();
        }
        asciiTable.setTextAlignment(TextAlignment.CENTER);
        System.out.println(asciiTable.render());
    }

    private void addAnimal() {
        print(ADD_ANIMAL_MENU);
        AnimalType type = AnimalType.get(promptOption(ADD_ANIMAL_MENU.length));
        String name = promptName();
        System.out.println(name);
        LocalDate birthDate;
        Gender gender;
//        dataBaseManager.insert(AnimalFactory.create());
    }

    private String promptName() {
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        return name;
    }
}
