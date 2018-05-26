package com.sdut.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.sdut.onlinexam.po.Student;

public interface IStudentService { 
	public void addStudent(Student s);
	public void updateStudent(Student s);
	public Student findStudentById(int id);
	public List<Map<String,Object>> findAll();
	public void deleteStudent(int id);
	public List findStudentByTeacherId(int teaId);
}
