/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.designers.domain;

import java.sql.Date;

public class Project {

    private int idProject; 
    private int profileId; 
    private String name;
    private String description;
    private Date startDate;
    private Date finishDate;
    private boolean currentProject;

    public Project() {
    }

    public Project(int idProject, int profileId, String name, String description, Date startDate, Date finishDate, boolean currentProject) {
        this.idProject = idProject;
        this.profileId = profileId;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.currentProject = currentProject;
    }

    public Project(int profileId, String name, String description, Date startDate, Date finishDate, boolean currentProject) {
        this.profileId = profileId;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.currentProject = currentProject;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public boolean isCurrentProject() {
        return currentProject;
    }

    public void setCurrentProject(boolean currentProject) {
        this.currentProject = currentProject;
    }

    @Override
    public String toString() {
        return "Project{" + "idProject=" + idProject + ", profileId=" + profileId + ", name=" + name + ", description=" + description + ", startDate=" + startDate + ", finishDate=" + finishDate + ", currentProject=" + currentProject + '}';
    }
    
    
    
}
