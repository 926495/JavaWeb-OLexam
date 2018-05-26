package com.sdut.onlinexam.service.login;

import com.sdut.onlinexam.dao.login.ILoginDao;
import com.sdut.onlinexam.dao.login.LoginDao;
import com.sdut.onlinexam.po.Student;
import com.sdut.onlinexam.po.Teacher;

public class LoginService implements ILoginService{

	private ILoginDao ld = new LoginDao();
	@Override
	public Teacher canLogin(Teacher t) {
		return ld.canLogin(t);
	}

	@Override
	public Student canLogin(Student s) {
		return ld.canLogin(s);
	}

}
