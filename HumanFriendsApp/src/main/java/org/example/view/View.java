package org.example.view;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import org.example.DataBaseController;
import org.example.animals.Animal;
import org.example.utils.AnimalFactory;
import org.example.utils.AnimalType;
import org.example.utils.DateValidator;
import org.example.utils.Gender;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class View {
    Scanner scanner = new Scanner(System.in);
    DataBaseController dataBaseController = new DataBaseController();
    DateValidator dateValidator = new DateValidator();
    public static final Map<Integer, String> MAIN_MENU = new LinkedHashMap<>();
    static {
        MAIN_MENU.put(1, "Show animals");
        MAIN_MENU.put(2, "Add an animal");
        MAIN_MENU.put(3, "Teach an animal a new command");
        MAIN_MENU.put(0, "Exit");
    }

    public void start() {
        print(MAIN_MENU);
        navigate(promptOption(MAIN_MENU));
    }

    private <K, V> void print(Map<K, V> map) {
        System.out.println();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
    }

    private void navigate(int option) {
        switch (option) {
            case 1 -> showAnimals();
            case 2 -> addAnimal();
            case 0 -> System.exit(0);
        }
    }

    public void pause() {
        System.out.print("Press \"ENTER\" to continue...");
        scanner.nextLine();
        start();
    }

    private void showAnimals(){
        try {
            System.out.println("\n PETS");
            printAnimalTable(dataBaseController.getPets());
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
        print(AnimalType.ID_FOR_ANIMAL_TYPE);
        AnimalType type = AnimalType.get(promptOption(AnimalType.ID_FOR_ANIMAL_TYPE));
        print(Gender.ID_FOR_GENDER);
        Gender gender = Gender.get(promptOption(Gender.ID_FOR_GENDER));
        String name = promptName();
        LocalDate birthDate  = promptDate();

        try {
            dataBaseController.insert(AnimalFactory.create(name, birthDate, gender, type));
        } catch (SQLException e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }

    private String promptName() {
        System.out.print("Enter a name: ");
        return scanner.next();
    }

    private LocalDate promptDate() {
        String date;
        do {
            System.out.print("Enter a date of birth in the format [1993-10-30]: ");
            date = scanner.next();
        } while (!(dateValidator.isValid(date)));
        return LocalDate.parse(date);
    }

    private <V> int promptOption(Map<Integer, V> map){
        int option = -1;

        do {
            try {
                System.out.print("\nChoose an option " + map.keySet() + ": ");
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer value " + map.keySet());
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("An unexpected error happened. Please try again");
                scanner.nextLine();
            }
        } while (!map.containsKey(option));

        scanner.nextLine();
        return option;
    }



}
