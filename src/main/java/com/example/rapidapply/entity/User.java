package com.example.rapidapply.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "User")
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "email")
    private String email;

    @Column(name = "user_password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @OneToOne(mappedBy = "user" ,cascade = CascadeType.ALL ,
                fetch = FetchType.LAZY , optional = true)
    private Address address;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Education> educationList;


    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL ,
            orphanRemoval = true
    )
    private List<PublicProfile> publicProfileList;

    @OneToMany(
            mappedBy = "user" ,
            cascade = CascadeType.ALL ,
            orphanRemoval = true
    )
    private List<Skills> skillsList;


    @OneToMany(
            mappedBy = "user" ,
            cascade = CascadeType.ALL ,
            orphanRemoval = true
    )
    private List<Projects> projectsList;

    @OneToMany(
            mappedBy = "user" ,
            cascade = CascadeType.ALL ,
            orphanRemoval = true
    )
    private List<Experience> experienceList;

    @OneToMany(
            mappedBy = "user" ,
            cascade = CascadeType.ALL ,
            orphanRemoval = true
    )
    private List<Achievements> achievementsList;

    public User() {
        this.address = null;
        this.educationList = new ArrayList<>();
        this.publicProfileList = new ArrayList<>();
        this.skillsList = new ArrayList<>();
        this.projectsList = new ArrayList<>();
        this.experienceList = new ArrayList<>();
        this.achievementsList = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public void addEducation(Education education){
        educationList.add(education);
        education.setUser(this);
    }

    public void removeEducation(Education education){
        educationList.remove(education);
        education.setUser(null);
    }

    public void setPublicProfileList(List<PublicProfile> publicProfileList) {
        this.publicProfileList = publicProfileList;
    }

    public List<PublicProfile> getPublicProfileList() {
        return publicProfileList;
    }

    public void addPublicProfile(PublicProfile publicProfile){
        publicProfileList.add(publicProfile);
        publicProfile.setUser(this);
    }

    public void removePublicProfile(PublicProfile publicProfile){
        publicProfileList.remove(publicProfile);
        publicProfile.setUser(null);
    }

    public List<Skills> getSkillsList() {
        return skillsList;
    }

    public void setSkillsList(List<Skills> skillsList) {
        this.skillsList = skillsList;
    }

    public void addSkills(Skills skill){
        skillsList.add(skill);
        skill.setUser(this);
    }

    public void removeSkills(Skills skill){
        skillsList.remove(skill);
        skill.setUser(null);
    }

    public void addProjects(Projects projects){
        projectsList.add(projects);
        projects.setUser(this);
    }

    public void removeProjects(Projects projects){
        projectsList.remove(projects);
        projects.setUser(this);
    }

    public void addExperience(Experience experience){
        experienceList.add(experience);
        experience.setUser(this);
    }

    public void removeExperience(Experience experience){
        experienceList.remove(experience);
        experience.setUser(this);
    }

    public void addAchievements(Achievements achievements){
        achievementsList.add(achievements);
        achievements.setUser(this);
    }

    public void removeAchievements(Achievements achievements){
        achievementsList.remove(achievements);
        achievements.setUser(this);
    }
}
