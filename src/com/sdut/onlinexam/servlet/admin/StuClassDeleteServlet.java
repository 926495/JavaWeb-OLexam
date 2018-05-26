package com.sdut.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.service.admin.IStuClassService;
import com.sdut.onlinexam.service.admin.StuClassService;
import com.sdut.onlinexam.util.Department;

@WebServlet("/stuClassDeleteServlet")
public class StuClassDeleteServlet extends HttpServlet{

	private IStuClassService scs = new StuClassService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		System.out.println(id);
		scs.deleteStuClass(Integer.valueOf(id));
		req.getRequestDispatcher("/stuClassQueryServlet").forward(req, resp);
	}
	
	
}
