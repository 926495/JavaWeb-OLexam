package com.sdut.onlinexam.dao.admin;

import com.sdut.onlinexam.po.StuClass;
import com.sdut.onlinexam.util.DBUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StuClassDao implements IStuClassDao {

	private DBUtil db = new DBUtil();

	@Override
	public List findAllStuClassInfo() {
		String sql = "SELECT * FROM stuclass";
		List stuClassList = new ArrayList();
		try {
			stuClassList = db.getQueryList(StuClass.class, sql, new Object[] {});
		} catch (Exception e) {
			stuClassList = new ArrayList();
			e.printStackTrace();
		}
		return stuClassList;
	}

	@Override
	public Map<String, Object> findStuClassById(int classId) {
		String sql="select * from stuclass where id=?";
		Map<String,Object> stuMap=new HashMap<String,Object>();
		 try {
			stuMap=db.getObject(sql, new Object[] {classId});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stuMap;
	}

	@Override
	public void addStuClass(StuClass sc) {
		String sql="INSERT INTO stuclass (name,deptName) values (?,?)"; 
		try {
			db.execute(sql, new Object[] {sc.getName(),sc.getDeptName()});
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void updateStuClassById(StuClass sc) {
		String sql="UPDATE stuclass SET name =?, deptName = ? WHERE id = ?";
		try {
			db.execute(sql, new Object[]{sc.getName(),sc.getDeptName(),sc.getId()});
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public String findClassNamesByIds(String ids) {
		String sql="SELECT name FROM stuclass WHERE id in("+ids+")";
		List<Map<String,Object>> nameList =new ArrayList();
		try {
			nameList=db.getQueryList(sql);
		} catch (Exception e) {
			nameList =new ArrayList();
			e.printStackTrace();
		}
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<nameList.size();i++){
			sb.append(nameList.get(i).get("name")+" ");
		}
		return sb.toString();
		
	}

	@Override
	public List<StuClass> findStuClassesByTeacherId(int teaId) {
		return null;
	}

	@Override
	public void deleteStuClassById(int id) {
		String sql="DELETE FROM stuclass WHERE id = ?";
		try {
			db.execute(sql, new Object[]{id});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		/**
		 *
		 * 声明的时候一般向上转型，向上转型有父类和子类的关系
		 * 也有接口和实现类之间的关系
		 * 
		 * 优点之一：
		 * 如果这个接口有多个实现，如Dao2
		 * 使用向上转型，直接改定义这一行,多个stuClassDao可以使用同一个scd调用
		 */
		IStuClassDao scd = new StuClassDao();
		List scList = scd.findAllStuClassInfo();
		String s= scd.findClassNamesByIds("1,2");
		System.out.println(s);
	}

}
