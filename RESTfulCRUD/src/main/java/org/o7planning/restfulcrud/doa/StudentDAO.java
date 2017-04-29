package org.o7planning.restfulcrud.doa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.o7planning.restfulcrud.data.MySQLAccess;
import org.o7planning.restfulcrud.model.Student;



public class StudentDAO {

	private static MySQLAccess dao = new MySQLAccess();

 
    public static Student getStudent(String stuNo) throws Exception{
        return dao.getStudentInfo(stuNo);
    }
 
    public static Student addStudent(Student stu) {
        return stu;
    }
 
    public static Student updateStudent(Student stu) {
        return stu;
    }
 
    public static void deleteStudent(String stuNo) throws Exception{
    	dao.deleteStudent(stuNo);
    }
 
    public static List<Student> getAllStudents()  throws Exception{
    	Map<String, Student> studentdataMap =  dao.readDataBase();
        
        Collection<Student> c = studentdataMap.values();
        List<Student> list = new ArrayList<Student>();
        list.addAll(c);
        return list;
    }
     
    List<Student> list;
    
}
