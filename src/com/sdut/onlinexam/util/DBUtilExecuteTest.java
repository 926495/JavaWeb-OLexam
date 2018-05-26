package com.sdut.onlinexam.util;

/**
 * execute 练习
 * @author Yl-Lin
 *
 */
public class DBUtilExecuteTest {
	
	public static void main(String[] args) throws Exception {
		DBUtil db=new DBUtil();
		/**
		 * insert语句   insert+表名
		 * 如果是插入所有的列，则+values（值1，值2）
		 * 如果插入部分字段，在表名后，（字段1，字段2.。。）
		 */
		//String sql="INSERT INTO course  values (16,'ssh')";
		String sql="INSERT INTO course (name) values ('ssh')";  //其余字段需要默认/自动生成
		db.execute(sql);
		//String sql2="INSERT INTO course values (?,?)";
		//db.execute(sql2, new Object[] {16,"vrml"});
		/**
		 * execute用于增/删/改
		 */
		String sql2="INSERT INTO course (name) values (?)";
		db.execute(sql2, new Object[] {"vrml"});
		/**
		 * 删除
		 */
		String sql3="DELETE FROM course WHERE name = ?";
		db.execute(sql3, new Object[] {"vrml"});
	}

}