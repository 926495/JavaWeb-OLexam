package com.sdut.onlinexam.po;

import java.util.Date;

public class Paper {
	private int id;
	private int testId;
	private int courseId;
	private String time;
	private double score;
	private String wrongQueId;
	private String wrongAns;
	private int studentId;
	private Date createDate;
	public String getWrongQueId() {
		return wrongQueId;
	}
	public void setWrongQueId(String wrongQueId) {
		this.wrongQueId = wrongQueId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getWrongAns() {
		return wrongAns;
	}
	public void setWrongAns(String wrongAns) {
		this.wrongAns = wrongAns;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
