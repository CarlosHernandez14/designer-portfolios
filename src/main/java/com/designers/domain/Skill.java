/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.designers.domain;

public class Skill {
 
    private int idSkill;
    private String name;
    private String description;
    private int profileId;

    public Skill() {
    }

    public Skill(int idSkill, String name, String description, int profileId) {
        this.idSkill = idSkill;
        this.name = name;
        this.description = description;
        this.profileId = profileId;
    }

    public Skill(String name, String description, int profileId) {
        this.name = name;
        this.description = description;
        this.profileId = profileId;
    }

    public int getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(int idSkill) {
        this.idSkill = idSkill;
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
    
    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    @Override
    public String toString() {
        return "Skill{" + "idSkill=" + idSkill + ", name=" + name + ", description=" + description + '}';
    }
    
}
