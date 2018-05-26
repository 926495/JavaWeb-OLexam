package com.sdut.onlinexam.servlet.student;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.onlinexam.po.Paper;
import com.sdut.onlinexam.po.Question;
import com.sdut.onlinexam.po.Student;
import com.sdut.onlinexam.service.teacher.IPaperService;
import com.sdut.onlinexam.service.teacher.IQuestionService;
import com.sdut.onlinexam.service.teacher.ITestService;
import com.sdut.onlinexam.service.teacher.PaperService;
import com.sdut.onlinexam.service.teacher.QuestionService;
import com.sdut.onlinexam.service.teacher.TestService;
import com.sdut.onlinexam.util.ToolUtil;

@WebServlet("/studentTest")
public class StudentTest extends HttpServlet{

	private ITestService ts = new TestService();
	private IQuestionService qs= new QuestionService();
	private IPaperService ps = new PaperService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String testid= req.getParameter("testId");
		Student stu = (Student) req.getSession().getAttribute("user");
		Map testMap = ts.findStudentTestsById(stu.getId(), Integer.valueOf(testid));
		String quesids = (String) testMap.get("questions");
		List quesList = qs.findQuestionByIds(quesids);
		req.setAttribute("scoreperques", 1.0*Integer.parseInt((String) (testMap.get("scores")))/quesList.size());
		req.getSession().setAttribute("test", testMap);
		req.getSession().setAttribute("quesList", quesList);
		req.getRequestDispatcher("student/exam.jsp").forward(req, resp);
	}
	
	/**
	 * 交卷
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				//从页面上获取答题时间信息
				String time = req.getParameter("hidden1");
				//从session中获取试题信息
				List quesList = (List) req.getSession().getAttribute("quesList");
				//从session中获取试卷信息
				Map testMap = (Map) req.getSession().getAttribute("test");
				
				/**
				 * 从session中能够获取试题集合
				 * 试题集合中有试题的id号和答案
				 * 页面上展示了试题信息，能够提供每道题的答案
				 * 页面上的试题和我们保存到session中的试题是一样的
				 * 通过迭代session中的试题，我们能够获得具体的每一道试题
				 * 通过当前试题的id号能够获取页面上这道题的答案。
				 * 通过页面上针对选项的标识--ques_+试题id号能够获得本道题的答案
				 * 试题答案和正确答案做对比，如果不一致，则记录试题的id号和错误答案
				 * 然后需要对wrongQueId和wrongAns 两个stringbuffer做处理
				 * 如果试卷全对，则这两个都是“”，否则会多一个逗号
				 * 需要把多余的逗号去掉
				 * 另外还需要记录错误题目的数量，用来计算分值
				 * 分值的计算方式为：试卷总分/试题数量*正确的题目数量
				 * 把以上信息封装成paper对象，持久化到数据库
				 */
				if (null == quesList || quesList.size()<1)
					return ;
				StringBuffer wrongQueId = new StringBuffer();
				StringBuffer wrongAns = new StringBuffer();
				//目的是遍历试卷中的试题的集合
				int wrongQueNum = 0;
				for (int i = 0 ; i < quesList.size();i++){
					Question q = (Question) quesList.get(i);
					//页面接收的答案
					String ans = req.getParameter("ques_"+q.getId()).toUpperCase();
					//如果和标准答案不匹配，则记录错误的题号和错误答案
					if (!q.getAns().equals(ans)){
						wrongQueId.append(q.getId()).append(",");
						wrongAns.append(ans).append(",");
						wrongQueNum++;
					}
				}
				Paper p = new Paper();
				p.setTestId((int) testMap.get("id"));
				p.setCourseId((int) testMap.get("courseId"));
				p.setTime(time);
				//获得试题的总分和错误试题的数量
				if (quesList.size()>wrongQueNum)
					p.setScore(1.0*Integer.parseInt((String) (testMap.get("scores")))/quesList.size()*(quesList.size()-wrongQueNum));
				else
					p.setScore(0);
				/**
				 * 如果做的全对，那么wrongQueId和wrongAns，都是空
				 * 如果有错题，那么多带了一个逗号
				 */
				String wrongQueIdString = wrongQueId.toString();
				String wrongAnsString = wrongAns.toString();
				if (wrongQueIdString.endsWith(",")){
					wrongQueIdString = wrongQueIdString.substring(0, wrongQueIdString.length()-1);
					wrongAnsString = wrongAnsString.substring(0, wrongAnsString.length()-1);
				}
				p.setWrongQueId(wrongQueIdString);
				p.setWrongAns(wrongAnsString);
				Student s = (Student) req.getSession().getAttribute("user");
				p.setStudentId(s.getId());
				Date date = new Date();
				p.setCreateDate(date);
				ps.save(p);
				/**
				 * 开始考试的时候，在页面的超链接上，使用了target="_parent"
				 * 跳出了frame框架，因此，重定向的时候需要再定向到frame里
				 */
				resp.sendRedirect(req.getContextPath()+"/student/index.jsp");
			}
}
