package com.sdut.onlinexam.po;

import java.sql.Date;

public class Student {
	private int id;
	private String name;
	private String pwd;
	private String school;
	private String sex;
	private Date born;
	private int classId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBorn() {
		return born;
	}
	public void setBorn(Date born) {
		this.born = born;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public Student() {
			
		}
	public Student(int id,String name,String pwd,String school,String sex,Date born,int classId) {
		this.id=id;
		this.name=name;
		this.pwd=pwd;
		this.school=school;
		this.sex=sex;
		this.born=born;
		this.classId=classId;
	}
	/*public static void main(String[] args) {
	
		 * 构造方法：用来创建对象，可以初始化成员变量
		 * 如果没有，系统提供无参构造方法
		 * 构造方法可以重载
		 * 如果提供了构造方法，系统则不提供无参构造方法
		 * 构造方法与普通方法有区别，构造方法名与类名完全相同
		 
		Student stu=new Student();
		stu.setName("pgOne");
		Student stu2=new Student(0,"honghuahui","11","beida","yinianji","man","china",1000);
	}*/
}