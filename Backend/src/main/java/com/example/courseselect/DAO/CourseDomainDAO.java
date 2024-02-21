package com.example.courseselect.DAO;

import com.example.courseselect.Bean.CourseDomain;
import com.example.courseselect.Bean.Courses;

import java.util.List;

public interface CourseDomainDAO {
    List<Courses> getCourseByID (int dID);
    List<CourseDomain> getCourseDomain();
    List<Integer> getCourseIdByID(int id);
}