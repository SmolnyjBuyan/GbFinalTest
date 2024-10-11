package org.example.view;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import org.example.animals.Animal;

import java.util.List;
import java.util.Map;

public interface Optionable {

    static <V> void print(Map<Integer, V> map) {
        System.out.println();
        for (Map.Entry<Integer, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
    }
    static <T extends Animal> void print(List<T> animals) {
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
}
