package com.sdut.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.service.admin.IStudentService;
import com.sdut.onlinexam.service.admin.StudentService;

@WebServlet("/studentQueryServlet")
public class StudentQueryServlet extends HttpServlet{

	private IStudentService ss= new StudentService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*String stuName=req.getParameter("stuName");
		if(null==stuName)
			stuName="";*/
		List stuList=ss.findAll();
		req.setAttribute("stuList", stuList);
		req.getRequestDispatcher("manager/mstudent/studentmanage.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
