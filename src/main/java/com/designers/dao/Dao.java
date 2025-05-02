/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.designers.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class Dao {
    
    private final String JDBC_URL = "jdbc:postgresql://localhost:5432/designers";
    private final String USERNAME = "designers_admin";
    private final String PASSWORD = "admin";
    
    public Dao() {}
    
    private Connection getConnection() {
        try {
            return DriverManager.getConnection(JDBC_URL,USERNAME, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
