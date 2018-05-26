package com.sdut.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sdut.onlinexam.po.Course;
import com.sdut.onlinexam.po.Student;
import com.sdut.onlinexam.util.DBUtil;

public class StudentDao implements IStudentDao {

	DBUtil db = new DBUtil();
	@Override
	public void addStudent(Student s) {
		String sql="INSERT INTO student (name,pwd,school,classId,sex,born) values(?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] {s.getName(),s.getPwd(),s.getSchool(),s.getClassId(),s.getSex(),s.getBorn()});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent(Student s) {
		String sql="UPDATE student SET name=?,pwd=?,school=?,classId=?,sex=?,born=? WHERE id = ?";
		try {
			db.execute(sql, new Object[]{s.getName(),s.getPwd(),s.getSchool(),s.getClassId(),s.getSex(),s.getBorn(),s.getId()});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Student findStudentById(int id) {
		String sql = "SELECT * FROM student WHERE id=?";
		Student stu = new Student();
		List stuList= new ArrayList();
		try {
			
			stuList=db.getQueryList(Student.class, sql, new Object[] { id });
			for(Object o: stuList) {
				 stu= (Student)o;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stu;
	}

	@Override
	public List<Map<String, Object>> findAll() {
		/**
		 * 多表查询，表之间用“，”隔开
		 */
		List stuList = new ArrayList();
		String sql = "SELECT s.id,s.name,s.pwd,s.school,s.sex,s.born,sc.deptName,sc.name className FROM student s,stuclass sc WHERE s.classId=sc.id";
		try {
			stuList = db.getQueryList(sql);
		} catch (Exception e) {
			stuList = new ArrayList();
			e.printStackTrace();
		}
		return stuList;
	}

	@Override
	public void deleteStudentById(int id) {
		String sql = "DELETE FROM student WHERE id =?";
		try {
			db.execute(sql, new Object[] {id});
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Override
	public List findStudentByTeacherId(int teaId) {
		String sql="SELECT s.`name` stuName,s.school,s.sex,s.born,sc.`name` className,t.deptName FROM stuclass sc, teachercourse tc,teacher t,course c,student s WHERE tc.courseId =c.id AND c.id = s.classId AND tc.teaId=t.id AND sc.id= tc.classId AND t.id=?";
		List stusList = new ArrayList();
		try {
			stusList=db.getQueryList(sql, new Object[] {teaId});
		} catch (Exception e) {
			stusList = new ArrayList();
			e.printStackTrace();
		}
		return stusList;
	}

}
