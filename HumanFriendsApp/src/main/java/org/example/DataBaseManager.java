package org.example;

import org.example.animals.Cat;
import org.example.animals.Dog;
import org.example.utils.PetType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseManager {
    private Connection connection;

    public DataBaseManager(Connection connection) {
        this.connection = DataBaseConnect.getConnection();
    }

    public void create(Cat cat) throws SQLException {
        String query = "INSERT INTO pets(name, birth_date, gender, pet_type_id) VALUES(?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, cat.getName());
        statement.setObject(2, cat.getBirthDate());
        statement.setString(3, cat.getGender().getTitle());
        statement.setInt(4, PetType.CAT.getId());
        statement.addBatch();
        statement.addBatch("SET @last_id_in_pets = LAST_INSERT_ID()");
        statement.addBatch("INSERT INTO cats(id) VALUES (@last_id_in_pets)");
        statement.executeBatch();


//        String insertSql = String.format("INSERT INTO pets(name, birth_date, gender, pet_type_id)"
//                + " VALUES(%s, %s, %s, %s)", cat.getName(), cat.getBirthDate(),
//                cat.getGender().getTitle(), PetType.CAT.getId());
    }

    public void create(Dog dog) throws SQLException {
        String query = "INSERT INTO pets(name, birth_date, gender, pet_type_id) VALUES(?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, dog.getName());
        statement.setObject(2, dog.getBirthDate());
        statement.setString(3, dog.getGender().getTitle());
        statement.setInt(4, PetType.DOG.getId());
        statement.addBatch();
        statement.addBatch("SET @last_id_in_pets = LAST_INSERT_ID()");
        statement.addBatch("INSERT INTO dogs(id) VALUES (@last_id_in_pets)");
        statement.executeBatch();
    }
}
