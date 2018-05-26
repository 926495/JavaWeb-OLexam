package com.sdut.onlinexam.dao.login;

import com.sdut.onlinexam.po.Student;
import com.sdut.onlinexam.po.Teacher;
import com.sdut.onlinexam.util.DBUtil;

public class LoginDao implements ILoginDao{

	private DBUtil db=new DBUtil();

	@Override
	public Teacher canLogin(Teacher t) {
		String sql="select * from teacher where name=? and pwd=?";
		Teacher t2=new Teacher();
		try {
			t2=(Teacher)db.getObject(Teacher.class, sql, new Object[] {t.getName(),t.getPwd()});
		} catch (Exception e) {
			t2=null;
			e.printStackTrace();
		}
		return t2;
	}

	@Override
	public Student canLogin(Student s) {
		String sql="select * from student where name=? and pwd=?";
		Student stu=new Student();
		try {
			stu=(Student)db.getObject(Student.class, sql, new Object[] {s.getName(),s.getPwd()});
		} catch (Exception e) {
			stu=null;
			e.printStackTrace();
		}
		return stu;
	}
}
