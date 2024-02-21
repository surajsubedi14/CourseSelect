package com.example.courseselect.DAO;

import com.example.courseselect.Bean.CoursePrerequisites;
import com.example.courseselect.Bean.Courses;

import java.util.List;

public interface CoursePrerequisitesDAO {
    List<CoursePrerequisites> getCoursePrerequisitesList();
    List<Courses> getCourseByID (int cID);
    List<CoursePrerequisites> getPreqByIDs(List<Courses>cid);

}