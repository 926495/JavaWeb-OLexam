package com.sdut.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.po.Question;
import com.sdut.onlinexam.po.Teacher;
import com.sdut.onlinexam.po.Test;
import com.sdut.onlinexam.service.admin.IStuClassService;
import com.sdut.onlinexam.service.admin.StuClassService;
import com.sdut.onlinexam.service.teacher.IQuestionService;
import com.sdut.onlinexam.service.teacher.ITestService;
import com.sdut.onlinexam.service.teacher.QuestionService;
import com.sdut.onlinexam.service.teacher.TestService;

@WebServlet("/testDetailInfoServlet")
public class TestDetailInfoServlet extends HttpServlet{

	private ITestService ts = new TestService();
	private IStuClassService scs=new StuClassService();
	private IQuestionService qs= new QuestionService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		Teacher tea =(Teacher) req.getSession().getAttribute("user");
		Map tMap = ts.findTestById(Integer.valueOf(id), tea.getId());
		String quesids = (String) tMap.get("questions");
		List<Question> quesList = qs.findQuestionByIds(quesids);
		Map<String, Object> testMap=  ts.findTestById(Integer.valueOf(id), tea.getId());
		req.setAttribute("test", testMap);
		req.setAttribute("quesList", quesList);
		req.getRequestDispatcher("teacher/test/viewtest.jsp").forward(req, resp);
	}
}
