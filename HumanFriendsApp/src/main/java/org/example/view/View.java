package org.example.view;

import org.example.DataBaseManager;
import org.example.animals.Animal;

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
    public void executeMenu() {
        printMenu();

        int option = 0;
        while (option!=4) {
            try {
                System.out.print("Choose an option: ");
                option = scanner.nextInt();
                if (option == 1) dataBaseManager.showAnimals();
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer value between 1 and 4");
                scanner.next();
            } catch (Exception e) {
                System.out.println("An unexpected error happened. Please try again");
                scanner.next();
            }
        }
    }

    private String prompt() {
        return scanner.nextLine();
    }
}
