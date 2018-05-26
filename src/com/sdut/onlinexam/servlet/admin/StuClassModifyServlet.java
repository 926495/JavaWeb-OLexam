package com.sdut.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.po.Course;
import com.sdut.onlinexam.po.StuClass;
import com.sdut.onlinexam.service.admin.IStuClassService;
import com.sdut.onlinexam.service.admin.StuClassService;
import com.sdut.onlinexam.util.Department;

@WebServlet("/stuClassModifyServlet")
public class StuClassModifyServlet extends HttpServlet {

	private IStuClassService scs = new StuClassService();

	/**
	 * 获取当前对象，把当前对象送到要跳转的页面 页面跳转
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Map<String, Object> stuMap = scs.findStuClassById(Integer.valueOf(id));
		//传递值到页面
		req.setAttribute("deptList",Department.values());
		req.setAttribute("stuClass",stuMap);
		req.getRequestDispatcher("/manager/class/stuclassmodify.jsp").forward(req, resp);
	}

	/**
	 * 在页面上修改当前对象的值并提交
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("stuClassId");
		String dept=req.getParameter("depInfo");
		String classname=req.getParameter("classname");
		StuClass sc=new StuClass();
		sc.setId(Integer.valueOf(id));
		sc.setDeptName(dept);
		sc.setName(classname);
		scs.updateStuClass(sc);
		req.getRequestDispatcher("/stuClassQueryServlet").forward(req, resp);
	}
}
