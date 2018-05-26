package com.sdut.onlinexam.servlet.admin;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.po.Student;
import com.sdut.onlinexam.service.admin.IStuClassService;
import com.sdut.onlinexam.service.admin.IStudentService;
import com.sdut.onlinexam.service.admin.StuClassService;
import com.sdut.onlinexam.service.admin.StudentService;
import com.sdut.onlinexam.util.Department;

@WebServlet("/studentAddServlet")
public class StudentAddServlet extends HttpServlet {

	private IStudentService ss = new StudentService();
	private IStuClassService scs=new StuClassService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("classList", scs.findAll());
		req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("manager/mstudent/studentadd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student s = new Student();
		s.setName(req.getParameter("stuName"));
		s.setPwd(req.getParameter("pwd"));
		s.setSex(req.getParameter("stuSex"));
		s.setSchool(req.getParameter("stuSchool"));
		s.setBorn(Date.valueOf(req.getParameter("bornDate")));
		s.setClassId(Integer.valueOf(req.getParameter("classId")));
		
		ss.addStudent(s);
		resp.sendRedirect(req.getContextPath() + "/studentQueryServlet");
	}

}
