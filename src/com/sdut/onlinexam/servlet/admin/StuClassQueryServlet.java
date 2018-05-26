package com.sdut.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.service.admin.IStuClassService;
import com.sdut.onlinexam.service.admin.StuClassService;

/**
 * 用于查询班级信息
 * @author Yl-Lin
 *
 */
@WebServlet("/stuClassQueryServlet")
public class StuClassQueryServlet extends HttpServlet{

	private IStuClassService scs = new StuClassService();
	/**
	 * 查询一般用doGet
	 */
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		/**
		 * servlet职能
		 * 1.接受用户请求
		 * 2.从业务层获取结果
		 * 3.把结果封装并传递到页面
		 * 4.页面跳转
		 */
		List stuClassList = scs.findAll();
		/**
		 * 使用request.setAttribute把结果放到页面
		 * 第一个参数时key第二个参数时value
		 */
		req.setAttribute("scList",stuClassList);
		req.getRequestDispatcher("manager/class/stuclassmanage.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	

}
