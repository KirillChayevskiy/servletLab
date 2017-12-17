package main.java.by.bsuir.pms413802.Chayevskiy.DAO;

import main.java.by.bsuir.pms413802.Chayevskiy.MyConnector;
import main.java.by.bsuir.pms413802.Chayevskiy.entities.Relation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RelationDAO {



    public boolean insertRelation(Relation relation) throws SQLException {
        String sql = "INSERT INTO UserTariffRelation (UserID, TariffID) VALUES (?, ?)";
        MyConnector.connect();

        PreparedStatement statement = MyConnector.jdbcConnection.prepareStatement(sql);
        statement.setInt(1, relation.getUserID());
        statement.setInt(2, relation.getTariffID());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        MyConnector.disconnect();
        return rowInserted;
    }

    public List<Relation> listAllRelation() throws SQLException {
        List<Relation> listUser = new ArrayList<>();

        String sql = "SELECT * FROM UserTariffRelation ";

        MyConnector.connect();

        Statement statement = MyConnector.jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int userID = resultSet.getInt("userID");
            int tariffID = resultSet.getInt("tariffID");

            Relation relation = new Relation(id, userID, tariffID);
            listUser.add(relation);
        }

        resultSet.close();
        statement.close();

        MyConnector.disconnect();

        return listUser;
    }

    public boolean deleteRelation(Relation relation) throws SQLException {
        String sql = "DELETE FROM UserTariffRelation where id = ?";

        MyConnector.connect();

        PreparedStatement statement = MyConnector.jdbcConnection.prepareStatement(sql);
        statement.setInt(1, relation.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        MyConnector.disconnect();
        return rowDeleted;
    }

    public boolean updateRelation(Relation relation) throws SQLException {
        String sql = "UPDATE UserTariffRelation SET UserID = ?, TariffID = ?";
        sql += " WHERE id = ?";
        MyConnector.connect();

        PreparedStatement statement = MyConnector.jdbcConnection.prepareStatement(sql);
        statement.setInt(1, relation.getUserID());
        statement.setInt(2, relation.getTariffID());
        statement.setInt(3, relation.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        MyConnector.disconnect();
        return rowUpdated;
    }

    public Relation getRelation(int id) throws SQLException {
        Relation relation = null;
        String sql = "SELECT * FROM UserTariffRelation WHERE id = ?";

        MyConnector.connect();

        PreparedStatement statement = MyConnector.jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int userID = resultSet.getInt("userID");
            int tariffID = resultSet.getInt("tariffID");

            relation = new Relation(id, userID, tariffID);
        }

        resultSet.close();
        statement.close();

        return relation;
    }
}
