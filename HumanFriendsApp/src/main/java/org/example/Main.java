package org.example;

import org.example.animals.Cat;
import org.example.utils.Gender;
import org.example.utils.PetType;

import java.sql.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/human_friends";
        String user = "root";
        String password = "Andrey6542564";
        String query = "SELECT * FROM pets";

//        try (Connection connection = DriverManager.getConnection(dbUrl, user, password);
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(query);) {
//            while (resultSet.next()) {
//                int id = resultSet.getInt(1);
//                String name = resultSet.getString(2);
//                LocalDate birth_date = resultSet.getDate(3).toLocalDate();
//                String gender = resultSet.getString(4);
//                System.out.println(id + "\t"+ name + "\t"+ birth_date + "\t"+ gender);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        LocalDate date = LocalDate.of(2015, 10, 30);
//        String test = String.format("%s", date);
//        System.out.println(test);

        Cat tom = new Cat("Tom", LocalDate.of(2015, 10, 30), Gender.MALE);
        String sql = "INSERT INTO pets(name, birth_date, gender, pet_type_id) VALUES(?, ?, ?, ?)";

//
//        try (Connection connection = DriverManager.getConnection(dbUrl, user, password)) {
//            DataBaseManager dataBaseManager = new DataBaseManager();
//            dataBaseManager.insertIntoCats(tom);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

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
}