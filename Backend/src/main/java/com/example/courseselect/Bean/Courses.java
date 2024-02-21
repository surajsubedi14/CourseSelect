package com.example.courseselect.Bean;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "Courses")
public class Courses {
    @Id
    @Column(name ="course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseID;

    @Column(name="course_code",nullable = false,unique = true)
    private String courseCode;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="year",nullable = false)
    private int year;

    @Column(name="term",nullable = false)
    private int term;

    @Column(name="credit",nullable = false)
    private int credit;

    @Column(name="capacity",nullable = false)
    private int capacity;

    @Column(name="faculty")
    private String faculty;

   // @OneToMany(mappedBy = "courseID", cascade = CascadeType.ALL)
    //private List<CourseDomain> courseDomainList;

    //@OneToMany(mappedBy = "courseID", cascade = CascadeType.ALL)
    //private List<CoursePrerequisites> courseList;

    //@OneToMany(mappedBy = "prerequisites", cascade = CascadeType.ALL)
    //private List<CoursePrerequisites> coursePreqList;


    public Courses() {
    }

    public Courses(int courseID, String courseCode, String name, String description, int year, int term, int credit,int capacity, String faculty) {
        this.courseID = courseID;
        this.courseCode = courseCode;
        this.name = name;
        this.description = description;
        this.year = year;
        this.term = term;
        this.credit = credit;
        this.capacity = capacity;
        this.faculty = faculty;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }


    @Override
    public String toString() {
        return "Courses{" +
                "courseID=" + courseID +
                ", courseCode='" + courseCode + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", term=" + term +
                ", credit=" + credit +
                ", capacity=" + capacity +
                ", faculty='" + faculty + '\'' +
                '}';
    }
}
