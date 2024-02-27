package com.alhaj.jdbcconnection;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateDatabase {

    public void createDatabase(Connection connection,String dbName){
        String dbCreateSQL="CREATE DATABASE IF NOT EXISTS ";

        try {
            var statement=connection.createStatement();
            statement.executeUpdate(dbCreateSQL+dbName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
