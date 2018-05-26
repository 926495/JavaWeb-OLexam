package com.sdut.onlinexam.servlet.student;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.po.Student;
import com.sdut.onlinexam.service.teacher.ITestService;
import com.sdut.onlinexam.service.teacher.TestService;
import com.sdut.onlinexam.util.ToolUtil;

@WebServlet("/recentTestServlet")
public class RecentTestServlet extends HttpServlet{

	private ITestService ts= new TestService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student stu = (Student) req.getSession().getAttribute("user");
		String currData =ToolUtil.getCurrentTime();
		List testsList = ts.getTestByStudent(stu.getId(), currData);
		req.setAttribute("testsList", testsList);
		req.getRequestDispatcher("student/main.jsp").forward(req, resp);
	}

}
