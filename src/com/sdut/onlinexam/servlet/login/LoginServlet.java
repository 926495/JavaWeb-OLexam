package com.sdut.onlinexam.servlet.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.sdut.onlinexam.po.Student;
import com.sdut.onlinexam.po.Teacher;
import com.sdut.onlinexam.service.login.ILoginService;
import com.sdut.onlinexam.service.login.LoginService;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{

	private ILoginService ls=new LoginService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String vfCode =req.getParameter("vfCode");
		String userName = req.getParameter("username");
		String pwd = req.getParameter("password");
		String role = req.getParameter("role");

		if("admin".equals(role)) {
			if ("admin".equals(userName)&&"123".equals(pwd)){
				if("true".equals(vfCode))
					req.getRequestDispatcher("/manager/mindex.jsp").forward(req, resp);
				else {
					resp.setContentType("text/html;charset=GBK");
					PrintWriter out = resp.getWriter();
					out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>"); 
					out.print("<script>");
					out.print("alert('--验证码错误，请重新输入--');");
					out.print("window.location.href='./login.jsp'");
					out.print("</script>");
					out.close();
				}
			}else {
				resp.setContentType("text/html;charset=GBK");
				PrintWriter out = resp.getWriter();
				out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>"); 
				out.print("<script>");
				out.print("alert('--用户名密码不匹配，请重新输入--');");
				out.print("window.location.href='./login.jsp'");
				out.print("</script>");
				out.close();
			}
		}
		else if("teacher".equals(role)) {
			Teacher t=new Teacher();
			t.setName(userName);
			t.setPwd(pwd);
			t = ls.canLogin(t);
			if(null!=t) {
				if("true".equals(vfCode)) {
					req.getSession().setAttribute("user",t);
					req.getRequestDispatcher("/teacher/tindex.jsp").forward(req, resp);
				}
				else {
					resp.setContentType("text/html;charset=GBK");
					PrintWriter out = resp.getWriter();
					out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>"); 
					out.print("<script>");
					out.print("alert('--验证码错误，请重新输入--');");
					out.print("window.location.href='./login.jsp'");
					out.print("</script>");
					out.close();
				}
			}else {
				resp.setContentType("text/html;charset=GBK");
				PrintWriter out = resp.getWriter();
				out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>"); 
				out.print("<script>");
				out.print("alert('--用户名密码不匹配，请重新输入--');");
				out.print("window.location.href='./login.jsp'");
				out.print("</script>");
				out.close();
			}
		}
		else if("student".equals(role)) {
			Student stu=new Student();
			stu.setName(userName);
			stu.setPwd(pwd);
			stu = ls.canLogin(stu);
			if(null!=stu&&"true".equals(vfCode)) {
				if("true".equals(vfCode)) {
					req.getSession().setAttribute("user",stu);
					req.getRequestDispatcher("/student/index.jsp").forward(req, resp);
				}
				else {
					resp.setContentType("text/html;charset=GBK");
					PrintWriter out = resp.getWriter();
					out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>"); 
					out.print("<script>");
					out.print("alert('--验证码错误，请重新输入--');");
					out.print("window.location.href='./login.jsp'");
					out.print("</script>");
					out.close();
				}
			}else {
				resp.setContentType("text/html;charset=GBK");
				PrintWriter out = resp.getWriter();
				out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>"); 
				out.print("<script>");
				out.print("alert('--用户名密码不匹配，请重新输入--');");
				out.print("window.location.href='./login.jsp'");
				out.print("</script>");
				out.close();
			}
		}
	}
}