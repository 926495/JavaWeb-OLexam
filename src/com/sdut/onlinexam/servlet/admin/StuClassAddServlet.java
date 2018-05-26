package com.sdut.onlinexam.servlet.admin;
/**
 * 增加班级
 */

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.po.StuClass;
import com.sdut.onlinexam.po.Student;
import com.sdut.onlinexam.service.admin.IStuClassService;
import com.sdut.onlinexam.service.admin.StuClassService;
import com.sdut.onlinexam.util.Department;

@WebServlet("/stuClassAddServlet")
public class StuClassAddServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//setAttribute把数据传递到页面
		req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("/manager/class/stuclassadd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/**
		 * 获取请求参数
		 */
		String stuName = req.getParameter("classname");
		String depInfo = req.getParameter("depInfo");
		/**
		 * 把请求参数封装成对象
		 * 封装的目的调用业务层的方法
		 */
		StuClass sc=new StuClass();
		sc.setName(stuName);
		sc.setDeptName(depInfo);
		IStuClassService scs = new StuClassService();
		scs.addstuClass(sc);
		/**
		 *getRequestDispatcher可以跳转请求
		 *  /+servlet
		 *  带着req和resp跳转
		 *  有时候不需要继续保存这两个包含的信息，就用resp.sendRedirect
		 */
		//req.getRequestDispatcher("/stuClassQueryServlet").forward(req, resp);
		resp.sendRedirect(req.getContextPath()+"/stuClassQueryServlet");
	}
}
