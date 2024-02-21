package com.example.courseselect.Controller;

import com.example.courseselect.Bean.CoursePrerequisites;
import com.example.courseselect.DAO.CoursePrerequisitesDAO;
import com.example.courseselect.DAO.DAOImplementation.CoursePrerequisitesDAOImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/prerequire")
public class CoursePrerequisitesController {
    CoursePrerequisitesDAO cpDAO = new CoursePrerequisitesDAOImpl();



    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_prerequisites(){
        List<CoursePrerequisites> preq =cpDAO.getCoursePrerequisitesList();
        return Response.status(200).entity(preq).build();
    }

}
