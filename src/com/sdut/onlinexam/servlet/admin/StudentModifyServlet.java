package com.sdut.onlinexam.servlet.admin;

import java.io.IOException;
import java.sql.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.po.Course;
import com.sdut.onlinexam.po.StuClass;
import com.sdut.onlinexam.po.Student;
import com.sdut.onlinexam.service.admin.IStuClassService;
import com.sdut.onlinexam.service.admin.IStudentService;
import com.sdut.onlinexam.service.admin.StuClassService;
import com.sdut.onlinexam.service.admin.StudentService;
import com.sdut.onlinexam.util.Department;

@WebServlet("/studentModifyServlet")
public class StudentModifyServlet extends HttpServlet {

	private IStudentService ss = new StudentService();
	private IStuClassService scs=new StuClassService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Student stu=ss.findStudentById(Integer.valueOf(id));
		req.setAttribute("student", stu);
		req.setAttribute("classList",scs.findAll());
		req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("manager/mstudent/studentmodify.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Student s=new Student();
		s.setId(Integer.valueOf(req.getParameter("id")));
		s.setBorn(Date.valueOf(req.getParameter("born")));
		s.setName(req.getParameter("name"));
		s.setClassId(Integer.valueOf(req.getParameter("classId")));
		s.setPwd(req.getParameter("pwd"));
		s.setSchool(req.getParameter("school"));
		s.setSex(req.getParameter("sex"));
		ss.updateStudent(s);
		req.getRequestDispatcher("/studentQueryServlet").forward(req, resp);
	}
}
