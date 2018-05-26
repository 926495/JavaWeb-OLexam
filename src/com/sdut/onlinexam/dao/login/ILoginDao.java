package com.sdut.onlinexam.dao.login;

import com.sdut.onlinexam.po.Student;
import com.sdut.onlinexam.po.Teacher;

public interface ILoginDao {

	public Teacher canLogin(Teacher t);
	
	public Student canLogin(Student s);
}
