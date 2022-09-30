/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Shakith
 */
public class DBConnection {

    private static Connection connection;

    private static Statement createConnection() throws Exception{
        if (connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "car_rental", "root", "1234");
        }
        Statement statement = connection.createStatement();
        return statement;
    }
    
    public static void iud(String query){
        try {
            createConnection().executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static ResultSet search(String query) throws Exception{
        return createConnection().executeQuery(query);
    }
}
