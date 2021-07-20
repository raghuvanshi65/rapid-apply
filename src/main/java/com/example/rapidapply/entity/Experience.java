package com.example.rapidapply.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "Experience")
@Table(name = "experience")
public class Experience {

    @Id
    @Column(name = "exp_id")
    private String experienceId;

    @Column(name = "org_name")
    private String orgName;

    @Column(name = "description")
    private String description;

    @Column(name = "work_profile")
    private String workProfile;

    @Column(name = "certificate_link")
    private String certificateLink;

    @Column(name = "product_link")
    private String productLink;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "current")
    private Character current;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public String getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(String experienceId) {
        this.experienceId = experienceId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWorkProfile() {
        return workProfile;
    }

    public void setWorkProfile(String workProfile) {
        this.workProfile = workProfile;
    }

    public String getProductLink() {
        return productLink;
    }

    public void setProductLink(String productLink) {
        this.productLink = productLink;
    }

    public String getCertificateLink() {
        return certificateLink;
    }

    public void setCertificateLink(String certificateLink) {
        this.certificateLink = certificateLink;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Character getCurrent() {
        return current;
    }

    public void setCurrent(Character current) {
        this.current = current;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
