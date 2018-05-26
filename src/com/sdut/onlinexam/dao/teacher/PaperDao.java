package com.sdut.onlinexam.dao.teacher;

import java.util.ArrayList;
import java.util.List;

import com.sdut.onlinexam.po.Paper;
import com.sdut.onlinexam.util.DBUtil;

public class PaperDao implements IPaperDao {

	private DBUtil db = new DBUtil();

	@Override
	public int save(Paper paper) {
		String sql = "INSERT INTO papers (testId,courseId,time,score,wrongQueld,wrongAns,studentId,createDate) VALUES (?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] { paper.getTestId(), paper.getCourseId(), paper.getTime(), paper.getScore(),
					paper.getWrongQueId(), paper.getWrongAns(), paper.getStudentId(), paper.getCreateDate() });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List getPaperByStudentId(int studentId, int testId) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List getPaperByStudentId(int studentId) {
		String sql = "SELECT p.id pId,t.id tId,c.name courseName,t.name testName,p.time,p.createDate,p.score FROM papers p,course c,test t WHERE p.courseId=c.id AND p.testId=t.id AND p.studentId =?";
		List paperList = new ArrayList();
		try {
			paperList = db.getQueryList(sql, new Object[] { studentId });
		} catch (Exception e) {
			paperList = new ArrayList();
			e.printStackTrace();
		}
		return paperList;
	}

	@Override
	public List getPaperCompare(int teaId) {
		//String sql="SELECT sc.name className,c.name courseName,t.name testName,t.endDate,sc.deptName FROM teachercourse tc, papers p,stuclass sc,course c,test t WHERE p.courseId=c.id AND p.testId=t.id AND tc.courseId=c.id AND tc.classId=sc.id AND tc.teaId=?";
		String sql="SELECT sc.name className,c.name courseName,t.name testName,t.endDate,sc.deptName,AVG(p.score) avgScore FROM teachercourse tc, papers p,stuclass sc,course c,test t WHERE p.courseId=c.id AND p.testId=t.id AND tc.courseId=c.id AND tc.classId=sc.id AND tc.teaId=?";
		List paperList =new ArrayList();
		try {
			paperList=db.getQueryList(sql, new Object[] {teaId});
		} catch (Exception e) {
			paperList =new ArrayList();
			e.printStackTrace();
		}
		return paperList;
	}

}
