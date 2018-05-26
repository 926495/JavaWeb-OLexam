package com.sdut.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.po.Teacher;
import com.sdut.onlinexam.service.teacher.IPaperService;
import com.sdut.onlinexam.service.teacher.PaperService;

@WebServlet("/papersCompareServlet")
public class PapersCompareServlet extends HttpServlet{

	private IPaperService ps=new PaperService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Teacher tea = (Teacher) req.getSession().getAttribute("user");
		List paperList = ps.getPaperCompare(tea.getId());
		req.setAttribute("paperList", paperList);
		req.getRequestDispatcher("teacher/test/classpapers.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		super.doPost(req, resp);
	}

}
