package com.sdut.onlinexam.service.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sdut.onlinexam.dao.admin.IStudentDao;
import com.sdut.onlinexam.dao.admin.StudentDao;
import com.sdut.onlinexam.po.Student;

public class StudentService implements IStudentService {

	IStudentDao sd = new StudentDao();

	@Override
	public void addStudent(Student s) {
		sd.addStudent(s);
	}

	@Override
	public void updateStudent(Student s) {
		sd.updateStudent(s);
	}

	@Override
	public Student findStudentById(int id) {
		return sd.findStudentById(id);
	}

	@Override
	public List<Map<String, Object>> findAll() {
		return sd.findAll();
	}

	@Override
	public void deleteStudent(int id) {
		sd.deleteStudentById(id);
	}

	@Override
	public List findStudentByTeacherId(int teaId) {
		return sd.findStudentByTeacherId(teaId);
	}

}
