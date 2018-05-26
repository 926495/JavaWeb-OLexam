package com.sdut.onlinexam.po;
/**
 * 课程类，描述课程实体
 * @author Yl-Lin
 *
 */
public class Course {
	/**
	 * java数据类型： int,double,float,boolean,char,String,long,short,byte
	 * 数据类型分为:
	 * 基本数据类型（8）种 byte short int long float double char boolean
	 * 引用数据类型   类 接口  数组
	 */
	private int id;
	private String name;
	/**
	 * java访问权限有：private public protected
	 */
	public Course() {}
	public Course(int id,String name) {
		this.id=id;
		this.name=name;
	}
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

}
