/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.designers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.designers.domain.Career;

public class CareersDao {

    // Implement the methods to interact with the database for the Careers entity
    // For example, you might have methods like:
    // - getAllCareers()
    // - getCareerById(int id)
    // - addCareer(Career career)
    // - updateCareer(Career career)
    // - deleteCareer(int id)
    
    // Method to get all careers
    public static List<Career> getAllCareers() {

        Connection conn = Dao.getConnection();
        List<Career> careers = new ArrayList<>();

        try {
            String sql = "SELECT * FROM career";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idCareer = rs.getInt("idCareer");
                String name = rs.getString("name");
                Career career = new Career(idCareer, name);
                careers.add(career);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Dao.closeConnection(conn);
        }
        return careers;

    }
    
    // Method to get a career by ID
    public static Career getCareerById(int id) {
        Connection conn = Dao.getConnection();
        Career career = null;

        try {
            String sql = "SELECT * FROM career WHERE idCareer = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int idCareer = rs.getInt("idCareer");
                String name = rs.getString("name");
                career = new Career(idCareer, name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Dao.closeConnection(conn);
        }
        return career;
    }

    // Method to add a new career
    public static boolean saveCareer(Career career) {
        Connection conn = Dao.getConnection();
        boolean success = false;

        try {
            String sql = "INSERT INTO career (name) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, career.getName());
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    career.setIdCareer(generatedKeys.getInt(1));
                    success = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Dao.closeConnection(conn);
        }
        return success;
    }

    // Method to update a career
    public static boolean updateCareer(Career career) {
        Connection conn = Dao.getConnection();
        boolean success = false;

        try {
            String sql = "UPDATE career SET name = ? WHERE idCareer = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, career.getName());
            stmt.setInt(2, career.getIdCareer());
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                success = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Dao.closeConnection(conn);
        }
        return success;
    }

    // Method to delete a career
    public static boolean deleteCareer(int id) {
        Connection conn = Dao.getConnection();
        boolean success = false;

        try {
            String sql = "DELETE FROM career WHERE idCareer = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                success = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Dao.closeConnection(conn);
        }
        return success;
    }

    // Method to get a career by name
    public static Career getCareerByName(String name) {
        Connection conn = Dao.getConnection();
        Career career = null;

        try {
            String sql = "SELECT * FROM career WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int idCareer = rs.getInt("idCareer");
                career = new Career(idCareer, name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Dao.closeConnection(conn);
        }
        return career;
    }

    
}
