package main.java.by.bsuir.pms413802.Chayevskiy.DAO;

import main.java.by.bsuir.pms413802.Chayevskiy.MyConnector;
import main.java.by.bsuir.pms413802.Chayevskiy.entities.Tariff;
import main.java.by.bsuir.pms413802.Chayevskiy.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TariffDAO {




    public boolean insertTariff(Tariff tariff) throws SQLException {
        String sql = "INSERT INTO tariff (name) VALUES (?)";
        MyConnector.connect();

        PreparedStatement statement = MyConnector.jdbcConnection.prepareStatement(sql);
        statement.setString(1, tariff.getName());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        MyConnector.disconnect();
        return rowInserted;
    }

    public List<Tariff> listAllTariff() throws SQLException {
        List<Tariff> listTariff = new ArrayList<>();

        String sql = "SELECT * FROM Tariff ";

        MyConnector.connect();

        Statement statement = MyConnector.jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");

            Tariff tariff = new Tariff(id, name);
            listTariff.add(tariff);
        }

        resultSet.close();
        statement.close();

        MyConnector.disconnect();

        return listTariff;
    }

    public boolean deleteTariff(Tariff tariff) throws SQLException {
        String sql = "DELETE FROM Tariff where id = ?";

        MyConnector.connect();

        PreparedStatement statement = MyConnector.jdbcConnection.prepareStatement(sql);
        statement.setInt(1, tariff.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        MyConnector.disconnect();
        return rowDeleted;
    }

    public boolean updateTariff(Tariff tariff) throws SQLException {
        String sql = "UPDATE Tariff SET name = ?";
        sql += " WHERE id = ?";
        MyConnector.connect();

        PreparedStatement statement = MyConnector.jdbcConnection.prepareStatement(sql);
        statement.setString(1, tariff.getName());
        statement.setInt(2, tariff.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        MyConnector.disconnect();
        return rowUpdated;
    }

    public Tariff getTariff(int id) throws SQLException {
        Tariff tariff = null;
        String sql = "SELECT * FROM Tariff WHERE id = ?";

        MyConnector.connect();

        PreparedStatement statement = MyConnector.jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String name = resultSet.getString("name");

            tariff = new Tariff(id, name);
        }

        resultSet.close();
        statement.close();

        return tariff;
    }
}

