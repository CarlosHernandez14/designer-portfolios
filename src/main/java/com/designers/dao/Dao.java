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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.designers.domain.Profile;
import com.designers.domain.Skill;
import com.designers.domain.User;
import com.designers.utils.PasswordUtils;

public class Dao {
    
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/designers";
    private static final String USERNAME = "designers_admin";
    private static final String PASSWORD = "admin";
    
    public Dao() {}
    
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(JDBC_URL,USERNAME, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void closeConnection(Connection connection) {
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
                int userId = -1;
                String sql = "INSERT INTO \"user\" (email, password) VALUES (?, ?) RETURNING idUser";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getEmail());
                preparedStatement.setString(2, PasswordUtils.hashPassword(user.getPassword()));
                
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    userId = resultSet.getInt("idUser");
                }
                resultSet.close();
                preparedStatement.close();

                // If the user was created now we can create the profile
                Profile profile = new Profile();
                profile.setUserId(userId);
                profile.setName(user.getEmail());

                // Register the profile
                int profileId = registerProfile(profile);
                return profileId != -1;
            } catch (Exception e) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, "Ocurrio un error al registrar el usuario", e);
            } finally {
                closeConnection(connection);
            }
        }
        return false;
    }

    // Get user by ID
    public static User getUserById(int userId) {
        User user = null;
        Connection connection = getConnection();
        if (connection != null) {
            try {
                String sql = "SELECT * FROM \"user\" WHERE idUser = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, userId);
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
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, "Ocurrio un error al obtener el usuario", e);
            } finally {
                closeConnection(connection);
            }
        }
        return user;
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
                    profile.setSummary(resultSet.getString("summary"));
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

    // Method to register a new profile
    // Returns the ID of the new profile
    public static int registerProfile(Profile profile) {
        Connection connection = getConnection();
        int profileId = -1;
        if (connection != null) {
            try {
                String sql;
                PreparedStatement preparedStatement = null;
                if (profile.getCareerId() != 0) {
                    sql = "INSERT INTO profile (name, lastname, phone, careerId, userId, summary) VALUES (?, ?, ?, ?, ?, ?) RETURNING idProfile";
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, profile.getName());
                    preparedStatement.setString(2, profile.getLastname());
                    preparedStatement.setString(3, profile.getPhone());
                    preparedStatement.setInt(4, profile.getCareerId());
                    preparedStatement.setInt(5, profile.getUserId());
                    preparedStatement.setString(6, profile.getSummary());
                } else {
                    sql = "INSERT INTO profile (name, lastname, phone, userId, summary) VALUES (?, ?, ?, ?, ?) RETURNING idProfile";
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, profile.getName());
                    preparedStatement.setString(2, profile.getLastname());
                    preparedStatement.setString(3, profile.getPhone());
                    preparedStatement.setInt(4, profile.getUserId());
                    preparedStatement.setString(5, profile.getSummary());
                }
                
                ResultSet resultSet = preparedStatement.executeQuery();
                
                if (resultSet.next()) {
                    profileId = resultSet.getInt("idProfile");
                }
                
                resultSet.close();
                preparedStatement.close();
                
            } catch (Exception e) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, "Ocurrio un error al registrar el perfil", e);
            } finally {
                closeConnection(connection);
            }
        }
        return profileId;
    }

    // Method to update a profile
    public static boolean updateProfile(Profile profile) {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                String sql = "UPDATE profile SET name = ?, lastname = ?, phone = ?, careerId = ?, summary = ? WHERE idProfile = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, profile.getName());
                preparedStatement.setString(2, profile.getLastname());
                preparedStatement.setString(3, profile.getPhone());
                preparedStatement.setInt(4, profile.getCareerId());
                preparedStatement.setString(5, profile.getSummary());
                preparedStatement.setInt(6, profile.getIdProfile());
                
                
                int rowsUpdated = preparedStatement.executeUpdate();
                
                preparedStatement.close();
                
                return rowsUpdated > 0;
            } catch (Exception e) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, "Ocurrio un error al actualizar el perfil", e);
            } finally {
                closeConnection(connection);
            }
        }
        return false;
    }

    // Method to delete a profile
    public static boolean deleteProfile(int profileId) {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                String sql = "DELETE FROM profile WHERE idProfile = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, profileId);
                
                int rowsDeleted = preparedStatement.executeUpdate();
                
                preparedStatement.close();
                
                return rowsDeleted > 0;
            } catch (Exception e) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, "Ocurrio un error al eliminar el perfil", e);
            } finally {
                closeConnection(connection);
            }
        }
        return false;
    }

    // Method to get a profile by ID
    public static Profile getProfileById(int profileId) {
        Profile profile = null;
        Connection connection = getConnection();
        if (connection != null) {
            try {
                String sql = "SELECT * FROM profile WHERE idProfile = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, profileId);
                ResultSet resultSet = preparedStatement.executeQuery();
                
                if (resultSet.next()) {
                    profile = new Profile();
                    profile.setIdProfile(resultSet.getInt("idProfile"));
                    profile.setName(resultSet.getString("name"));
                    profile.setLastname(resultSet.getString("lastname"));
                    profile.setPhone(resultSet.getString("phone"));
                    profile.setCareerId(resultSet.getInt("careerId"));
                    profile.setUserId(resultSet.getInt("userId"));
                    profile.setSummary(resultSet.getString("summary"));
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

    // Method to get all profiles
    public static List<Profile> getAllProfiles() {
        List<Profile> profiles = new ArrayList<>();
        Connection connection = getConnection();
        if (connection != null) {
            try {
                String sql = "SELECT * FROM profile";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {
                    Profile profile = new Profile();
                    profile.setIdProfile(resultSet.getInt("idProfile"));
                    profile.setName(resultSet.getString("name"));
                    profile.setLastname(resultSet.getString("lastname"));
                    profile.setPhone(resultSet.getString("phone"));
                    profile.setCareerId(resultSet.getInt("careerId"));
                    profile.setUserId(resultSet.getInt("userId"));
                    profile.setSummary(resultSet.getString("summary"));
                    
                    profiles.add(profile);
                }
                resultSet.close();
                preparedStatement.close();
                
            } catch (Exception e) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, "Ocurrio un error al obtener todos los perfiles", e);
            } finally {
                closeConnection(connection);
            }
        }
        return profiles;
    }

    ////////////////////////////////////////////////////////////////////////////
    /// METHODS FOR SKILLS
    
    // Method to get the skills by profileId
    public static List<Skill> getSkillsByProfileId(int profileId) {
        List<Skill> skills = new ArrayList<>();
        Connection connection = getConnection();
        if (connection != null) {
            try {
                String sql = "SELECT * FROM skill WHERE profileId = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, profileId);
                ResultSet resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {
                    Skill skill = new Skill();
                    skill.setIdSkill(resultSet.getInt("idSkill"));
                    skill.setName(resultSet.getString("name"));
                    skill.setDescription(resultSet.getString("description"));
                    skill.setProfileId(resultSet.getInt("profileId"));
                    
                    skills.add(skill);
                }
                resultSet.close();
                preparedStatement.close();
                
            } catch (Exception e) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, "Ocurrio un error al obtener las habilidades", e);
            } finally {
                closeConnection(connection);
            }
        }
        return skills;
    }

    // Method to register a new skill
    public static boolean registerSkill(Skill skill) {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                String sql = "INSERT INTO skill (name, description, profileId) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, skill.getName());
                preparedStatement.setString(2, skill.getDescription());
                preparedStatement.setInt(3, skill.getProfileId());
                
                int rowsInserted = preparedStatement.executeUpdate();
                
                preparedStatement.close();
                
                return rowsInserted > 0;
            } catch (Exception e) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, "Ocurrio un error al registrar la habilidad", e);
            } finally {
                closeConnection(connection);
            }
        }
        return false;
    }

    // Method to update a skill
    public static boolean updateSkill(Skill skill) {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                String sql = "UPDATE skill SET name = ?, description = ? WHERE idSkill = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, skill.getName());
                preparedStatement.setString(2, skill.getDescription());
                preparedStatement.setInt(3, skill.getIdSkill());
                
                int rowsUpdated = preparedStatement.executeUpdate();
                
                preparedStatement.close();
                
                return rowsUpdated > 0;
            } catch (Exception e) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, "Ocurrio un error al actualizar la habilidad", e);
            } finally {
                closeConnection(connection);
            }
        }
        return false;
    }

    // Method to delete a skill
    public static boolean deleteSkill(int skillId) {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                String sql = "DELETE FROM skill WHERE idSkill = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, skillId);
                
                int rowsDeleted = preparedStatement.executeUpdate();
                
                preparedStatement.close();
                
                return rowsDeleted > 0;
            } catch (Exception e) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, "Ocurrio un error al eliminar la habilidad", e);
            } finally {
                closeConnection(connection);
            }
        }
        return false;
    }

    // Method to get a skill by ID
    public static Skill getSkillById(int skillId) {
        Skill skill = null;
        Connection connection = getConnection();
        if (connection != null) {
            try {
                String sql = "SELECT * FROM skill WHERE idSkill = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, skillId);
                ResultSet resultSet = preparedStatement.executeQuery();
                
                if (resultSet.next()) {
                    skill = new Skill();
                    skill.setIdSkill(resultSet.getInt("idSkill"));
                    skill.setName(resultSet.getString("name"));
                    skill.setDescription(resultSet.getString("description"));
                    skill.setProfileId(resultSet.getInt("profileId"));
                }
                resultSet.close();
                preparedStatement.close();
                
            } catch (Exception e) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, "Ocurrio un error al obtener la habilidad", e);
            } finally {
                closeConnection(connection);
            }
        }
        return skill;
    }

    // Method to get all skills
    public static List<Skill> getAllSkills() {
        List<Skill> skills = new ArrayList<>();
        Connection connection = getConnection();
        if (connection != null) {
            try {
                String sql = "SELECT * FROM skill";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {
                    Skill skill = new Skill();
                    skill.setIdSkill(resultSet.getInt("idSkill"));
                    skill.setName(resultSet.getString("name"));
                    skill.setDescription(resultSet.getString("description"));
                    skill.setProfileId(resultSet.getInt("profileId"));
                    
                    skills.add(skill);
                }
                resultSet.close();
                preparedStatement.close();
                
            } catch (Exception e) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, "Ocurrio un error al obtener todas las habilidades", e);
            } finally {
                closeConnection(connection);
            }
        }
        return skills;
    }



    
}
