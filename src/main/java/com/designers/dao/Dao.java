/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.designers.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.designers.domain.Profile;
import com.designers.domain.User;
import com.designers.utils.PasswordUtils;

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
    
    public void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // USER METHODS ////////////////////////////////////////////////////////////////////
    // LOGIN METHOD
    public User login(String username, String password) {
        User user = null;
        Connection connection = getConnection();
        if (connection != null) {
            try {
                String sql = "SELECT * FROM \"user\" WHERE email = ? AND password = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, PasswordUtils.hashPassword(password));
                ResultSet resultSet = preparedStatement.executeQuery();
                
                if (resultSet.next()) {
                    user = new User();
                    
                    user.setIdUser(resultSet.getInt("idUser"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                }
                resultSet.close();
                preparedStatement.close();
                
            } catch (Exception e) {
                Logger.getLogger(username).log(Level.SEVERE, "Ocurrio un error al obtener el usuario", e);
            } finally {
                closeConnection(connection);
            }
        }
        return user;
    }


    // Method to register a new user
    public boolean registerUser(User user) {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                String sql = "INSERT INTO \"user\" (email, password) VALUES (?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getEmail());
                preparedStatement.setString(2, PasswordUtils.hashPassword(user.getPassword()));
                preparedStatement.executeUpdate();
                preparedStatement.close();

                return true;
            } catch (Exception e) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, "Ocurrio un error al registrar el usuario", e);
            } finally {
                closeConnection(connection);
            }
        }
        return false;
    }



    ///////////////////////////////////////////////////////////////////////////////////////


    // PROFILE METHODS
    // Method to get the profile by user ID
    public Profile getProfileByUserId(int userId) {
        Profile profile = null;
        Connection connection = getConnection();
        if (connection != null) {
            try {
                String sql = "SELECT * FROM profile WHERE userId = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, userId);
                ResultSet resultSet = preparedStatement.executeQuery();
                
                if (resultSet.next()) {
                    profile = new Profile();
                    profile.setIdProfile(resultSet.getInt("idProfile"));
                    profile.setName(resultSet.getString("name"));
                    profile.setLastname(resultSet.getString("lastname"));
                    profile.setPhone(resultSet.getString("phone"));
                    profile.setCareerId(resultSet.getInt("careerId"));
                    profile.setUserId(resultSet.getInt("userId"));
                }
                resultSet.close();
                preparedStatement.close();
                
            } catch (Exception e) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, "Ocurrio un error al obtener el perfil", e);
            } finally {
                closeConnection(connection);
            }
        }
        return profile;
    }
    
}
