package com.sdut.onlinexam.servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.po.Test;
import com.sdut.onlinexam.service.teacher.ITestService;
import com.sdut.onlinexam.service.teacher.TestService;

@WebServlet("/testCreateServlet")
public class TestCreateServlet extends HttpServlet{

	private ITestService ts= new TestService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Test t=(Test)req.getSession().getAttribute("test");
		ts.createTest(t);
		/**
		 * 把test从session中清除
		 */
		req.getSession().removeAttribute("test");
		//resp.sendRedirect("teacher/test/tmain.jsp");
		resp.sendRedirect(req.getContextPath()+"/testQueryServlet");
	}

}
