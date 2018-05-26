package com.sdut.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.sdut.onlinexam.dao.admin.ITeacherDao;
import com.sdut.onlinexam.dao.admin.TeacherDao;
import com.sdut.onlinexam.po.Teacher;

public class TeacherService implements ITeacherService{
	private ITeacherDao td=new TeacherDao();

	@Override
	public List<Teacher> findTeachers(String name) {
		return td.findAllTeacherByInfo(name);
	}

	@Override
	public void addTeacher(Teacher teacher) {
		td.addTeacher(teacher);
	}

	@Override
	public void updateTeacher(Teacher teacher, int oldid) {
		td.updateTeacher(teacher, oldid);
	}

	@Override
	public Map<String, Object> findTeacherInfo(int id) {
		
		return td.findTeacherInfo(id);
	}

	@Override
	public List<Map<String, Object>> findClassesByTeacherId(int teacherId){
		return td.findClassesByTeacherId(teacherId);
	}

	@Override
	public void deleteTeacher(int id) {
		td.deleteStuClassById(id);
	}

	@Override
	public List<Map<String, Object>> findAllTeacher() {
		
		return td.findAllTeacher();
	}

}
