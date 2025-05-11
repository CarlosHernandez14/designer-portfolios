/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.designers.domain;

public class Image {

    private int idImage; 
    private byte[] file;
    private int projectId;

    public Image() {
    }

    public Image(int idImage, byte[] file, int projectId) {
        this.idImage = idImage;
        this.file = file;
        this.projectId = projectId;
    }

    public Image(byte[] file, int projectId) {
        this.file = file;
        this.projectId = projectId;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "Image{" + "idImage=" + idImage + ", file=" + file + ", projectId=" + projectId + '}';
    }
    
    
    
}
