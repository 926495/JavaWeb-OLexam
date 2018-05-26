package com.sdut.onlinexam.servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.po.Teacher;
import com.sdut.onlinexam.service.admin.IStudentService;
import com.sdut.onlinexam.service.admin.StudentService;

@WebServlet("/lookUpStudnetServlet")
public class LookUpStudnetServlet extends HttpServlet{

	private IStudentService ss= new StudentService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Teacher tea =(Teacher) req.getSession().getAttribute("user");
		List stusList = ss.findStudentByTeacherId(tea.getId());
		req.setAttribute("stusList", stusList);
		req.getRequestDispatcher("teacher/students.jsp").forward(req, resp);;
	}

}
