package com.example.courseselect.Controller;

import com.example.courseselect.Bean.CourseDomain;
import com.example.courseselect.Bean.CoursePrerequisites;
import com.example.courseselect.Bean.Courses;
import com.example.courseselect.DAO.CourseDomainDAO;
import com.example.courseselect.DAO.CoursePrerequisitesDAO;
import com.example.courseselect.DAO.DAOImplementation.CourseDomainDAOImpl;
import com.example.courseselect.DAO.DAOImplementation.CoursePrerequisitesDAOImpl;
import com.example.courseselect.HelloApplication;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/cdomain")
public class CourseDomainController extends HelloApplication {
    CourseDomainDAO CourDoDAO = new CourseDomainDAOImpl();
    CoursePrerequisitesDAO Courpreq = new CoursePrerequisitesDAOImpl();

    @GET
    @Path("/get_all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all_Domains() {
        List<CourseDomain> dom = CourDoDAO.getCourseDomain();
        System.out.printf("course domain are downloaded");
        return Response.status(200).entity(dom).build();
    }

    @GET
    @Path("/get/{d_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response get_Course(@PathParam("d_id") int id) {
        System.out.println(id);
        List<Courses> cour = this.CourDoDAO.getCourseByID(id);
        System.out.println("downloaded necessary tables");

        return Response.status(200).entity(cour).build();
    }

    @GET
    @Path("/get/prereq/{d_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response get_prereq(@PathParam("d_id") int id) {
        System.out.println(id);
        List<Courses> cId = this.CourDoDAO.getCourseByID(id);
        List<CoursePrerequisites> preq = this.Courpreq.getPreqByIDs(cId);
        System.out.println("downloaded necessary tables");

        return Response.status(200).entity(preq).build();
    }
}

