package com.sdut.onlinexam.dao.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sdut.onlinexam.po.Test;
import com.sdut.onlinexam.util.DBUtil;

public class TestDao implements ITestDao {

	private DBUtil db=new DBUtil();
	@Override
	public void createTest(Test t) {
		String sql="INSERT INTO test (courseId,testTime,teacherId,name,questions,classIds,scores,endDate) VALUES(?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql,new Object[] {t.getCourseId(),t.getTestTime(),t.getTeacherId(),t.getName(),t.getQuestions(),t.getClassIds(),t.getScores(),t.getEndDate()});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Map<String, Object>> findTestsByTeaId(int teaId) {
		String sql="SELECT t.classIds,t.id,c.name courseName,t.name,t.endDate,t.testTime,t.scores FROM test t,course c WHERE t.courseId=c.id AND t.teacherId=?";
		List<Map<String, Object>> testsList = new ArrayList<Map<String, Object>>();
		try {
			testsList=db.getQueryList(sql, new Object [] {teaId});
		} catch (Exception e) {
			testsList = new ArrayList<Map<String, Object>>();
			e.printStackTrace();
		}
		return testsList;
	}

	@Override
	public Map<String, Object> findTestById(int id, int teaId) {
		String sql="SELECT t.*,c.name cName,GROUP_CONCAT(sc.name) className FROM test t,course c,stuclass sc WHERE  t.courseId=c.id  AND FIND_IN_SET(sc.id,t.classIds) AND t.id=? AND t.teacherId=? GROUP BY t.id";
		Map<String, Object> testMap = new HashMap<String, Object>();
		try {
			testMap=db.getObject(sql, new Object[] {id,teaId});
		} catch (Exception e) {
			testMap = new HashMap<String, Object>();
			e.printStackTrace();
		}
		return testMap;
	}

	@Override
	public Map<String, Object> findStudentTestsById(int studentid, int testid) {
		String sql="SELECT t.*,c.name courseName,sc.name className FROM test t,student stu,course c,stuclass sc WHERE sc.id=stu.classId AND t.courseId = c.id AND FIND_IN_SET(stu.classId,t.classIds) AND t.id=? AND stu.id =? ";
		Map testMap = new HashMap();
		try {
			testMap = db.getObject(sql, new Object[] {testid,studentid});
		} catch (Exception e) {
			testMap = new HashMap();
			e.printStackTrace();
		}
		return testMap;
	}

	@Override
	public List<Map<String, Object>> getTestByStudent(int id, String currData) {
		//String sql="select t.id,t.name  as testName,t.endDate,t.courseId,c.name  as courseName from test  t,course c,student s where t.endDate > ? and s.id = ? and c.id = t.courseId and FIND_IN_SET(c.id,t.classIds) and t.id not in(select testId from papers)";
		String sql="select t.id,t.name  as testName,t.endDate,t.courseId,c.name  as courseName from test  t,course c,student s where t.endDate > ? and s.id = ? and c.id = t.courseId and FIND_IN_SET(c.id,t.classIds) and t.id not in(select testId from papers where s.id=?)";
		List<Map<String, Object>> testList = new ArrayList();
		try {
			testList = db.getQueryList(sql, new Object[] {currData,id,id});
		} catch (Exception e) {
			testList = new ArrayList();
			e.printStackTrace();
		}
		return testList;
	}

}
