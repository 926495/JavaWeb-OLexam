package com.sdut.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.po.Course;
import com.sdut.onlinexam.service.admin.CourseService;
import com.sdut.onlinexam.service.admin.ICourseService;

@WebServlet("/courseModifyServlet")
public class CourseModifyServlet extends HttpServlet{
	
	private ICourseService cs=new CourseService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		Course cour=cs.findCourseById(Integer.valueOf(id));
		req.setAttribute("cour", cour);
		req.getRequestDispatcher("manager/course/coursemodify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Course cour=new Course();
		cour.setId(Integer.valueOf(req.getParameter("courId")));
		cour.setName(req.getParameter("coursename"));
		cs.updateCourse(cour);
		resp.sendRedirect(req.getContextPath()+"/courseQueryServlet");
	}
	
}
