package org.example;

import org.example.animals.Cat;
import org.example.animals.Dog;
import org.example.animals.Pet;

import java.sql.*;

public class DataBaseManager {

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

    private PreparedStatement getInsertIntoPetsStatement(Pet pet) throws SQLException {
        String query = "INSERT INTO pets(name, birth_date, gender, pet_type_id) VALUES(?, ?, ?, ?)";
        PreparedStatement statement = DataBaseConnect.getConnection().prepareStatement(query);
        statement.setString(1, pet.getName());
        statement.setObject(2, pet.getBirthDate());
        statement.setString(3, pet.getGender().getTitle());
        statement.setInt(4, pet.getPetType().getId());
        return statement;
    }
}
