package com.digi.repository;

import com.digi.util.GenerateTokens;
import com.digi.util.MyDataSource;

import java.sql.*;

public class UserRepository {

    public void insert(String name, String surname, int age, String email, String password) {
        try {
            Connection connection = MyDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users values(0,?,?,?,?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, password);
            preparedStatement.setString(6, GenerateTokens.generateVerifyCode());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String verifyCode(String email) {
        Connection connection = MyDataSource.getConnection();
        String verification_code = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select verification_code from users where email = ?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                verification_code = resultSet.getString("verification_code");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return verification_code;
    }

    public static boolean checkVerify(String email, String verifyCode) {
        Connection connection = MyDataSource.getConnection();
        String verification_code = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select verification_code from users where email = ?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                verification_code = resultSet.getString("verification_code");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (verification_code != null && verification_code.equals(verifyCode)) {
            return true;
        }
        return false;
    }
}
