package org.example;

import org.example.animals.*;
import org.example.animals.pack_animals.PackAnimal;
import org.example.animals.pets.Cat;
import org.example.animals.pets.Pet;
import org.example.utils.AnimalFactory;
import org.example.utils.AnimalType;
import org.example.utils.Command;
import org.example.utils.Gender;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

public final class DataBaseController {
    public static Animal getAnimal(int id, String tableName) throws SQLException {

        try (PreparedStatement statement = DataBaseConnect.getConnection().
                prepareStatement("SELECT * FROM " + tableName + " WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            String name = resultSet.getString(2);
            LocalDate birthDate = resultSet.getDate(3).toLocalDate();
            int genderId = resultSet.getInt(4);
            int typeId = resultSet.getInt(5);
            Animal animal = AnimalFactory.create(name, birthDate, Gender.get(genderId), AnimalType.get(typeId));
            animal.setId(id);
            animal.setCommands(getCommands(animal));
            return animal;
        }
    }

    private static ArrayList<Animal> getAnimals(String tableName) throws SQLException {
        ArrayList<Animal> animals = new ArrayList<>();

        try (Statement statement = DataBaseConnect.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName)) {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                LocalDate birthDate = resultSet.getDate(3).toLocalDate();
                int genderId = resultSet.getInt(4);
                int typeId = resultSet.getInt(5);
                Animal animal = AnimalFactory.create(name, birthDate, Gender.get(genderId), AnimalType.get(typeId));
                animal.setId(id);
                animal.setCommands(getCommands(animal));
                animals.add(animal);
            }
        }

        return animals;
    }

    public static ArrayList<Animal> getPets() throws SQLException {
        return getAnimals(Pet.TABLE_NAME);
    }

    public static ArrayList<Animal> getPackAnimals() throws SQLException {
        return getAnimals(PackAnimal.TABLE_NAME);
    }


    private static HashSet<Command> getCommands(Animal animal) throws SQLException {
        String query = "SELECT command_id FROM " + animal.getCommandTableName() +
                " WHERE " + animal.getCommandTableColumnName() + " = ?" ;
        HashSet<Command> commands = new HashSet<>();

        try (PreparedStatement statement = DataBaseConnect.getConnection().prepareStatement(query)) {
            statement.setInt(1, animal.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int command_id = resultSet.getInt(1);
                commands.add(Command.get(command_id));
            }
        }

        return commands;
    }

    public static void insert(Animal animal) throws SQLException {
        String query = "INSERT INTO " + animal.getParentTableName() +
                "(name, birth_date, gender_id, animal_type_id) VALUES(?, ?, ?, ?)";
        try (PreparedStatement statement = DataBaseConnect.getConnection().prepareStatement(query)) {
            statement.setString(1, animal.getName());
            statement.setObject(2, animal.getBirthDate());
            statement.setInt(3, animal.getGender().getId());
            statement.setInt(4, animal.getType().getId());
            statement.addBatch();
            statement.addBatch("INSERT INTO " + animal.getTableName() + "(id) VALUES (LAST_INSERT_ID())");
            statement.executeBatch();
        }
    }

    public static void addCommandToAnimal(Command command, Animal animal) throws SQLException {
        String query = "INSERT INTO " + animal.getCommandTableName() + "(command_id, " +
                animal.getCommandTableColumnName()  + ") VALUES(?,?)";
        try (PreparedStatement statement = DataBaseConnect.getConnection().prepareStatement(query)){
            statement.setInt(1, command.getId());
            statement.setInt(2, animal.getId());
            statement.executeUpdate();
        }
    }
}
