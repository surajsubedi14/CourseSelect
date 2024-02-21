package com.example.courseselect.DAO.DAOImplementation;

import com.example.courseselect.Bean.CoursePrerequisites;
import com.example.courseselect.Bean.Courses;
import com.example.courseselect.DAO.CoursePrerequisitesDAO;
import com.example.courseselect.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class CoursePrerequisitesDAOImpl implements CoursePrerequisitesDAO {
    @Override
    public List<Courses> getCourseByID(int cID) {
        try (Session session = HibernateSessionUtil.getSession()){
            List<Courses> CoursePreqList = new ArrayList<>();

            for (final Object p : session.createQuery("from Courses where courseID in (select preq from CoursePrerequisites where courseID = :id ) ").setParameter("id",cID).list()) {
                CoursePreqList.add((Courses) p);
            }
            return CoursePreqList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }


    @Override
    public List<CoursePrerequisites> getCoursePrerequisitesList() {
        try (Session session = HibernateSessionUtil.getSession()){
            List<CoursePrerequisites> preqList = new ArrayList<>();
            for (final Object p : session.createQuery("from CoursePrerequisites ").list()) {
                preqList.add((CoursePrerequisites) p);
            }
            return preqList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }
    @Override
    public List<CoursePrerequisites> getPreqByIDs(List<Courses> cID) {
        try (Session session = HibernateSessionUtil.getSession()){
            List<CoursePrerequisites> CoursePreqList = new ArrayList<>();

            for (final Object p : session.createQuery("from CoursePrerequisites where course in :id ").setParameter("id",cID).list()) {
                CoursePreqList.add((CoursePrerequisites) p);
            }
            return CoursePreqList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

}