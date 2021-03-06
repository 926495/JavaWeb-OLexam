package com.sdut.onlinexam.servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.service.teacher.IQuestionService;
import com.sdut.onlinexam.service.teacher.QuestionService;

@WebServlet("/questionDeleteServlet")
public class QuestionDeleteServlet extends HttpServlet{

	private IQuestionService qs=new QuestionService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		qs.deleteQuestion(Integer.valueOf(req.getParameter("id")));
		req.getRequestDispatcher("/questionQueryServlet").forward(req, resp);
	}

	
}
