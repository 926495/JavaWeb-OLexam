package com.sdut.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.service.admin.ITeacherService;
import com.sdut.onlinexam.service.admin.TeacherService;

@WebServlet("/teacherQueryServlet")
public class TeacherQueryServlet extends HttpServlet{
	private ITeacherService ts=new TeacherService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String teaName=req.getParameter("teaname");
		if(null==teaName)
			teaName="";
		List teaList =ts.findTeachers(teaName);
		req.setAttribute("teaList", teaList);
		req.getRequestDispatcher("manager/teacher/teachermanage.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
