package org.example.view;

import org.example.DataBaseManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);
    DataBaseManager dataBaseManager = new DataBaseManager();

    private static void printMenu() {
        System.out.println("1. Show animals");
        System.out.println("2. Add an animal");
        System.out.println("3. Teach an animal a new command");
        System.out.println("4. Exit\n");
    }
    public void execute() {
        printMenu();
        navigate(getOption());
    }

    private int getOption() {
        int option = 0;

        while (!(option >= 1 && option <= 4)) {
            try {
                System.out.print("Choose an option [1-4]: ");
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer value between 1 and 4");
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
            case 1 -> dataBaseManager.showAnimals();
            case 4 -> System.exit(0);
        }
    }


    private String prompt() {
        return scanner.nextLine();
    }
}
