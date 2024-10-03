package org.example;

import org.example.animals.Animal;
import org.example.utils.AnimalFactory;
import org.example.utils.AnimalType;
import org.example.utils.Gender;
import org.example.view.View;

import java.sql.SQLException;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        View view = new View();
        view.start();

//        Animal tom = AnimalFactory.create("Tom", LocalDate.of(2015, 10, 30), Gender.MALE, AnimalType.CAT);
//        DataBaseController dataBase = new DataBaseController();
//        try {
//            dataBase.insert(tom);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        String query = "SELECT * FROM pets";
//        Animal tom = AnimalFactory.create("Tom", LocalDate.of(2015, 10, 30), Gender.MALE, AnimalType.CAT);
//        String sql = "INSERT INTO pets(name, birth_date, gender, pet_type_id) VALUES(?, ?, ?, ?)";
//
//        DataBaseManager dataBaseManager = new DataBaseManager();
//        try {
//            dataBaseManager.insertIntoCats((Cat) tom);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        try (Connection connection = DataBaseConnect.getConnection();
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(query)) {
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
    }
}