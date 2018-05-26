package com.sdut.onlinexam.servlet.teacher;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.po.Course;
import com.sdut.onlinexam.po.Teacher;
import com.sdut.onlinexam.po.Test;
import com.sdut.onlinexam.service.admin.CourseService;
import com.sdut.onlinexam.service.admin.ICourseService;
import com.sdut.onlinexam.service.admin.IStuClassService;
import com.sdut.onlinexam.service.admin.StuClassService;
import com.sdut.onlinexam.service.teacher.IQuestionService;
import com.sdut.onlinexam.service.teacher.ITestService;
import com.sdut.onlinexam.service.teacher.QuestionService;
import com.sdut.onlinexam.service.teacher.TestService;
import com.sdut.onlinexam.util.ToolUtil;

@WebServlet("/testAddServlet")
public class TestAddServlet extends HttpServlet {

	private ICourseService cs = new CourseService();
	private ITestService ts = new TestService();
	private IStuClassService scs = new StuClassService();
	private IQuestionService qs = new QuestionService();
	private IStuClassService ss = new StuClassService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Teacher t = (Teacher) req.getSession().getAttribute("user");
		List<Course> courList = cs.findCoursesByTeacherId(t.getId());
		
		req.setAttribute("classesList", scs.findAll());
		req.setAttribute("courseList", courList);
		req.getRequestDispatcher("teacher/test/testadd.jsp").forward(req, resp);
	}

	/**
	 * 组卷 1.从页面上获取试卷基本信息，把基本信息要传递到下一页面 2.获取试卷题目相关信息，随机抽题组卷，把试题传递到下一页面 3.页面跳转
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Teacher tea = (Teacher) req.getSession().getAttribute("user");
		/**
		 * 页面如果有复选框，通过getParameterValues获取 类型转换 ： 日期 String->Date SimpleDateFormat sdf =
		 * new SimpleDateFormat("yy-mm-dd hh:mm:ss"); 班级ID: String 类型的数组，需要转换成String
		 * String classsIds= ToolUtil.arraytoString(classCheck); 随机出题
		 */
		int id = tea.getId();
		int courid = Integer.valueOf(req.getParameter("courseid"));
		String testname = req.getParameter("testname");
		Timestamp enddate = Timestamp.valueOf(req.getParameter("enddate"));
		String sinscores = req.getParameter("sinscores");
		String sinnum = req.getParameter("sinnum");
		int testtime = Integer.valueOf(req.getParameter("testtime"));
		String classids = ToolUtil.arraytoString(req.getParameterValues("classCheck"));
		List<Map<String, Object>> queList = qs.collectQuestions(courid, Integer.valueOf(sinnum));
		String questions = qs.testQuestionIds(queList);
		String classNames = ss.findClassNamesByIds(classids);
		
		Test t = new Test(id, courid, testname, enddate, sinscores,questions , testtime, classids);
		Course c=cs.findCourseById(Integer.valueOf(courid));

		/**
		 * 把班级名称，试卷对象和试题几个的数据放到页面上
		 */
		req.setAttribute("classNames", classNames);
		req.setAttribute("quesList", queList);
		req.setAttribute("c", c);
		req.getSession().setAttribute("test", t);
		req.getRequestDispatcher("teacher/test/test.jsp").forward(req, resp);
	}

}
