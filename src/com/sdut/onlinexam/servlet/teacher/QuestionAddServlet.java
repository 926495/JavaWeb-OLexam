package com.sdut.onlinexam.servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.po.Question;
import com.sdut.onlinexam.service.admin.CourseService;
import com.sdut.onlinexam.service.admin.ICourseService;
import com.sdut.onlinexam.service.teacher.IQuestionService;
import com.sdut.onlinexam.service.teacher.QuestionService;

@WebServlet("/questionAddServlet")
public class QuestionAddServlet extends HttpServlet{

	private ICourseService cs=new CourseService();
	private IQuestionService qs=new QuestionService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("courseList", cs.findAllCourses());
		req.getRequestDispatcher("teacher/question/quesadd.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Question q=new Question(Integer.valueOf(req.getParameter("courseId")), req.getParameter("queTitle"), req.getParameter("choiceA"), req.getParameter("choiceB"), req.getParameter("choiceC"), req.getParameter("choiceD"), req.getParameter("ans"));
		qs.addQuestion(q);
		resp.sendRedirect(req.getContextPath()+"/questionQueryServlet");
	}

}
