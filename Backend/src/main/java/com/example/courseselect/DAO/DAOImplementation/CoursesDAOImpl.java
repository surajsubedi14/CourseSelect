package com.example.courseselect.DAO.DAOImplementation;

import com.example.courseselect.Bean.Courses;
import com.example.courseselect.DAO.CoursesDAO;
import com.example.courseselect.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class CoursesDAOImpl implements CoursesDAO {

    @Override
    public List<Courses> getCourseList() {
        try (Session session = HibernateSessionUtil.getSession()){
            List<Courses> CourseList = new ArrayList<>();
            for (final Object d : session.createQuery(" from Courses ").list()) {
                CourseList.add((Courses) d);
            }
            return CourseList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }
}