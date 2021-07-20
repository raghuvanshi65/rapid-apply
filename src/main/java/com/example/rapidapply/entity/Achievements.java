package com.example.rapidapply.entity;

import javax.persistence.*;

@Entity(name = "Achievements")
@Table(name = "achievements")
public class Achievements {

    @Id
    @Column(name = "ach_id")
    private String achId;

    @Column(name = "heading")
    private String heading;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public String getAchId() {
        return achId;
    }

    public void setAchId(String achId) {
        this.achId = achId;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
