package com.example.JSP_FILES_LERNING.repository;

import com.example.JSP_FILES_LERNING.model.User;
import com.example.util.SQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserRepository {
    public List<User> getAll() {
        List<User> data = new LinkedList<>();
        Connection connection = SQLConnector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM testet.user");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                data.add(mapper(resultSet));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return data;
    }

    public User getByLoginAndPassword(String login, String password) {
        User user = null;
        Connection connection = SQLConnector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM testet.user WHERE login=? AND password=?");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = mapper(resultSet);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return user;
    }


    private User mapper(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setSurname(resultSet.getString("surname"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setAddress(resultSet.getString("address"));
        user.setContact(resultSet.getString("contact"));

        return user;

    }

    public void signUp(User user) {
        Connection connection = SQLConnector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO testet.user VALUES (0,?,?,?,?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getContact());

            int i = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
