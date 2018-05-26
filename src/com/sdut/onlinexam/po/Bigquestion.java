package com.sdut.onlinexam.po;

public class Bigquestion {
	private int id;
	private int type;
	private int courseId;
	private String title;
	private String contentAns;
	private String spare;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContentAns() {
		return contentAns;
	}
	public void setContentAns(String contentAns) {
		this.contentAns = contentAns;
	}
	public String getSpare() {
		return spare;
	}
	public void setSpare(String spare) {
		this.spare = spare;
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
