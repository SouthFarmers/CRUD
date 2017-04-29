package org.o7planning.restfulcrud.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.o7planning.restfulcrud.model.Student;

public class MySQLAccess {
	
	private static final Map<String, Student> stuMap = new HashMap<String, Student>();
	 private Connection connect = null;
	        private Statement statement = null;
	        private PreparedStatement preparedStatement = null;
	        private ResultSet resultSet = null;

	        public Map<String, Student> readDataBase() throws Exception {
	                try {
	                        // This will load the MySQL driver, each DB has its own driver
	                        Class.forName("com.mysql.jdbc.Driver");
	                        // Setup the connection with the DB
	                        connect = DriverManager
	                                        .getConnection("jdbc:mysql://127.0.0.1:3306/student?"
	                                                        + "user=root&password=test");

	                        // Statements allow to issue SQL queries to the database
	                        statement = connect.createStatement();
	                        // Result set get the result of the SQL query
	                        resultSet = statement
	                                        .executeQuery("select * from studentinfo");
	                        
	                      
	                    	
	                    	while (resultSet.next()) {
		                        String id = resultSet.getString("id");
		                        String fname = resultSet.getString("firstname");
		                        String lname = resultSet.getString("lastname");
		                        
		                        Student stu = new Student(id, fname, lname);
		                        stuMap.put(stu.getStuNo(), stu);
		                }
	                    	return stuMap;
	

	                } catch (Exception e) {
	                        throw e;
	                } finally {
	                        close();
	                }

	        }

	        
	        public Student getStudentInfo(String sid) throws Exception {
                try {
                	Student stu = new Student();
                        // This will load the MySQL driver, each DB has its own driver
                        Class.forName("com.mysql.jdbc.Driver");
                        // Setup the connection with the DB
                        connect = DriverManager
                                        .getConnection("jdbc:mysql://127.0.0.1:3306/student?"
                                                        + "user=root&password=test");

                        // Statements allow to issue SQL queries to the database
                        statement = connect.createStatement();
                        // Result set get the result of the SQL query
                        resultSet = statement
                                        .executeQuery("select * from studentinfo where id="+sid);

                        if(resultSet.next()){
	                        String id = resultSet.getString("id");
	                        String fname = resultSet.getString("firstname");
	                        String lname = resultSet.getString("lastname");
	                        stu = new Student(id, fname, lname);
                        }
	                        
	                        

                    	return stu;


                } catch (Exception e) {
                        throw e;
                } finally {
                        close();
                }

        }
	        
	        public void deleteStudent(String sid) throws Exception {
                try {
                        // This will load the MySQL driver, each DB has its own driver
                        Class.forName("com.mysql.jdbc.Driver");
                        // Setup the connection with the DB
                        connect = DriverManager
                                        .getConnection("jdbc:mysql://127.0.0.1:3306/student?"
                                                        + "user=root&password=test");

                        // Statements allow to issue SQL queries to the database
                        statement = connect.createStatement();
                        // Result set get the result of the SQL query
                        resultSet = statement
                                        .executeQuery("delete from studentinfo where id="+sid);


                } catch (Exception e) {
                        throw e;
                } finally {
                        close();
                }

        }
	        
	        private void close() {
	                try {
	                        if (resultSet != null) {
	                                resultSet.close();
	                        }

	                        if (statement != null) {
	                                statement.close();
	                        }

	                        if (connect != null) {
	                                connect.close();
	                        }
	                } catch (Exception e) {

	                }
	        }

	}
