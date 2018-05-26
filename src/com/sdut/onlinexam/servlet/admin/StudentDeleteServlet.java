package com.sdut.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.service.admin.IStudentService;
import com.sdut.onlinexam.service.admin.StudentService;

@WebServlet("/studentDeleteServlet")
public class StudentDeleteServlet extends HttpServlet{
	private IStudentService ss = new StudentService();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		ss.deleteStudent(Integer.valueOf(id));
		req.getRequestDispatcher("/studentQueryServlet").forward(req, resp);
	}
}
