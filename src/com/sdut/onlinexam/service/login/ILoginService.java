package com.sdut.onlinexam.service.login;

import com.sdut.onlinexam.po.Student;
import com.sdut.onlinexam.po.Teacher;

public interface ILoginService {
	public Teacher canLogin(Teacher t);
	public Student canLogin(Student t);

}
