package org.example;

import org.example.animals.Cat;
import org.example.animals.Dog;
import org.example.animals.Hamster;
import org.example.animals.Pet;

import java.sql.*;
import java.time.LocalDate;

public class DataBaseManager {

    public void showAnimals() {
        String query = "SELECT * FROM pets";

        try (Connection connection = DataBaseConnect.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                LocalDate birth_date = resultSet.getDate(3).toLocalDate();
                String gender = resultSet.getString(4);
                System.out.println(id + "\t"+ name + "\t"+ birth_date + "\t"+ gender);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private PreparedStatement getInsertIntoPetsStatement(Pet pet) throws SQLException {
        String query = "INSERT INTO pets(name, birth_date, gender, pet_type_id) VALUES(?, ?, ?, ?)";
        PreparedStatement statement = DataBaseConnect.getConnection().prepareStatement(query);
        statement.setString(1, pet.getName());
        statement.setObject(2, pet.getBirthDate());
        statement.setString(3, pet.getGender().getTitle());
        statement.setInt(4, pet.getPetType().getId());
        return statement;
    }

    public void insertIntoCats(Cat cat) throws SQLException {
        try (PreparedStatement statement = getInsertIntoPetsStatement(cat)) {
            statement.addBatch();
            statement.addBatch("INSERT INTO cats(id) VALUES (LAST_INSERT_ID())");
            statement.executeBatch();
        }
    }

    public void insertIntoDogs(Dog dog) throws SQLException {
        try (PreparedStatement statement = getInsertIntoPetsStatement(dog)) {
            statement.addBatch();
            statement.addBatch("INSERT INTO dogs(id) VALUES (LAST_INSERT_ID())");
            statement.executeBatch();
        }
    }
    public void insertIntoHamsters(Hamster hamster) throws SQLException {
        try (PreparedStatement statement = getInsertIntoPetsStatement(hamster)) {
            statement.addBatch();
            statement.addBatch("INSERT INTO hamster(id) VALUES (LAST_INSERT_ID())");
            statement.executeBatch();
        }
    }
}
