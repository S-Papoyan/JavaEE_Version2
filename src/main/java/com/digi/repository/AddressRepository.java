package com.digi.repository;

import com.digi.util.MyDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddressRepository {

    public static void saveAddress(String county, String city, String street, String home, int user_id) {
        Connection connection = MyDataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into address " +
                    "values (0,?,?,?,?,?)");
            preparedStatement.setString(1, county);
            preparedStatement.setString(2, city);
            preparedStatement.setString(3, street);
            preparedStatement.setString(4, home);
            preparedStatement.setInt(5, user_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
