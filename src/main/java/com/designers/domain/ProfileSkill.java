/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.designers.domain;

public class ProfileSkill {

    private int idProfileSkill;
    private int profileId; 
    private int skillId;

    public ProfileSkill() {
    }

    public ProfileSkill(int idProfileSkill, int profileId, int skillId) {
        this.idProfileSkill = idProfileSkill;
        this.profileId = profileId;
        this.skillId = skillId;
    }

    public ProfileSkill(int profileId, int skillId) {
        this.profileId = profileId;
        this.skillId = skillId;
    }

    public int getIdProfileSkill() {
        return idProfileSkill;
    }

    public void setIdProfileSkill(int idProfileSkill) {
        this.idProfileSkill = idProfileSkill;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    @Override
    public String toString() {
        return "ProfileSkill{" + "idProfileSkill=" + idProfileSkill + ", profileId=" + profileId + ", skillId=" + skillId + '}';
    }
    
        
    
}
