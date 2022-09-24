package com.digi.repository;

import com.digi.util.GenerateTokens;
import com.digi.util.MyDataSource;

import java.sql.*;
import java.util.StringJoiner;

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

    public static boolean login(String email, String password) {
        Connection connection = MyDataSource.getConnection();
        String password1 = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select password from users where email = ?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                password1 = resultSet.getString("password");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (password1 != null && password1.equals(password)) {
            return true;
        }
        return false;
    }

    public static String getInfo(String email) {
        Connection connection = MyDataSource.getConnection();
        StringJoiner sj = new StringJoiner(" ");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where email = ?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                sj.add(first_name);
                sj.add(last_name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sj.toString();
    }

    public static Integer getByEmail(String email) {
        Connection connection = MyDataSource.getConnection();
        Integer id = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select id from users where email = ?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    public static boolean forgetPassword(String password, String email) {

        Connection connection = MyDataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET" +
                    " password = ? where email = ?");
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return false;
    }
}


