package com.sdut.onlinexam.po;

import java.sql.Timestamp;

public class Test {
	private int id;
	private int courseId;
	private int testTime;
	private int teacherId;
	private String name;
	private String questions;
	private String classIds;
	private String scores;
	private Timestamp endDate;

	public Test() {
	}

	public Test(int teacherId, int courseId, String name, Timestamp endDate, String scores, String questions,
			int testTime, String classIds) {
		this.teacherId = teacherId;
		this.courseId = courseId;
		this.name = name;
		this.endDate = endDate;
		this.scores = scores;
		this.questions = questions;
		this.testTime = testTime;
		this.classIds = classIds;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getTestTime() {
		return testTime;
	}

	public void setTestTime(int testTime) {
		this.testTime = testTime;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTecherId(int techerId) {
		this.teacherId = techerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public String getClassIds() {
		return classIds;
	}

	public void setClassIds(String classIds) {
		this.classIds = classIds;
	}

	public String getScores() {
		return scores;
	}

	public void setScores(String scores) {
		this.scores = scores;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
