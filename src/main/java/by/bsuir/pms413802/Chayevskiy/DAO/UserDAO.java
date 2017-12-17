package main.java.by.bsuir.pms413802.Chayevskiy.DAO;

import main.java.by.bsuir.pms413802.Chayevskiy.MyConnector;
import main.java.by.bsuir.pms413802.Chayevskiy.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {



    public boolean insertUser(User user) throws SQLException {
        String sql = "INSERT INTO user (name, surname) VALUES (?, ?)";
        MyConnector.connect();

        PreparedStatement statement = MyConnector.jdbcConnection.prepareStatement(sql);
        statement.setString(1, user.getName());
        statement.setString(2, user.getSurname());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        MyConnector.disconnect();
        return rowInserted;
    }

    public List<User> listAllUser() throws SQLException {
        List<User> listUser = new ArrayList<>();

        String sql = "SELECT * FROM User ";

        MyConnector.connect();

        Statement statement = MyConnector.jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");

            User user = new User(id, name, surname);
            listUser.add(user);
        }

        resultSet.close();
        statement.close();

        MyConnector.disconnect();

        return listUser;
    }

    public boolean deleteUser(User user) throws SQLException {
        String sql = "DELETE FROM User where id = ?";

        MyConnector.connect();

        PreparedStatement statement = MyConnector.jdbcConnection.prepareStatement(sql);
        statement.setInt(1, user.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        MyConnector.disconnect();
        return rowDeleted;
    }

    public boolean updateUser(User user) throws SQLException {
        String sql = "UPDATE User SET name = ?, surname = ?";
        sql += " WHERE id = ?";
        MyConnector.connect();

        PreparedStatement statement = MyConnector.jdbcConnection.prepareStatement(sql);
        statement.setString(1, user.getName());
        statement.setString(2, user.getSurname());
        statement.setInt(3, user.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        MyConnector.disconnect();
        return rowUpdated;
    }

    public User getUser(int id) throws SQLException {
        User user = null;
        String sql = "SELECT * FROM User WHERE id = ?";

        MyConnector.connect();

        PreparedStatement statement = MyConnector.jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");

            user = new User(id, name, surname);
        }

        resultSet.close();
        statement.close();

        return user;
    }
}
