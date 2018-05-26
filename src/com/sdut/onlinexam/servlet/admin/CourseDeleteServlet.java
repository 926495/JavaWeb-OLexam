package com.sdut.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.service.admin.CourseService;
import com.sdut.onlinexam.service.admin.ICourseService;

@WebServlet("/courseDeleteServlet")
public class CourseDeleteServlet extends HttpServlet{

	private ICourseService cs=new CourseService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		cs.deleteTeacherCourse(Integer.valueOf(id));
		req.getRequestDispatcher("/courseQueryServlet").forward(req, resp);
	}	
}
