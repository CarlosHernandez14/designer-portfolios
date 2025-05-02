/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.designers.domain;

/**
 *
 * @author carlo
 */
public class Profile {
    
    private int idProfile;
    private String name;
    private String lastname;
    private String phone;
    private int userId;
    private int careerId;

    public Profile() {
    }
    
    public Profile(int idProfile, String name, String lastname, String phone, int userId, int careerId) {
        this.idProfile = idProfile;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.userId = userId;
        this.careerId = careerId;
    }

    public int getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCareerId() {
        return careerId;
    }

    public void setCareerId(int careerId) {
        this.careerId = careerId;
    }

    @Override
    public String toString() {
        return "Profile{" + "idProfile=" + idProfile + ", name=" + name + ", lastname=" + lastname + ", phone=" + phone + ", userId=" + userId + ", careerId=" + careerId + '}';
    }
    
    
}
