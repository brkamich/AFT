/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aft;

import java.sql.*;

/**
 *
 * @author Michal
 */
public class Database {

    private Connection connection = null;
    private Statement statement = null;

    public Database() {
            try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE FILES (ID INT PRIMARY KEY NOT NULL, BANK TEXT NOT NULL, UPLOAD_TIME TEXT)");
            statement.executeUpdate("CREATE TABLE EVENTS ("+
                    "ID INT PRIMARY KEY NOT NULL,"+
                    "TRANSACTION_TIME TEXT NOT NULL,"+ 
                    "TRANSACTION_AMOUNT INT NOT NULL,"+
                    "CURRENCY TEXT,OFFSET INT,"+
                    "BANK_CODE INT,"+
                    "BANK_NAME TEXT,"+
                    "KS INT,"+
                    "VS INT,"+
                    "SS INT,"+
                    "NOTE TEXT,"+
                    "MESSAGE_FOR_RECIEVER TEXT"+
                    "TYPE TEXT"+
                    "DONE_BY TEXT"+
                    "BIC INT)");
            statement.close();
            }catch(Exception e){
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            }
            
    }

    private ResultSet selectFromDatabase(String command) {
        ResultSet rs = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            rs = statement.executeQuery(command);
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return rs;
    }
    
    private void updateDatabse(String command){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            statement.executeUpdate(command);
            connection.commit();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
}
