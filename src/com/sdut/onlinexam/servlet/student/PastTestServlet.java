package com.sdut.onlinexam.servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.po.Student;
import com.sdut.onlinexam.service.teacher.IPaperService;
import com.sdut.onlinexam.service.teacher.PaperService;

@WebServlet("/pastTestServlet")
public class PastTestServlet extends HttpServlet{

	private IPaperService ps= new PaperService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student stu= (Student) req.getSession().getAttribute("user");
		List paperList = ps.getPaperByStudentId(stu.getId());
		req.setAttribute("paperList", paperList);
		req.getRequestDispatcher("student/history.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		super.doPost(req, resp);
	}

}
