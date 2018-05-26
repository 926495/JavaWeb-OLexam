package com.sdut.onlinexam.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.sdut.onlinexam.po.Course;
import com.sdut.onlinexam.po.Test;
/**
 * 查询
 * @author Yl-Lin
 *
 */
public class DBUtilTest {

	public static void main(String[] args) throws Exception {
		String sql="select * from course where name='Java'";
		DBUtil db=new DBUtil();
		/**
		 * 如果一个方法是静态方法，可以是使用类名，方法调用
		 * 如果一个方法是普通方法，则需要使用构造方法创建对象调用
		 * 
		 * 数组：一旦创建了数组，大小不可变
		 * 集合框架： List,Set,Map
		 * Map的优势在于，使用键值对，使用键值对的好处是，键是唯一的，可以通过键获取值
		 * 
		 * 如果调用的方法上有抛异常throws**Exception
		 * 在使用方法的时候有两种解决方式：
		 * 1.try-ccatch包裹，异常处理
		 * 2.继续在本方法的方法体上继续抛出异常（推荐）
		 * 
		 * Java里通过包名区分类名相同的情况  exg：java.util.map
		 * 
		 * <>表示泛型，好处是对键值类型说明
		 * Map<String,Object> getObject(sql)
		 * 适用场景：
		 * 1.sql已经提前知道
		 * 2.参数较少，写到sql语句里
		 * 3.可以用来获取对象，获取对象的形式是键值对
		 * 4.尤其用于多表无法封装成一个对象的场景
		 * 5.适用于查找一条记录
		 */
		Map<String,Object> courseMap = db.getObject(sql);
		/**
		 * debug模式和run模式
		 * 开发一般采用debug
		 * 优势：可以看到中间的过程，能够在自己关注的代码暂停
		 * 能够一行行执行代码
		 * 在自己关注的代码左侧双击可以打断点
		 * 如果debug模式没有任何断点，则和run模式一样
		 */
		System.out.println(courseMap);
		/**
		 * map遍历使用iterator
		 * map的存储方式使用键值对，entry可以理解为键值对
		 */
		Iterator <Entry<String,Object>> it=courseMap.entrySet().iterator();
		while(it.hasNext()) {
			Entry<String,Object> entry = it.next();
			System.out.println(entry.getKey()+"@@@"+entry.getValue());
		}
		/**
		 * 在一个方法种，变量不能定义两次
		 * 
		 * 
		 * 方法二
		 */
		String sql2="select * from course where name=?";
		Map<String,Object> courseMap2= db.getObject(sql2, new Object[] {"Java"});
		System.out.println(courseMap2);
		/**
		 * test表查询
		 */
		String sql3="select * from test where courseId=? and teacherId=?";
		Map<String,Object> courseMap3= db.getObject(sql3, new Object[] {"1",2});
		System.out.println(courseMap3);
		/**
		 * 方法三
		 * 封装成类Course的对象，可以调用类方法
		 * getObject(type, sql3, paramList)
		 * 第一个参数表示要封装成的类类型
		 * type需要是我们提供的po或vo层，String这种不行
		 * 返回结果是封装好的po或vo，需要强制转换
		 */
		Course c=(Course)db.getObject(Course.class, sql2, new Object[] {"Java"});
		System.out.println("方法三："+c.getName());
		/**
		 * 方法三练习
		 * Test表
		 */
		Test t=(Test)db.getObject(Test.class, sql3, new Object[] {"1",2});
		System.out.println("方法三练习："+"  ID:"+t.getId()+"  姓名："+t.getName()+"  课程号"+t.getCourseId()+"  结束日期："+t.getEndDate()+"  测试时间："+t.getTestTime()+"  问题："+t.getQuestions()+"  教师号："+t.getTeacherId()+"  班级号："+t.getClassIds()+"  成绩："+t.getScores());
	}
}