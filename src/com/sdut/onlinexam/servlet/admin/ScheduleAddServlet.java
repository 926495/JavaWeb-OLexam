package com.sdut.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.po.TeacherCourse;
import com.sdut.onlinexam.service.admin.CourseService;
import com.sdut.onlinexam.service.admin.ICourseService;
import com.sdut.onlinexam.service.admin.IStuClassService;
import com.sdut.onlinexam.service.admin.ITeacherService;
import com.sdut.onlinexam.service.admin.StuClassService;
import com.sdut.onlinexam.service.admin.TeacherService;

@WebServlet("/scheduleAddServlet")
public class ScheduleAddServlet extends HttpServlet{

	private ICourseService cs = new CourseService();
	private ITeacherService ts = new TeacherService();
	private IStuClassService scs = new StuClassService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List courseList = cs.findAllCourses();
		List teaList = ts.findAllTeacher();
		List stuclList = scs.findAll();
		req.setAttribute("courseList", courseList);
		req.setAttribute("teaList",teaList );
		req.setAttribute("stuclList",stuclList );
		req.getRequestDispatcher("manager/mschedule/scheduleadd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherCourse tc = new TeacherCourse();
		tc.setClassId(Integer.valueOf(req.getParameter("stuclass")));
		tc.setCourseId(Integer.valueOf(req.getParameter("course")));
		tc.setTeaId(Integer.valueOf(req.getParameter("teacher")));
		cs.addSchedule(tc);
		resp.sendRedirect(req.getContextPath()+"/scheduleQueryServlet");
	}

}
