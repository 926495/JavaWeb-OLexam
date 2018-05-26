package com.sdut.onlinexam.servlet.admin;

import java.io.IOException;

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

@WebServlet("/scheduleModifyServlet")
public class ScheduleModifyServlet extends HttpServlet{

	private ICourseService cs=new CourseService();
	private IStuClassService scs=new StuClassService();
	private ITeacherService ts=new TeacherService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherCourse tss= cs.findById(Integer.valueOf(req.getParameter("id")));
		req.setAttribute("tc", cs.findById(Integer.valueOf(req.getParameter("id"))));
		req.setAttribute("courList", cs.findAllCourses());
		req.setAttribute("teaList", ts.findAllTeacher());
		req.setAttribute("stuclList",scs.findAll());
		req.getRequestDispatcher("manager/mschedule/schedulemodify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherCourse tc=new TeacherCourse();
		tc.setClassId(Integer.valueOf(req.getParameter("stuclass")));
		tc.setCourseId(Integer.valueOf(req.getParameter("course")));
		tc.setTeaId(Integer.valueOf(req.getParameter("teacher")));
		tc.setId(Integer.valueOf(req.getParameter("id")));
		cs.updateTeacherCourse(tc);
		resp.sendRedirect(req.getContextPath()+"/scheduleQueryServlet");
	}

}
