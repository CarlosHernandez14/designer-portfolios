/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.designers.domain;

import java.sql.Date;

public class Resume {

    private int idResume;
    private int profileId; 
    private String fileUrl;
    private Date createdAt;

    public Resume() {
    }

    public Resume(int idResume, int profileId, String fileUrl, Date createdAt) {
        this.idResume = idResume;
        this.profileId = profileId;
        this.fileUrl = fileUrl;
        this.createdAt = createdAt;
    }

    public Resume(int profileId, String fileUrl, Date createdAt) {
        this.profileId = profileId;
        this.fileUrl = fileUrl;
        this.createdAt = createdAt;
    }

    public int getIdResume() {
        return idResume;
    }

    public void setIdResume(int idResume) {
        this.idResume = idResume;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Resume{" + "idResume=" + idResume + ", profileId=" + profileId + ", fileUrl=" + fileUrl + ", createdAt=" + createdAt + '}';
    }
    
    
    
    
}
