package com.sdut.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.service.admin.CourseService;
import com.sdut.onlinexam.service.admin.ICourseService;

@WebServlet("/courseQueryServlet")
public class CourseQueryServlet extends HttpServlet{

	private ICourseService cs = new CourseService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String courname=req.getParameter("courname");
		if(null==courname) {
			courname="";
		}
		List courList = cs.findAllCourses(courname);
		req.setAttribute("courList", courList);
		req.getRequestDispatcher("manager/course/coursemanage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
