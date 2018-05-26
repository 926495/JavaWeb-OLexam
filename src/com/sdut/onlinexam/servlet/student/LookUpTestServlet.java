package com.sdut.onlinexam.servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.service.teacher.IQuestionService;
import com.sdut.onlinexam.service.teacher.QuestionService;

@WebServlet("/lookUpTestServlet")
public class LookUpTestServlet extends HttpServlet{

	private IQuestionService qs =new QuestionService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pId =req.getParameter("pId");
		List wquesList = qs.getWQuesByPaperId(Integer.valueOf(pId));
		req.setAttribute("wquesList", wquesList);
		req.getRequestDispatcher("student/wrongpaper.jsp").forward(req, resp);
	}

}
