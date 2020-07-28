package ru.shamma.lesson4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SetDb {

    DbName dbName;

    public SetDb(DbName dbName) {
        this.dbName = dbName;
    }

    public void setDb() throws ClassNotFoundException, SQLException {
        switch (dbName){
            case MYSQL:
                Connection connection = DriverManager.getConnection("jdbc:sqlite:main.db");
                Class.forName("com.mysql.jdbc.Driver");
            break;
            case POSTGRESQL:
                connection = DriverManager.getConnection("2");
                Class.forName("2");
                break;
        }
    }
}
