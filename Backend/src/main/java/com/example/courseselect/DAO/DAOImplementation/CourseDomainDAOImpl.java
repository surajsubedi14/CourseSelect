package com.example.courseselect.DAO.DAOImplementation;

import com.example.courseselect.Bean.CourseDomain;
import com.example.courseselect.Bean.Courses;
import com.example.courseselect.DAO.CourseDomainDAO;
import com.example.courseselect.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class CourseDomainDAOImpl implements CourseDomainDAO {
    @Override
    public List<Courses> getCourseByID(int dID) {
        try (Session session = HibernateSessionUtil.getSession()){
            List<Courses> CourseDomainList = new ArrayList<>();

            for (final Object p : session.createQuery("from Courses where courseID in (select course from CourseDomain where domainID = :id ) ").setParameter("id",dID ).list()) {
                CourseDomainList.add((Courses) p);
            }
            return CourseDomainList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }


    @Override
    public List<CourseDomain> getCourseDomain() {
        try (Session session = HibernateSessionUtil.getSession()){
            List<CourseDomain> CourseDomainList = new ArrayList<>();
            for (final Object p : session.createQuery("from CourseDomain ").list()) {
                CourseDomainList.add((CourseDomain) p);
            }
            return CourseDomainList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public List<Integer> getCourseIdByID(int id) {
        try (Session session = HibernateSessionUtil.getSession()){
            List<Integer> CourseidList = new ArrayList<>();

            for (final Object c : session.createQuery("select course from CourseDomain where domainID = :id  ").setParameter("id",id).list()) {
                CourseidList.add(((Courses) c).getCourseID());
            }
            return CourseidList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }


}