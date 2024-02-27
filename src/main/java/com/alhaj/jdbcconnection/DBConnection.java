package com.alhaj.jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL="jdbc:mysql://localhost:3307/student_info";
    private static final String USER="dbeaver";
    private static final String PASSWORD="dbeaver";

    public Connection tryConnection()throws Exception{
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
