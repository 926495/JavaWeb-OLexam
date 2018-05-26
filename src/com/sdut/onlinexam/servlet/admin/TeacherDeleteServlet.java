package com.sdut.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.service.admin.ITeacherService;
import com.sdut.onlinexam.service.admin.TeacherService;
import com.sdut.onlinexam.util.Department;

@WebServlet("/teacherDeleteServlet")
public class TeacherDeleteServlet extends HttpServlet{

	private ITeacherService ts = new TeacherService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		ts.deleteTeacher(Integer.valueOf(id));
		req.getRequestDispatcher("/teacherQueryServlet").forward(req, resp);
	}
	
	
}
