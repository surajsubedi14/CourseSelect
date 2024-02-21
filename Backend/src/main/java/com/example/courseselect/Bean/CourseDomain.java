package com.example.courseselect.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "CourseDomain")
public class CourseDomain {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "domainID")
    private int domainID;

    @ManyToOne
    @JoinColumn(name="courseID")
    private Courses course;

    public CourseDomain(){
    }

    public CourseDomain(int ID, int domainID, Courses course) {
        this.ID = ID;
        this.domainID = domainID;
        this.course = course;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDomainID() {
        return domainID;
    }
    public void setDomainID(int domainID) {
        this.domainID = domainID;
    }
    public Courses getCourse(){
        return course;
    }
    public void setCourse(Courses course) {
        this.course = course;
    }

    // to string to print object as a string otherwise it returns object Hashcode
    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", domainID=" + domainID +
                ", courseID=" + course +
                '}';
    }
}
