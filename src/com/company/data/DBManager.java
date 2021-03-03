package com.company.data;

import com.company.data.interfaces.IDBManager;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager implements IDBManager { //create the class for connection to database
    public Connection getConnection(){
        try {
            Class.forName("org.postgresql.Driver"); //forName operator for connecting driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/assignment5", "postgres", "123qweadzxcUmka");
            return connection; //connection to sql server
        }
        catch (Exception e){
            e.printStackTrace(); //creating exception to avoid errors
        }
        return null;
    }
}
