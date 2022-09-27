package com.digi.repository;

import com.digi.model.Address;
import com.digi.model.User;
import com.digi.util.MyDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Address> getAddress(int user_id) {
        Connection connection = MyDataSource.getConnection();
        List<Address> addresses = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from address where user_id = ?");
            preparedStatement.setInt(1, user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Address address = new Address();
                address.setAddress_id(resultSet.getInt("address_id"));
                address.setCountry(resultSet.getString("country"));
                address.setCity((resultSet.getString("city")));
                address.setStreet(resultSet.getString("street"));
                address.setHome(resultSet.getString("home"));
                addresses.add(address);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return addresses;
    }
}
