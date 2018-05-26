package com.sdut.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.po.Teacher;
import com.sdut.onlinexam.service.admin.ITeacherService;
import com.sdut.onlinexam.service.admin.TeacherService;
import com.sdut.onlinexam.util.Department;

@WebServlet("/teacherModifyServlet")
public class TeacherModifyServlet extends HttpServlet{
	private ITeacherService ts = new TeacherService();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Map<String, Object> teaMap = ts.findTeacherInfo(Integer.valueOf(id));
		
		//传递值到页面
		req.setAttribute("deptList", Department.values());
		req.setAttribute("teaMap", teaMap);
		req.getRequestDispatcher("/manager/teacher/teachermodify.jsp").forward(req, resp);
	}

	/**
	 * 在页面上修改当前对象的值并提交
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Teacher tea =new Teacher();
		tea.setId(Integer.valueOf(req.getParameter("teacherId")));
		tea.setName(req.getParameter("teaname"));
		tea.setDeptName(req.getParameter("depInfo"));
		tea.setPwd(req.getParameter("pwd"));
		ts.updateTeacher(tea, Integer.valueOf(req.getParameter("teacherId")));
		resp.sendRedirect(req.getContextPath()+"/teacherQueryServlet");
		//sreq.getRequestDispatcher("/stuClassQueryServlet").forward(req, resp);
	}
}
