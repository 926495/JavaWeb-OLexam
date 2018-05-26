package com.sdut.onlinexam.service.admin;

import java.util.List;

import com.sdut.onlinexam.po.Course;
import com.sdut.onlinexam.po.TeacherCourse;
import com.sdut.onlinexam.vo.TeacherCourseView;

public interface ICourseService {
	
	/**
	 * 查询所有的关系映射表
	 * @return List
	 */
	public List<TeacherCourseView> findAll();

	/**
	 * @param courseKey
	 * @return
	 */
	public List<TeacherCourseView> findTeacherCourseByKey(String courseKey);
	/**
	 * 根据映射表的id查询某一条映射记录
	 * @param id
	 * @return TeacherCourseView
	 */
	public TeacherCourseView findTeacherCourseById(int id);
	
	public TeacherCourse findById(int id);
	
	/**
	 * 根据课程id号查询课程
	 * @param id
	 * @return Course
	 */
	public Course findCourseById(int id) ;
	
	/**
	 * 查询所有的课程
	 * @return List<Course>
	 */
	public List<Course> findAllCourses() ;
	
	/**
	 * 模糊查询
	 * @param name
	 * @return
	 */
	public List<Course> findAllCourses(String name);
	
	/**
	 * 先判断一下是否存在，如果不存在，直接插入操作，如果存在，则更新
	 * 
	 * @param teaCourID
	 *            映射ID号，自增长
	 * @param courseId
	 * @param teaId
	 * @param stuClassId
	 * @return
	 */
	public void modifyTeacherCourse(TeacherCourse tc);
	
	public void deleteCourse(int tcId);
	
	public void deleteTeacherCourse(int tcId);
	
	/**
	 * 添加课程信息
	 * @return
	 */
	public void addCourse(String courseName);
	
	/**
	 * 添加课程信息
	 * @return
	 */
	public void updateCourse(Course course);
	
	public void updateTeacherCourse(TeacherCourse tc);
	
	/**
	 * 添加排课信息，包括老师，班级，和课程。
	 * @return
	 */
	public void addSchedule(TeacherCourse tc);
	
	/**
	 * 根据当前的教师id查询属于这个教师的课程
	 * @param teaId
	 * @return
	 */
	public List<Course> findCoursesByTeacherId(int teaId);
}
