package com.example.rapidapply.entity;

import javax.persistence.*;

@Entity(name = "Skills")
@Table(name = "skills")
public class Skills {

    @Id
    @Column(name = "skill_id")
    private String skillId;

    @Column(name = "skill_type")
    private String skillType;

    @Column(name = "skills_subset")
    private String skillSubset;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    public String getSkillSubset() {
        return skillSubset;
    }

    public void setSkillSubset(String skillSubset) {
        this.skillSubset = skillSubset;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
