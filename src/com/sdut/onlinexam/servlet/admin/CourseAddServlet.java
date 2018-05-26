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

@WebServlet("/courseAddServlet")
public class CourseAddServlet extends HttpServlet{

	private ICourseService cs = new CourseService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("manager/course/courseadd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*Course cour=new Course();
		cour.setId(Integer.valueOf(req.getParameter("courid")));
		cour.setName(req.getParameter("courname"));*/
		cs.addCourse(req.getParameter("courname"));
		resp.sendRedirect(req.getContextPath()+"/courseQueryServlet");
	}

}
