package com.dev.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private Connection connect = null;
    public Connection connectDB(){ // Config dosyasında sabit mySql girişini oluşturup burada çağırdık
        try {
            this.connect = DriverManager.getConnection(Config.DB_URL,Config.DB_USERNAME,Config.DB_PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return this.connect;
    }
    public static Connection getInstance(){ // database girişini sürekli nesne olarak çağırmak yerine Burada üretip diğer yerlerde çağırabiliriz.
        DBConnector db = new DBConnector();
        return db.connectDB();
    }
}
