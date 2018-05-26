package com.sdut.onlinexam.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sdut.onlinexam.po.Course;
import com.sdut.onlinexam.po.Teacher;
import com.sdut.onlinexam.po.TeacherCourse;
import com.sdut.onlinexam.po.Test;

public class DBUtilQueryTest {

	public static void main(String[] args) throws Exception {
		DBUtil db = new DBUtil();
		String sql="select * from test";
		/**
		 * 含一个参数
		 */
		List<Map<String,Object>> testList = db.getQueryList(sql);
		System.out.println(testList);
		System.out.println("带一个参数时：");
		for(int i = 0; i<testList.size();i++) {			//不保证返回值为NULL
			Map<String,Object> testMap = testList.get(i);
			Iterator <Entry<String,Object>> it=testMap.entrySet().iterator();
			while(it.hasNext()) {
				Entry<String,Object> entry = it.next();
				System.out.print(entry.getKey()+"@@@"+entry.getValue()+"  ");
			}
			System.out.println();
		}
		/**
		 * 含两个参数
		 */
		String sql2="select * from test where courseId=? and teacherId=?";
		List<Map<String,Object>> testList2 = db.getQueryList(sql2, new Object[] {1,2});
		System.out.println("带两个参数时：");
		for(int i = 0; i<testList.size();i++) {
			Map<String,Object> testMap = testList.get(i);
			Iterator <Entry<String,Object>> it=testMap.entrySet().iterator();
			while(it.hasNext()) {
				Entry<String,Object> entry = it.next();
				System.out.print(entry.getKey()+"@@@"+entry.getValue()+"  ");
			}
			System.out.println();
		}
		/**
		 * 数组是同一类相同数据类型的集合
		 * 声明仅仅是定义数据类型和变量名
		 * 定义：除了声明外，有赋值；
		 * 数组声明时，[]可以放在变量前也可以放在变量后
		 */
		String []a;
		String aa[];
		String []aaa = new String[] {"pg_One","xiDu"};
		String []aaa4= {"pg_One"};
		String[] strArray5=new String[5];
		
		/**
		 * 第三种方法，含三个参数
		 */
		System.out.println("带三个参数时：");
		List testObjectList = db.getQueryList(Test.class, sql2, new Object[] {1,2});
		for(Object o: testObjectList) {
			Test t= (Test)o;
			System.out.println(t);
		}
		/**
		 * 练习 
		 * 1.姓"zhang"的学生的成绩，查询结果包括学生姓名
		 * 2.查询"lisi"排课表
		 * 3.查询所有试题信息
		 */
		System.out.println("练习：");
		String sql3="select student.name ,papers.score from student,papers where student.id=papers.studentId and student.name like 'zhang%'";
		List<Map<String,Object>> testList3 = db.getQueryList(sql3);
		System.out.println("1:"+testList3);
		
		String sql4="select course.name from teacher,course,teachercourse where teacher.id=course.id and teacher.id=course.id and teacher.name=?";
		List<Map<String,Object>> testList4 = db.getQueryList(sql4,new Object[] {"lisi"});
		System.out.println("2:"+testList4);
		
		String sql5="select * from papers";
		List<Map<String,Object>> testList5 = db.getQueryList(sql5);
		System.out.println("3:"+testList5);
	}
}
