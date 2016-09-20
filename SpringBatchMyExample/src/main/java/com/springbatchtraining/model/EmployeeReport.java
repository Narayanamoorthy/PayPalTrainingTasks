package com.springbatchtraining.model;


import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "record")
public class EmployeeReport {
 int empid;
 String name;
 int location;
 String department;
 Date doj;

@XmlAttribute(name = "empid")
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
@XmlElement(name = "empname")
public String getName() {
	return name;
}
@XmlElement(name = "doj")

public Date getDoj() {
	return doj;
}
public void setDoj(Date salary) {
	this.doj = salary;
}
public void setName(String name) {
	this.name = name;
}
@XmlElement(name = "loc")
public int getLocation() {
	return location;
}
public void setLocation(int location) {
	this.location = location;
}

@XmlElement(name = "dep")
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
 
}
