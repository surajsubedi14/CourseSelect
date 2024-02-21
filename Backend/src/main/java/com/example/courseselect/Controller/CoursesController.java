package com.example.courseselect.Controller;

import com.example.courseselect.Bean.Courses;
import com.example.courseselect.DAO.CoursesDAO;
import com.example.courseselect.DAO.DAOImplementation.CoursesDAOImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/Courses")
public class CoursesController {
    CoursesDAO CourDAO = new CoursesDAOImpl();

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all_courses(){
        List<Courses> course = CourDAO.getCourseList();
        System.out.printf("courses are downloaded");
        return Response.status(200).entity(course).build();
    }

    @POST
    @Path("/post")
    public Response post_courses(String values)
    {
            System.out.println(values);

        //for(int i=0; i<values.size();i++) {
          //  System.out.println( values[i].toString());
        //}
        return Response.status(200).entity("Success").build();
    }


//    @GET
//    @Path("/get_employees/{dept_id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response get_department(@PathParam("dept_id") int d_id){
//        System.out.println(d_id);
//
//        List<Employee> employees = deptDAO.employeeListInDepartment(d_id);
//
//        return Response.status(200).entity(employees).build();
//    }
}
