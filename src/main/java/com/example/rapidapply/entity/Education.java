package com.example.rapidapply.entity;

import com.example.rapidapply.helpers.Grading;

import javax.persistence.*;
import java.time.Year;

@Entity(name = "Education")
@Table(name = "education")
public class Education {

    @Id
    @Column(name = "education_id")
    private String educationId;

    @Column(name = "institute_name")
    private String institueName;

    @Column(name = "academic_level")
    private String academicLevel;

    @Column(name = "grading")
    @Enumerated(EnumType.ORDINAL)
    private Grading grading;

    @Column(name = "marks_grade")
    private String marksGrade;

    @Column(name = "starting_year")
    private Year startingYear;

    @Column(name = "ending_year")
    private Year endingYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public String getEducationId() {
        return educationId;
    }

    public void setEducationId(String educationId) {
        this.educationId = educationId;
    }

    public String getInstitueName() {
        return institueName;
    }

    public void setInstitueName(String institueName) {
        this.institueName = institueName;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(String academicLevel) {
        this.academicLevel = academicLevel;
    }

    public Grading getGrading() {
        return grading;
    }

    public void setGrading(Grading grading) {
        this.grading = grading;
    }

    public String getMarksGrade() {
        return marksGrade;
    }

    public void setMarksGrade(String marksGrade) {
        this.marksGrade = marksGrade;
    }

    public Year getStartingYear() {
        return startingYear;
    }

    public void setStartingYear(Year startingYear) {
        this.startingYear = startingYear;
    }

    public Year getEndingYear() {
        return endingYear;
    }

    public void setEndingYear(Year endingYear) {
        this.endingYear = endingYear;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
