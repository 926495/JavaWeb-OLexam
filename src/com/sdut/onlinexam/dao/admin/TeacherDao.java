package com.sdut.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sdut.onlinexam.po.Teacher;
import com.sdut.onlinexam.util.DBUtil;

public class TeacherDao implements ITeacherDao{
	DBUtil db=new DBUtil();

	@Override
	public List<Teacher> findAllTeacherByInfo(String name) {
		String sql="select * from teacher";
		if(!"".equals(name)) {
			sql +=" where name like '%"+name+"%'";
		}
		List teaList=new ArrayList();
		try {
			teaList=db.getQueryList(sql);
		} catch (Exception e) {
			/**
			 * 除了异常后 teaList有可能是null 或者出了异常后，程序执行有问题
			 */
			teaList=new ArrayList();
			e.printStackTrace();
		}
		return teaList;
	}

	@Override
	public void addTeacher(Teacher teacher) {
		String sql="INSERT INTO teacher (name,pwd,deptName) values (?,?,?)";
		try {
			db.execute(sql,new Object[] {teacher.getName(),teacher.getPwd(),teacher.getDeptName()});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateTeacher(Teacher tea, int oldId) {
		String sql="UPDATE teacher SET name =?, pwd = ?, deptName = ? WHERE id = ?";
		try {
			db.execute(sql, new Object[]{tea.getName(),tea.getPwd(),tea.getDeptName(),oldId});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> findTeacherInfo(int id) {
		String sql="SELECT * FROM teacher WHERE id= ?";
		Map teaMap=new HashMap();
		try {
			teaMap = db.getObject(sql, new Object[] {id});
		} catch (Exception e) {
			teaMap=new HashMap();
			e.printStackTrace();
		}
		return teaMap;
	}

	@Override
	public List<Map<String, Object>> findClassesByTeacherId(int teacherId) {
		String sql="SELECT * FROM teacher WHERE id= ?";
		List tealist=new ArrayList();
		try {
			tealist=db.getQueryList(sql, new Object[] {teacherId});
		} catch (Exception e) {
			tealist=new ArrayList();
			e.printStackTrace();
		}
		return tealist;
	}

	@Override
	public void deleteStuClassById(int id) {
		String sql="DELETE FROM teacher WHERE id=?";
		try {
			db.execute(sql, new Object[] {id});
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Override
	public List<Map<String, Object>> findAllTeacher() {
		String sql="SELECT * FROM teacher";
		List teaNlist=new ArrayList();
		try {
			teaNlist=db.getQueryList(sql);
		} catch (Exception e) {
			teaNlist=new ArrayList();
			e.printStackTrace();
		}
		return teaNlist;
	}

}
