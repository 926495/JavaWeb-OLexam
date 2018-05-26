package com.sdut.onlinexam.servlet.teacher;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.po.Teacher;
import com.sdut.onlinexam.service.admin.IStuClassService;
import com.sdut.onlinexam.service.admin.StuClassService;
import com.sdut.onlinexam.service.teacher.ITestService;
import com.sdut.onlinexam.service.teacher.TestService;

@WebServlet("/testQueryServlet")
public class TestQueryServlet extends HttpServlet{

	private ITestService ts = new TestService();
	private IStuClassService scs=new StuClassService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Teacher tea =(Teacher) req.getSession().getAttribute("user");
		List<Map<String,Object>> testsList=ts.findTestsByTeaId(tea.getId());
		for(Map<String,Object> test:testsList) {
			String classIds=(String) test.get("classIds");
			String classNames = scs.findClassNamesByIds(classIds);
			test.put("classNames", classNames);
			//添加时间
			java.util.Date nowdate=new java.util.Date();
			Timestamp tt=(Timestamp) test.get("endDate");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss."+0,Locale.CHINA);
			boolean flag = tt.before(nowdate);
			if(flag)
				test.put("Date", "已结束");
			else
				test.put("Date", "未开始");
		}
		req.setAttribute("testsList", testsList);
		req.getRequestDispatcher("teacher/test/tmain.jsp").forward(req, resp);
	}
}
