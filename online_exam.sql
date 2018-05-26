/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : online_exam

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-01-19 15:08:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bigquestion
-- ----------------------------
DROP TABLE IF EXISTS `bigquestion`;
CREATE TABLE `bigquestion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(9) DEFAULT NULL,
  `courseId` int(11) NOT NULL,
  `title` varchar(2000) DEFAULT NULL,
  `contentAns` varchar(4000) DEFAULT NULL,
  `spare` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bigquestion
-- ----------------------------

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', 'Java');
INSERT INTO `course` VALUES ('2', 'Mysql');
INSERT INTO `course` VALUES ('3', 'Web');
INSERT INTO `course` VALUES ('4', 'Oricle');

-- ----------------------------
-- Table structure for papers
-- ----------------------------
DROP TABLE IF EXISTS `papers`;
CREATE TABLE `papers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `testId` int(11) NOT NULL,
  `courseId` int(11) NOT NULL,
  `time` varchar(11) NOT NULL,
  `score` double(11,3) NOT NULL,
  `wrongQueld` varchar(1000) DEFAULT NULL,
  `wrongAns` varchar(1000) DEFAULT NULL,
  `studentId` int(11) NOT NULL,
  `createDate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of papers
-- ----------------------------
INSERT INTO `papers` VALUES ('1', '3', '3', '0分2秒', '0.000', '3,5', 'C,D', '3', '2018-01-16 20:53:33');
INSERT INTO `papers` VALUES ('3', '3', '3', '0分4秒', '100.000', '', '', '4', '2018-01-17 09:46:17');

-- ----------------------------
-- Table structure for questions
-- ----------------------------
DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) NOT NULL,
  `queType` int(11) NOT NULL,
  `queTitle` varchar(1000) NOT NULL,
  `choiceA` varchar(1000) NOT NULL,
  `choiceB` varchar(1000) NOT NULL,
  `choiceC` varchar(1000) NOT NULL,
  `choiceD` varchar(1000) NOT NULL,
  `ans` varchar(50) NOT NULL,
  `queExist` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questions
-- ----------------------------
INSERT INTO `questions` VALUES ('1', '1', '1', '乱码如何解决？', 'Yes', 'Yes', 'Yes', 'N', 'D', '1');
INSERT INTO `questions` VALUES ('2', '2', '1', '页面跳转的方式？', 'N', 'Y', 'Y', 'Y', 'A', '1');
INSERT INTO `questions` VALUES ('3', '3', '1', 'Jscript如何传参数？', 'N', 'Y', 'N', 'N', 'B', '1');
INSERT INTO `questions` VALUES ('4', '3', '1', '如何进行Web前端设计？', 'Y', 'N', 'N', 'N', 'A', '1');
INSERT INTO `questions` VALUES ('5', '3', '1', 'JavaWeb多态？', 'N', 'N', 'N', 'Y', 'D', '1');

-- ----------------------------
-- Table structure for stuclass
-- ----------------------------
DROP TABLE IF EXISTS `stuclass`;
CREATE TABLE `stuclass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '班级名称',
  `deptName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stuclass
-- ----------------------------
INSERT INTO `stuclass` VALUES ('1', '计科1501', '开发');
INSERT INTO `stuclass` VALUES ('2', '计科1502', '测试');
INSERT INTO `stuclass` VALUES ('3', '计科1503', '开发');
INSERT INTO `stuclass` VALUES ('4', '计科1504', '开发');
INSERT INTO `stuclass` VALUES ('5', '软件1506', '测试');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '学生姓名',
  `pwd` varchar(50) NOT NULL COMMENT '学生密码',
  `school` varchar(50) NOT NULL COMMENT '学校名称',
  `sex` varchar(50) NOT NULL,
  `born` date NOT NULL,
  `classId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '杨', '123', '清华', '男', '1996-01-01', '1');
INSERT INTO `student` VALUES ('2', '李', '456', '北大', '女', '1996-05-09', '2');
INSERT INTO `student` VALUES ('3', 'yang', '11', 'SDUT', '男', '1996-11-12', '3');
INSERT INTO `student` VALUES ('4', '张全蛋', 'tttt', '香港科技大学', '男', '1996-09-09', '3');
INSERT INTO `student` VALUES ('5', 'ppp', 'pp', '1', '女', '1996-09-09', '2');
INSERT INTO `student` VALUES ('6', 'p', 'p', '1p', '女', '1999-09-09', '4');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `pwd` varchar(100) NOT NULL,
  `deptName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '赵', '123', '开发');
INSERT INTO `teacher` VALUES ('2', '李', '456', '测试');
INSERT INTO `teacher` VALUES ('3', '杨', '1', '开发');
INSERT INTO `teacher` VALUES ('25', '孙', '7k', '开发');

-- ----------------------------
-- Table structure for teachercourse
-- ----------------------------
DROP TABLE IF EXISTS `teachercourse`;
CREATE TABLE `teachercourse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) NOT NULL,
  `teaId` int(11) NOT NULL,
  `classId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teachercourse
-- ----------------------------
INSERT INTO `teachercourse` VALUES ('1', '1', '1', '1');
INSERT INTO `teachercourse` VALUES ('2', '2', '2', '2');
INSERT INTO `teachercourse` VALUES ('3', '3', '3', '3');
INSERT INTO `teachercourse` VALUES ('4', '2', '1', '2');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `courseId` int(11) NOT NULL,
  `endDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `testTime` int(11) NOT NULL,
  `questions` varchar(2000) NOT NULL,
  `teacherId` int(11) NOT NULL,
  `classIds` varchar(2000) NOT NULL,
  `scores` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', 'JavaScript', '3', '2018-01-18 19:35:25', '90', '4,3,5', '3', '1,3,4', '100');
INSERT INTO `test` VALUES ('2', 'Web测试', '3', '2018-01-16 10:29:11', '45', '3,5,7', '3', '1,2,3,4', '120');
INSERT INTO `test` VALUES ('3', 'Web渗透', '3', '2018-02-16 10:37:50', '45', '5,3', '3', '1,2,3', '120');
INSERT INTO `test` VALUES ('4', 'Web进阶', '3', '2018-02-16 10:29:17', '60', '3,4,5,7', '3', '1,2,3,4', '120');
INSERT INTO `test` VALUES ('5', '数据挖掘', '2', '2018-01-19 09:15:35', '45', '2', '3', '1,2,3,4', '122');
INSERT INTO `test` VALUES ('6', '抓包测试', '3', '2018-01-30 10:45:42', '45', '5,3', '3', '1,2,3,4,5', '120');
