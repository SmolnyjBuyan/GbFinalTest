package org.example.view;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import org.example.DataBaseManager;
import org.example.animals.Animal;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);
    DataBaseManager dataBaseManager = new DataBaseManager();

    private static final String[] MAIN_MENU = {
            "1. Show animals",
            "2. Add an animal",
            "3. Teach an animal a new command",
            "0. Exit"
    };

    private static void print(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
    }
    public void start() {
        print(MAIN_MENU);
        navigate(getOption(MAIN_MENU.length));
    }

    public void pause() {
        System.out.println("\nContinue? [1-Yes, 0-No]");
        switch (getOption(2)) {
            case 1 -> start();
            case 0 -> System.exit(0);
        }

    }

    private int getOption(int optionsCount) {
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
                    animal.getBirthDate(), animal.getGender(), animal.getPetType());
            asciiTable.addRule();
        }
        asciiTable.setTextAlignment(TextAlignment.CENTER);
        System.out.println(asciiTable.render());
    }

    private String prompt() {
        return scanner.nextLine();
    }
}
