/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.designers.domain;

public class Skill {
 
    private int idSkill;
    private String name;
    private String description;

    public Skill() {
    }

    public Skill(int idSkill, String name, String description) {
        this.idSkill = idSkill;
        this.name = name;
        this.description = description;
    }

    public Skill(String name, String description) {
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return "Skill{" + "idSkill=" + idSkill + ", name=" + name + ", description=" + description + '}';
    }
    
    
    
    
}
