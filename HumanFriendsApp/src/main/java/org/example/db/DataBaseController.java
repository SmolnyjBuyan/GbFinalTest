package org.example.db;

import org.example.animals.*;
import org.example.utils.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;

public final class DataBaseController {
    public static Animal getAnimal(int id, AbstractAnimalType type) throws SQLException {

        try (PreparedStatement statement = DataBaseConnect.getConnection().
                prepareStatement("SELECT * FROM " + type.getTableName() + " WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            Animal animal = AnimalFactory.create(resultSet.getString(2),
                    resultSet.getDate(3).toLocalDate(),
                    Gender.get(resultSet.getInt(4)),
                    AnimalType.get(resultSet.getInt(5)));
            animal.setId(id);
            animal.setCommands(getCommands(animal));
            return animal;
        }
    }

    private static ArrayList<Animal> getAnimals(AbstractAnimalType abstractAnimalType) throws SQLException {
        ArrayList<Animal> animals = new ArrayList<>();

        try (Statement statement = DataBaseConnect.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM " + abstractAnimalType.getTableName())) {
            while (resultSet.next()) {
                Animal animal = AnimalFactory.create(resultSet.getString(2),
                        resultSet.getDate(3).toLocalDate(),
                        Gender.get(resultSet.getInt(4)),
                        AnimalType.get(resultSet.getInt(5)));
                animal.setId(resultSet.getInt(1));
                animal.setCommands(getCommands(animal));
                animals.add(animal);
            }
        }

        return animals;
    }

    public static ArrayList<Animal> getPets() throws SQLException {
        return getAnimals(AbstractAnimalType.PET);
    }

    public static ArrayList<Animal> getPackAnimals() throws SQLException {
        return getAnimals(AbstractAnimalType.PACK_ANIMAL);
    }


    private static HashSet<Command> getCommands(Animal animal) throws SQLException {
        String query = "SELECT command_id FROM " + animal.getCommandTableName() +
                " WHERE " + animal.getCommandTableColumnName() + " = ?" ;
        HashSet<Command> commands = new HashSet<>();

        try (PreparedStatement statement = DataBaseConnect.getConnection().prepareStatement(query)) {
            statement.setInt(1, animal.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                commands.add(Command.get(resultSet.getInt(1)));
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
            statement.setInt(4, animal.getAnimalType().getId());
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
