package org.example.view;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
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
    static DataBaseController dataBaseController = new DataBaseController();
    static DateValidator dateValidator = new DateValidator();
    static Scanner scanner = new Scanner(System.in);

    public static final Map<Integer, Option> ANIMALS_MENU = new LinkedHashMap<>();
    static {
        ANIMALS_MENU.put(1, new Option("Teach an animal a new command", View::pause));
        ANIMALS_MENU.put(0, new Option("Back", View::start));
    }

    public static final Map<Integer, Option> MAIN_MENU = new LinkedHashMap<>();
    static {
        MAIN_MENU.put(1, new Option("Show animals", View::showAnimals));
        MAIN_MENU.put(2, new Option("Add an animal", View::addAnimal));
        MAIN_MENU.put(0, new Option("Exit", View::stop));
    }

    public static void start() {
        print(MAIN_MENU);
        MAIN_MENU.get(promptOption(MAIN_MENU)).execute();
    }

    public static void pause() {
        System.out.print("Press \"ENTER\" to continue...");
        scanner.nextLine();
    }

    public static void stop() {
        System.exit(0);
    }

    private static <V> void print(Map<Integer, V> map) {
        System.out.println();
        for (Map.Entry<Integer, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
    }

    public static void showAnimals(){
        try {
            System.out.println("\n PETS");
            print(dataBaseController.getPets());
            System.out.println("\n PACK_ANIMALS");
            print(dataBaseController.getPackAnimals());
        } catch (SQLException e) {
            System.out.println("Database error happened");
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println("An unexpected error happened. Please try again");
            System.out.println(e.getClass() + e.getMessage());
        }
        pause();
        print(ANIMALS_MENU);
        ANIMALS_MENU.get(promptOption(ANIMALS_MENU)).execute();
    }

    private static <T extends Animal> void print(List<T> animals) {
        AsciiTable asciiTable = new AsciiTable();
        asciiTable.addRule();
        asciiTable.addRow("Id", "Name", "Birthdate", "Gender", "Type", "Commands");
        asciiTable.addRule();

        for (Animal animal : animals) {
            asciiTable.addRow(animal.getId(), animal.getName(), animal.getBirthDate(),
                    animal.getGender(), animal.getType(), animal.getCommands());
            asciiTable.addRule();
        }

        asciiTable.getRenderer().setCWC(new CWC_LongestLine());
        asciiTable.setPaddingLeftRight(1);
        System.out.println(asciiTable.render());
    }

    public static void addAnimal() {
        print(AnimalType.getAnimalTypes());
        AnimalType type = AnimalType.get(promptOption(AnimalType.getAnimalTypes()));
        print(Gender.getGenderIdentities());
        Gender gender = Gender.get(promptOption(Gender.getGenderIdentities()));
        String name = promptName();
        LocalDate birthDate  = promptDate();

        try {
            dataBaseController.insert(AnimalFactory.create(name, birthDate, gender, type));
        } catch (SQLException e) {
            System.err.println(e.getStackTrace());
            System.err.println(e.getMessage());
        }
        start();
    }

    private static String promptName() {
        System.out.print("Enter a name: ");
        String name = scanner.next();
        scanner.nextLine();
        return name;
    }

    private static LocalDate promptDate() {
        String date;

        do {
            System.out.print("Enter a date of birth in the format [1993-10-30]: ");
            date = scanner.next();
        } while (!(dateValidator.isValid(date)));

        scanner.nextLine();
        return LocalDate.parse(date);
    }

    private static <V> int promptOption(Map<Integer, V> map){
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
                System.out.println(e.getClass() + e.getMessage());
                scanner.nextLine();
            }
        } while (!map.containsKey(option));

        scanner.nextLine();
        return option;
    }
}
