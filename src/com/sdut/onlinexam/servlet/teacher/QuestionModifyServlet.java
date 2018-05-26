package com.sdut.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.List;

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
import com.sdut.onlinexam.util.DepartmentQType;

@WebServlet("/questionModifyServlet")
public class QuestionModifyServlet extends HttpServlet{


	private IQuestionService qs=new QuestionService();
	private ICourseService cs=new CourseService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setAttribute("qList",qs.findAll("", ""));
		DepartmentQType[] ll=DepartmentQType.values();
		req.setAttribute("quesList",ll);
		req.setAttribute("courseList", cs.findAllCourses());
		req.setAttribute("questionMap", qs.findQuestionById(Integer.valueOf(req.getParameter("id"))));
		req.getRequestDispatcher("teacher/question/quesmodify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Question q=new Question(Integer.valueOf(req.getParameter("courseId")),req.getParameter("queTitle"), req.getParameter("choiceA"), req.getParameter("choiceB"), req.getParameter("choiceC"), req.getParameter("choiceD"), req.getParameter("ans"));
		q.setId(Integer.valueOf(req.getParameter("id")));
		qs.updateQuestionInfo(q);
		resp.sendRedirect(req.getContextPath()+"/questionQueryServlet");
		
	}

}
