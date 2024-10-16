package org.example.view;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import org.example.animals.Animal;

import java.util.List;
import java.util.Map;

public final class ConsolePrinter {
    public static <V> void render(Map<Integer, V> map) {
        System.out.println();
        for (Map.Entry<Integer, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
    }
    public static <T extends Animal> void render(List<T> animals) {
        AsciiTable asciiTable = new AsciiTable();
        asciiTable.addRule();
        asciiTable.addRow("Id", "Name", "Birthdate", "Gender", "Type", "Commands");
        asciiTable.addRule();

        for (Animal animal : animals) {
            asciiTable.addRow(animal.getId(), animal.getName(), animal.getBirthDate(),
                    animal.getGender(), animal.getAnimalType(), animal.getCommands());
            asciiTable.addRule();
        }

        asciiTable.getRenderer().setCWC(new CWC_LongestLine());
        asciiTable.setPaddingLeftRight(1);
        System.out.println(asciiTable.render());
    }

    public static void render(Animal animal){
        render(List.of(animal));
    }
}
