package com.example.rapidapply.entity;

import javax.persistence.*;

@Entity(name = "PublicProfile")
@Table(name = "public_profiles")
public class PublicProfile {

    @Id
    @Column(name = "public_profile_id")
    private String publicProfileId;

    @Column(name = "platform_name")
    private String platformName;

    @Column(name = "profile_link")
    private String platformLink;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public String getPublicProfileId() {
        return publicProfileId;
    }

    public void setPublicProfileId(String publicProfileId) {
        this.publicProfileId = publicProfileId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getPlatformLink() {
        return platformLink;
    }

    public void setPlatformLink(String platformLink) {
        this.platformLink = platformLink;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
