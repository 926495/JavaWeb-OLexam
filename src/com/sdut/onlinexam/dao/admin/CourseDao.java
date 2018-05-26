package com.sdut.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.List;

import com.sdut.onlinexam.po.Course;
import com.sdut.onlinexam.po.StuClass;
import com.sdut.onlinexam.po.TeacherCourse;
import com.sdut.onlinexam.po.Test;
import com.sdut.onlinexam.util.DBUtil;
import com.sdut.onlinexam.vo.TeacherCourseView;

public class CourseDao implements ICourseDao {

	DBUtil db = new DBUtil();

	@Override
	public List<TeacherCourseView> findAllTeaCourInfo() {
		String sql = "SELECT tc.id,c.name courName,t.name teaName,sc.name className FROM teachercourse tc,teacher t,course c,stuclass sc WHERE tc.teaId=t.id AND tc.courseId=c.id AND tc.classId=sc.id";
		List tcList = new ArrayList();
		try {
			tcList = db.getQueryList(sql);
		} catch (Exception e) {
			tcList = new ArrayList();
			e.printStackTrace();
		}
		return tcList;
	}

	@Override
	public Course findCourseByName(String name) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public TeacherCourse findTeacherCourseById(int id) {
		String sql = "SELECT * FROM teachercourse WHERE id=?";
		TeacherCourse tc = new TeacherCourse();
		List tcList = new ArrayList();
		try {

			tcList = db.getQueryList(TeacherCourse.class, sql, new Object[] { id });
			for (Object o : tcList) {
				tc = (TeacherCourse) o;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tc;
	}

	@Override
	public void addCourse(String name) {
		String sql = "INSERT INTO course (name) values(?)";
		try {
			db.execute(sql, new Object[] { name });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCourse(Course course) {
		String sql = "UPDATE course SET name =? WHERE id = ?";
		try {
			db.execute(sql, new Object[] { course.getName(), course.getId() });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Course findCourseById(int id) {
		String sql = "SELECT * FROM course WHERE id=?";
		Course cour = new Course();
		List courList = new ArrayList();
		try {

			courList = db.getQueryList(Course.class, sql, new Object[] { id });
			for (Object o : courList) {
				cour = (Course) o;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cour;
	}

	@Override
	public void addTeacherCourse(TeacherCourse tc) {
		String sql = "INSERT INTO teachercourse (courseId,teaId,classId) values(?,?,?)";
		try {
			db.execute(sql, new Object[] { tc.getCourseId(), tc.getTeaId(), tc.getClassId() });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public TeacherCourseView findTeaCourInfoById(int id) {
		String sql = "SELECT * FROM teachercourse WHERE id=?";
		TeacherCourseView tcv = new TeacherCourseView();
		List tcvList = new ArrayList();
		try {

			tcvList = db.getQueryList(TeacherCourseView.class, sql, new Object[] { id });
			for (Object o : tcvList) {
				tcv = (TeacherCourseView) o;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tcv;
	}

	@Override
	public List<Course> findAllCourses() {
		String sql = "SELECT * FROM course";
		List courList = new ArrayList();
		try {
			courList = db.getQueryList(sql);
		} catch (Exception e) {
			courList = new ArrayList();
			e.printStackTrace();
		}
		return courList;
	}

	@Override
	public List<Course> findAllCoursesByName(String name) {
		String sql = "SELECT * FROM course";
		if (!"".equals(name)) {
			sql += " WHERE name LIKE '%" + name + "%'";
		}
		List courList = new ArrayList();
		try {
			courList = db.getQueryList(sql);
		} catch (Exception e) {
			courList = new ArrayList();
			e.printStackTrace();
		}
		return courList;
	}

	@Override
	public boolean isExitByAllIds(TeacherCourse tc) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public void updateTeacherCourse(TeacherCourse tc) {
		String sql = "UPDATE teachercourse SET courseId =?,teaId=?,classId=? WHERE id = ?";
		try {
			db.execute(sql, new Object[] {tc.getClassId(),tc.getTeaId(),tc.getClassId(),tc.getId()});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<TeacherCourseView> findTeaCourInfoByCourseKey(String courseKey) {
		String sql="SELECT tc.id,c.name courName,t.name teaName,sc.name className FROM teachercourse tc,teacher t,course c,stuclass sc WHERE tc.teaId=t.id AND tc.courseId=c.id AND tc.classId=sc.id AND tc.id in( SELECT tc.id FROM teachercourse tc WHERE tc.courseId in ( SELECT c.id FROM course c WHERE c.name LIKE '%"+courseKey+"%'))";
		List tcList = new ArrayList();
		try {
			tcList = db.getQueryList(sql);
		} catch (Exception e) {
			tcList = new ArrayList();
			e.printStackTrace();
		}
		return tcList;
	}

	@Override
	public void deleteTourse(int tcId) {
		String sql = "DELETE FROM course WHERE id=?";
		try {
			db.execute(sql, new Object[] { tcId });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Course> findCoursesByTeacherId(int teaId) {
		String sql="SELECT * FROM course WHERE id in(SELECT courseId FROM teachercourse WHERE teaId=?)";
		List courList =new ArrayList();
		try {
			courList=db.getQueryList(Course.class, sql, new  Object[] {teaId});
		} catch (Exception e) {
			courList =new ArrayList();
			e.printStackTrace();
		}
		return courList;
	}

	@Override
	public void deleteTeacherTourse(int id) {
		String sql = "DELETE FROM teachercourse WHERE id=?";
		try {
			db.execute(sql, new Object[] { id });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
