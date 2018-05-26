package com.sdut.onlinexam.dao.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sdut.onlinexam.po.Question;
import com.sdut.onlinexam.util.DBUtil;

public class QuestionDao implements IQuestionDao {

	private DBUtil db = new DBUtil();

	@Override
	public List<Map<String, Object>> findAllQuestionInfo(String key, String value) {
		String sql = "SELECT q.id,q.courseId,q.queType,q.queTitle,q.choiceA,q.choiceB,q.choiceC,q.choiceD,q.ans,c.name from questions q,course c WHERE q.courseId=c.id";
		if (null != key && !"".equals(key)) {
			sql += " and " + key + " like '%" + value + "%'";
		}
		List<Map<String, Object>> queList = new ArrayList<Map<String, Object>>();
		try {
			queList = db.getQueryList(sql, new Object[] {});
		} catch (Exception e) {
			queList = new ArrayList<Map<String, Object>>();
			e.printStackTrace();
		}
		return queList;
	}

	@Override
	public void addQuestion(Question q) {
		String sql = "INSERT INTO questions (courseId,queType,queTitle,choiceA,choiceB,choiceC,choiceD,ans) VALUES (?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] { q.getCourseId(),  q.getQueTitle(), q.getChoiceA(),
					q.getChoiceB(), q.getChoiceC(), q.getChoiceD(), q.getAns() });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> findQuestionById(int id) {
		String sql = "SELECT * FROM questions WHERE id = ?";
		Map<String, Object> quesMap = new HashMap<String, Object>();
		try {
			quesMap = db.getObject(sql, new Object[] {id});
		} catch (Exception e) {
			quesMap = new HashMap<String, Object>();
			e.printStackTrace();
		}
		return quesMap;
	}

	@Override
	public List<Question> findQuestionByIds(String ids) {
		String sql="SELECT * FROM questions where FIND_IN_SET(id,?)";
		List quesList = new ArrayList(); 
		try {
			quesList= db.getQueryList(Question.class,sql, new Object[] {ids});
		} catch (Exception e) {
			quesList = new ArrayList(); 
			e.printStackTrace();
		}
		return quesList;
	}

	@Override
	public void updateQuestionInfo(Question q) {
		String sql="UPDATE questions SET courseId=?,queTitle=?,choiceA=?,choiceB=?,choiceC=?,choiceD=?,ans=? WHERE id=?";
		try {
			db.execute(sql, new Object[] {q.getCourseId(),q.getQueTitle(),q.getChoiceA(),q.getChoiceB(),q.getChoiceC(),q.getChoiceD(),q.getAns(),q.getId()});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Map<String, Object>> findQuestionsByCourseId(int courseId) {
		String sql="SELECT * FROM questions WHERE courseId=?";
		List<Map<String, Object>> courList =new ArrayList();
		try {
			courList=db.getQueryList(sql, new Object[] {courseId});
		} catch (Exception e) {
			courList =new ArrayList();
			e.printStackTrace();
		}
		return courList;
	}

	@Override
	public void deleteQuestion(int id) {
		String sql="DELETE FROM questions WHERE id =?";
		try {
			db.execute(sql,new Object[] {id});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List getWQuesByPaperId(int pId) {
		String sql="SELECT t.name tName,c.name courName,sc.name className,t.endDate,t.testTime,q.queTitle,p.wrongAns,q.ans FROM stuclass sc, student s, papers p,test t,questions q,course c WHERE p.testId = t.id AND FIND_IN_SET(q.id,p.wrongQueld) AND p.courseId=c.id AND p.studentId=s.id AND s.classId=sc.id AND p.id=?";
		List wquesList = new ArrayList();
		try {
			wquesList=db.getQueryList(sql, new Object[] {pId});
		} catch (Exception e) {
			wquesList = new ArrayList();
			e.printStackTrace();
		}
		return wquesList;
	}
}
