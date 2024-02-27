package com.alhaj.jdbcconnection;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateTable {
    private static final String dbCreateSQL="CREATE DATABASE IF NOT EXISTS ";
    public void createTable(Connection connection,String tableName) throws SQLException {
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS " + tableName

                + "  (id   BIGINT auto_increment primary key not null,"
                + "   name            VARCHAR(20) not null,"
                + "   institute       VARCHAR(200) not null,"
                + "   roll                INTEGER not null,"
                + "   class_name          VARCHAR(200) not null,"
                + "   version              BIGINT not null,"
                + "   date_created      timestamp not null)";

        try {
            var statement=connection.createStatement();
            statement.executeUpdate(sqlCreateTable);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
