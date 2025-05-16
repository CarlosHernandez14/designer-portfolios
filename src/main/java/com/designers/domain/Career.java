/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.designers.domain;

public class Career {

    private int idCareer;
    private String name;

    public Career() {
    }

    public Career(int idCareer, String name) {
        this.idCareer = idCareer;
        this.name = name;
    }
    
    public Career(String name) {
        this.name = name;
    }

    public int getIdCareer() {
        return idCareer;
    }

    public void setIdCareer(int idCareer) {
        this.idCareer = idCareer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Career{" + "idCareer=" + idCareer + ", name=" + name + '}';
    }
    
    
}
