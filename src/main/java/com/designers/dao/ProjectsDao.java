/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.designers.dao;

import com.designers.domain.Image;
import com.designers.domain.Project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectsDao {

    public static List<Project> getAllProjects() {
        Connection conn = Dao.getConnection();
        
        if (conn == null) {
            return new ArrayList<>();
        }

        List<Project> projects = new ArrayList<>();
        String sql = "SELECT * FROM project";

        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Project project = new Project();
                project.setIdProject(rs.getInt("idProject"));
                project.setProfileId(rs.getInt("profileId"));
                project.setName(rs.getString("name"));
                project.setDescription(rs.getString("description"));
                project.setStartDate(rs.getDate("start_date"));
                project.setFinishDate(rs.getDate("finish_date"));
                project.setCurrentProject(rs.getBoolean("isCurrentProject"));
                projects.add(project);
            }

            return projects;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Dao.closeConnection(conn);
        }

        return new ArrayList<>();
    }

    // Function to get a project by its ID
    public static Project getProjectById(int id) {
        Connection conn = Dao.getConnection();
        
        if (conn == null) {
            return null;
        }

        String sql = "SELECT * FROM project WHERE idProject = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Project project = new Project();
                project.setIdProject(rs.getInt("idProject"));
                project.setProfileId(rs.getInt("profileId"));
                project.setName(rs.getString("name"));
                project.setDescription(rs.getString("description"));
                project.setStartDate(rs.getDate("start_date"));
                project.setFinishDate(rs.getDate("finish_date"));
                project.setCurrentProject(rs.getBoolean("isCurrentProject"));
                return project;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Dao.closeConnection(conn);
        }

        return null;
    }

    // Function to insert a new project
    // Returns the ID of the inserted project
    public static int insertProject(Project project) {
        Connection conn = Dao.getConnection();
        
        if (conn == null) {
            return -1;
        }

        String sql = "INSERT INTO project (profileId, name, description, start_date, finish_date, isCurrentProject) VALUES (?, ?, ?, ?, ?, ?)";
        int generatedId = -1;

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, project.getProfileId());
            pstmt.setString(2, project.getName());
            pstmt.setString(3, project.getDescription());
            pstmt.setDate(4, new java.sql.Date(project.getStartDate().getTime()));
            pstmt.setDate(5, new java.sql.Date(project.getFinishDate().getTime()));
            pstmt.setInt(6, project.isCurrentProject() ? 1 : 0);
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Dao.closeConnection(conn);
        }
        return generatedId;
    }

    // Function to update a project
    public static boolean updateProject(int idProject, Project project) {
        Connection conn = Dao.getConnection();
        
        if (conn == null) {
            return false;
        }

        String sql = "UPDATE project SET profileId = ?, name = ?, description = ?, start_date = ?, finish_date = ?, isCurrentProject = ? WHERE idProject = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, project.getProfileId());
            pstmt.setString(2, project.getName());
            pstmt.setString(3, project.getDescription());
            pstmt.setDate(4, new java.sql.Date(project.getStartDate().getTime()));
            pstmt.setDate(5, new java.sql.Date(project.getFinishDate().getTime()));
            pstmt.setInt(6, project.isCurrentProject() ? 1 : 0);
            pstmt.setInt(7, idProject);
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Dao.closeConnection(conn);
        }
        return false;
    }

    // Function to delete a project
    public static boolean deleteProject(int idProject) {
        Connection conn = Dao.getConnection();
        
        if (conn == null) {
            return false;
        }

        String sql = "DELETE FROM project WHERE idProject = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idProject);
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Dao.closeConnection(conn);
        }
        return false;
    }

    // Method to get all projects by profile ID
    public static List<Project> getProjectsByProfileId(int profileId) {
        Connection conn = Dao.getConnection();
        
        if (conn == null) {
            return new ArrayList<>();
        }

        List<Project> projects = new ArrayList<>();
        String sql = "SELECT * FROM project WHERE profileId = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, profileId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Project project = new Project();
                project.setIdProject(rs.getInt("idProject"));
                project.setProfileId(rs.getInt("profileId"));
                project.setName(rs.getString("name"));
                project.setDescription(rs.getString("description"));
                project.setStartDate(rs.getDate("start_date"));
                project.setFinishDate(rs.getDate("finish_date"));
                project.setCurrentProject(rs.getInt("isCurrentProject") == 1);
                projects.add(project);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Dao.closeConnection(conn);
        }
        return projects;
    }

    ///////////////////////////////////////////////////////////////////////////
    /// Functions to manage images table
    
    // Function to get images
    public static List<Image> getImagesByProjectId(int projectId) {
        Connection conn = Dao.getConnection();
        
        if (conn == null) {
            return new ArrayList<>();
        }

        List<Image> images = new ArrayList<>();
        String sql = "SELECT * FROM image WHERE projectId = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, projectId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Image image = new Image();
                image.setIdImage(rs.getInt("idImage"));
                image.setFile(rs.getBytes("file"));
                image.setProjectId(rs.getInt("projectId"));
                images.add(image);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Dao.closeConnection(conn);
        }

        return images;
    }

    // Function to insert an image
    public static boolean insertImage(Image image) {
        Connection conn = Dao.getConnection();
        
        if (conn == null) {
            return false;
        }

        String sql = "INSERT INTO image (file, projectId) VALUES (?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setBytes(1, image.getFile());
            pstmt.setInt(2, image.getProjectId());
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Dao.closeConnection(conn);
        }

        return false;
    }

    // Function to update an image
    public static boolean updateImage(int idImage, Image image) {
        Connection conn = Dao.getConnection();
        
        if (conn == null) {
            return false;
        }

        String sql = "UPDATE image SET file = ?, projectId = ? WHERE idImage = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setBytes(1, image.getFile());
            pstmt.setInt(2, image.getProjectId());
            pstmt.setInt(3, idImage);
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Dao.closeConnection(conn);
        }
        return false;
    }

    // Function to delete an image
    public static boolean deleteImage(int idImage) {
        Connection conn = Dao.getConnection();
        
        if (conn == null) {
            return false;
        }

        String sql = "DELETE FROM image WHERE idImage = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idImage);
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Dao.closeConnection(conn);
        }
        return false;
    }

    // Save a bunch of images
    public static boolean saveImages(List<Image> images) {
        Connection conn = Dao.getConnection();
        
        if (conn == null) {
            return false;
        }

        String sql = "INSERT INTO image (file, projectId) VALUES (?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (Image image : images) {
                pstmt.setBytes(1, image.getFile());
                pstmt.setInt(2, image.getProjectId());
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Dao.closeConnection(conn);
        }
        return false;
    }

    // Get the first image of each project by profile ID
    public static List<Image> getFirstImageByProfileId(int profileId) {
        Connection conn = Dao.getConnection();
        
        if (conn == null) {
            return new ArrayList<>();
        }

        List<Image> images = new ArrayList<>();
        String sql =
            "SELECT i.idImage, i.file, i.projectId " +
            "FROM image i " +
            "JOIN ( " +
            "  SELECT projectId, MIN(idImage) AS firstImageId " +
            "  FROM image " +
            "  GROUP BY projectId " +
            ") AS firsts " +
            "  ON i.projectId = firsts.projectId " +
            " AND i.idImage   = firsts.firstImageId " +
            "JOIN project p " +
            "  ON p.idProject = i.projectId " +
            "WHERE p.profileId = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, profileId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Image image = new Image();
                image.setIdImage(rs.getInt("idImage"));
                image.setFile(rs.getBytes("file"));
                image.setProjectId(rs.getInt("projectId"));
                images.add(image);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Dao.closeConnection(conn);
        }

        return images;
    }
    
}
