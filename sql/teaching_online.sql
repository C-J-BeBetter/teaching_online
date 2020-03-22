/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : teaching_online

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 21/03/2020 20:07:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for l_commit_work_info
-- ----------------------------
DROP TABLE IF EXISTS `l_commit_work_info`;
CREATE TABLE `l_commit_work_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件ID',
  `file_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名',
  `path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '目录',
  `score` decimal(3, 2) NULL DEFAULT NULL COMMENT '分数',
  `commit_user_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联提交人id',
  `commit_user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联提交人姓名',
  `commit_time` datetime(0) NULL DEFAULT NULL COMMENT '提交时间',
  `correct_user_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联审批人id',
  `correct_user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联审批人姓名',
  `correct_time` datetime(0) NULL DEFAULT NULL COMMENT '审批时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `88`(`commit_user_id`) USING BTREE,
  INDEX `99`(`correct_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1582 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '提交作业信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of l_commit_work_info
-- ----------------------------


-- ----------------------------
-- Table structure for l_learning_record_info
-- ----------------------------
DROP TABLE IF EXISTS `l_learning_record_info`;
CREATE TABLE `l_learning_record_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件ID',
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '笔记内容',
  `user_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联学员ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1582 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学习记录信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of l_learning_record_info
-- ----------------------------

-- ----------------------------
-- Table structure for l_work_reply_info
-- ----------------------------
DROP TABLE IF EXISTS `l_work_reply_info`;
CREATE TABLE `l_work_reply_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '回复ID',
  `reply` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复内容',
  `reply_from_user_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复人id',
  `reply_from_user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复人姓名',
  `reply_to_user_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复对象id',
  `reply_to_user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复对象姓名',
  `reply_time` datetime(0) NULL DEFAULT NULL COMMENT '回复时间',
  `wb_id` int(11) NULL DEFAULT NULL COMMENT '关联作业成绩id',
  `wb_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联作业名',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `1010`(`reply_from_user_id`) USING BTREE,
  INDEX `1011`(`reply_to_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1582 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '作业讨论答疑信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of l_work_reply_info
-- ----------------------------

-- ----------------------------
-- Table structure for t_upload_learning_file_info
-- ----------------------------
DROP TABLE IF EXISTS `t_upload_learning_file_info`;
CREATE TABLE `t_upload_learning_file_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资料ID',
  `file_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资料名',
  `path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '目录',
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `user_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联上传人员id',
  `user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联上传人员姓名',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `11`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1583 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '上传学习资料信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_upload_learning_file_info
-- ----------------------------
INSERT INTO `t_upload_learning_file_info` VALUES (1582, '数学', 'D:/learning', NULL, '1', '张三', '2020-03-20 22:06:56', '2020-03-20 22:07:00');

-- ----------------------------
-- Table structure for t_upload_work_file_info
-- ----------------------------
DROP TABLE IF EXISTS `t_upload_work_file_info`;
CREATE TABLE `t_upload_work_file_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件ID',
  `file_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名',
  `path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '目录',
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `user_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联上传人员id',
  `user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联上传人员姓名',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1582 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '上传作业信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_upload_work_file_info
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
