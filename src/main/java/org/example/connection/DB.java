package org.example.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    private String driver, url, username, password;

    private static DB instace = null;

    private DB(){
        try(InputStream is = getClass().getResourceAsStream("/db.properties")){
            Properties properties = new Properties();
            properties.load(is);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            Class.forName(driver);
        }
        catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public static DB getInstace(){
        if(instace == null){instace = new DB();};
        return instace;
    }

    public Connection getConn(){
        try{
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
