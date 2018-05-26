package com.sdut.onlinexam.service.admin;

import java.util.List;

import com.sdut.onlinexam.dao.admin.CourseDao;
import com.sdut.onlinexam.dao.admin.ICourseDao;
import com.sdut.onlinexam.po.Course;
import com.sdut.onlinexam.po.TeacherCourse;
import com.sdut.onlinexam.vo.TeacherCourseView;

public class CourseService implements ICourseService{
	private ICourseDao cd = new CourseDao();


	@Override
	public List<TeacherCourseView> findAll() {
		return cd.findAllTeaCourInfo();
	}

	@Override
	public List<TeacherCourseView> findTeacherCourseByKey(String courseKey) {
		return cd.findTeaCourInfoByCourseKey(courseKey);
	}
	
	@Override
	public TeacherCourseView findTeacherCourseById(int id) {
		return cd.findTeaCourInfoById(id);
	}

	@Override
	public Course findCourseById(int id) {
		return cd.findCourseById(id);
	}

	@Override
	public List<Course> findAllCourses() {
		return cd.findAllCourses();
	}

	@Override
	public List<Course> findAllCourses(String name) {
		return cd.findAllCoursesByName(name);
	}

	@Override
	public void modifyTeacherCourse(TeacherCourse tc) {
		// TODO 自动生成的方法存根
		
	}



	@Override
	public void deleteTeacherCourse(int tcId) {
		cd.deleteTeacherTourse(tcId);
	}

	@Override
	public void addCourse(String courseName) {
		cd.addCourse(courseName);
	}

	@Override
	public void updateCourse(Course course) {
		cd.updateCourse(course);
	}

	@Override
	public void addSchedule(TeacherCourse tc) {
		cd.addTeacherCourse(tc);
	}

	@Override
	public List<Course> findCoursesByTeacherId(int teaId) {
		return cd.findCoursesByTeacherId(teaId);
	}

	@Override
	public void deleteCourse(int tcId) {
		cd.deleteTourse(tcId);
	}

	@Override
	public void updateTeacherCourse(TeacherCourse tc) {
		cd.updateTeacherCourse(tc);;
	}

	@Override
	public TeacherCourse findById(int id) {
		
		return cd.findTeacherCourseById(id);
	}


}
