package org.example.view;

import org.example.utils.DateValidator;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;



public final class Prompt {
    static Scanner scanner = new Scanner(System.in);

    public static int getId() {
        while (true) {
            try {
                System.out.print("\nEnter animals id: ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Please enter an integer value");
                scanner.nextLine();
            } catch (Exception e) {
                System.err.println("An unexpected error happened. Please try again");
                System.err.println(e.getClass() + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    public static String getName() {
        System.out.print("Enter a name: ");
        String name = scanner.next();
        scanner.nextLine();
        return name;
    }

    public static LocalDate getDate() {
        String date;

        do {
            System.out.print("Enter a date of birth in the format [1993-10-30]: ");
            date = scanner.next();
        } while (!(DateValidator.isValid(date)));

        scanner.nextLine();
        return LocalDate.parse(date);
    }

    public static <V> int getOption(Map<Integer, V> map){
        int option = -1;

        do {
            try {
                System.out.print("\nChoose an option " + map.keySet() + ": ");
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Please enter an integer value " + map.keySet());
                scanner.nextLine();
            } catch (Exception e) {
                System.err.println("An unexpected error happened. Please try again");
                System.err.println(e.getClass() + e.getMessage());
                scanner.nextLine();
            }
        } while (!map.containsKey(option));

        scanner.nextLine();
        return option;
    }

    public static void pause() {
        System.out.print("Press \"ENTER\" to continue...");
        scanner.nextLine();
    }
}
