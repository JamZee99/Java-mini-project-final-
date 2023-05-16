package com.lms;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class LMSdb {

    Connection conn = null;

    public static Connection java_db()
    {
        final String DB_URL = "jdbc:mysql://localhost/lms-java1";
        final String USERNAME = "root";
        final String PASSWord = "jamzee";
        try{

            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWord);
            return conn;

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }
}
