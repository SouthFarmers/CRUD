package org.o7planning.restfulcrud.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)

public class Student {

	private String stuNo;
    private String stuName;
    private String position;
 
    // This default constructor is required if there are other constructors.
    public Student() {
 
    }
 
    public Student(String stuNo, String stuName, String position) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.position = position;
    }
 
    public String getStuNo() {
        return stuNo;
    }
 
    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }
 
    public String getStuName() {
        return stuName;
    }
 
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
 
    public String getPosition() {
        return position;
    }
 
    public void setPosition(String position) {
        this.position = position;
    }
    
}
