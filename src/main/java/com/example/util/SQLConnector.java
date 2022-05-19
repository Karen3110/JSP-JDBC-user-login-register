package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLConnector {

    private static final Properties props;
    private static Connection connection = null;

    static {
        props = PropsReader.loadProperties("db.properties");
    }

    private SQLConnector() {
    }


    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                String url = props.getProperty("db.url") + '/' + props.getProperty("db.DB");
                connection = DriverManager.getConnection(
                        url,
                        props.getProperty("db.user"),
                        props.getProperty("db.password")
                );

            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return connection;
    }
}
