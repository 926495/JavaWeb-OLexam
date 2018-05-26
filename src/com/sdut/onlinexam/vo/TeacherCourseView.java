package com.sdut.onlinexam.vo;

/**
 * 教师课程信息视图类
 * 
 * @author Yl-Lin
 *
 */

public class TeacherCourseView {
	private int tcId;
	private int teacherId;
	private String teacherName;
	private int stuclassId;
	private String stuclassName;
	private String departmentName;
	private int courseId;
	private String courseName;

	public int getTcId() {
		return tcId;
	}

	public void setTcId(int tcId) {
		this.tcId = tcId;
	}
	
	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public int getStuclassId() {
		return stuclassId;
	}

	public void setStuclassId(int stuclassId) {
		this.stuclassId = stuclassId;
	}

	public String getStuclassName() {
		return stuclassName;
	}

	public void setStuclassName(String stuclassName) {
		this.stuclassName = stuclassName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
