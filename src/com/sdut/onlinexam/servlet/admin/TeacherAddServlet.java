package com.sdut.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.po.Teacher;
import com.sdut.onlinexam.service.admin.ITeacherService;
import com.sdut.onlinexam.service.admin.TeacherService;
import com.sdut.onlinexam.util.Department;

@WebServlet("/teacherAddServlet")
public class TeacherAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("manager/teacher/teacheradd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Teacher tea=new Teacher();
		tea.setName(req.getParameter("teaname"));
		tea.setPwd(req.getParameter("pwd"));
		tea.setDeptName(req.getParameter("depInfo"));
		ITeacherService ts=new TeacherService();
		ts.addTeacher(tea);
		
		//抛弃请求信息
		resp.sendRedirect(req.getContextPath()+"/teacherQueryServlet");
		//只显示一行  带参数跳转
		//req.getRequestDispatcher("/teacherQueryServlet").forward(req, resp);
	}

}
