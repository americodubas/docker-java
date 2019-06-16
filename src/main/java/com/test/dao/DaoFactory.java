package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;

class DaoFactory {

    private static boolean tableChecked = false;
    private static String mysqlUrl = null
            ,mysqlUser = null
            ,mysqlPassword = null;

    static Connection getConnection() throws SQLException, ClassNotFoundException {

        if (!tableChecked) {
            setDatabaseConfiguration();
        }

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://" + mysqlUrl, mysqlUser, mysqlPassword);

        if (!tableChecked) {
            createTable(connection);
        }

        return connection;
    }

    private static void setDatabaseConfiguration() {
        System.out.println("GET DATA CONF");
        Hashtable<Object, Object> map = System.getProperties();
        System.getProperties().forEach( (x, y) -> {
            if (x.equals("MYSQL_URL")) {
                mysqlUrl = String.valueOf(y);
                System.out.println("mysqlUrl:" + mysqlUrl);
            }
            if (x.equals("MYSQL_USER")) {
                mysqlUser = String.valueOf(y);
                System.out.println("mysqlUser:" + mysqlUser);
            }
            if (x.equals("MYSQL_PASSWORD")) {
                mysqlPassword = String.valueOf(y);
                System.out.println("mysqlPassword:" + mysqlPassword);
            }
        } );
    }

    private static void createTable(Connection connection) {
        System.out.println("CREATE EXAM TABLE");
        try {
            String sql = "create table if not exists exam "
                + "(id int auto_increment"
                + ",name varchar(255)"
                + ",description text"
                + ", primary key (id)"
                + ") engine=innodb";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.executeUpdate();
            }
            tableChecked = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
