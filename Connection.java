/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lnj.restaurant;

import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Josiane Mango
 */
public class Connection {
java.sql.Connection con = null;
    
    public static java.sql.Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost/restaurantlnj"; //port to mysql is 3306
            java.sql.Connection con = DriverManager.getConnection(databaseURL, "root", "");
            //JOptionPane.showMessageDialog(null, "Connected to DB!");
            return con;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            return null;
        }
    }
    
    
}
