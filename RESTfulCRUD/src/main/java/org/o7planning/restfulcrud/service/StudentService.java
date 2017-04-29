package org.o7planning.restfulcrud.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.o7planning.restfulcrud.doa.StudentDAO;
import org.o7planning.restfulcrud.model.Student;


 
 
@Path("/students")

public class StudentService {

	// URI:
    // /contextPath/servletPath/students
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Student> getStudents_JSON() throws Exception{
        List<Student> listOfStudents = StudentDAO.getAllStudents();
        return listOfStudents;
    }
 
    // URI:
    // /contextPath/servletPath/students/{stuNo}
    @GET
    @Path("/{stuNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Student getStudent(@PathParam("stuNo") String StuNo) throws Exception{
        return StudentDAO.getStudent(StuNo);
    }
 
    // URI:
    // /contextPath/servletPath/students
    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Student addStudent(Student stu) {
        return StudentDAO.addStudent(stu);
    }
 
    // URI:
    // /contextPath/servletPath/students
    @PUT
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Student updateStudent(Student stu) {
        return StudentDAO.updateStudent(stu);
    }
 
    @DELETE
    @Path("/{stuNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void deleteStudent(@PathParam("stuNo") String stuNo) throws Exception{
    	StudentDAO.deleteStudent(stuNo);
    }
    
}

