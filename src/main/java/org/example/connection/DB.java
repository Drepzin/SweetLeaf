package org.example.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    private static DB instace = null;

    private final Connection conn;

    private DB(){
        try(InputStream is = getClass().getResourceAsStream("/db.properties")){
            Properties properties = new Properties();
            properties.load(is);
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection granted");
        }
        catch (IOException | ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static DB getInstace(){
        if(instace == null){instace = new DB();};
        return instace;
    }

    public Connection getConn(){
        if(conn == null){throw new RuntimeException("Fail");}
        return conn;
    }

    public void shutdownConnection(){
        try{
            conn.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
