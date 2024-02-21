package com.example.courseselect.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "Course_Prerequisites")
public class CoursePrerequisites {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @ManyToOne
    @JoinColumn(name="courseID")
    private Courses course;

    @ManyToOne
    @JoinColumn(name="prerequisites")
    private Courses preq;

    @Column(name="description")
    private String description;

    public CoursePrerequisites(){
    }

    public CoursePrerequisites(int ID,Courses course , Courses preq , String description) {
        this.ID = ID;
        this.course = course;
        this.preq = preq;
        this.description= description;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Courses getCourseID() {
        return course;
    }
    public void setCourseID(Courses course) {
        this.course = course;
    }

    public Courses getPreq(){
        return preq;
    }
    public void setPreq(Courses preq) {
        this.preq = preq;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // to string to print object as a string otherwise it returns object Hashcode
    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", courseID=" + course +
                ", prerequisites=" + preq +
                ", description='" + description + '\'' +
                '}';
    }
}
