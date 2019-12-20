/*
 Navicat Premium Data Transfer

 Source Server         : 61.163.34.143
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 61.163.34.143:33061
 Source Schema         : zzlife

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 20/12/2019 17:37:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for decorate
-- ----------------------------
DROP TABLE IF EXISTS `decorate`;
CREATE TABLE `decorate`  (
  `Id` int(100) NOT NULL,
  `taxon` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `state` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '0',
  `begin_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `is_not` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '0',
  `standby1` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `standby2` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `standby3` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for decorate_sudecoratebset
-- ----------------------------
DROP TABLE IF EXISTS `decorate_sudecoratebset`;
CREATE TABLE `decorate_sudecoratebset`  (
  `Id` bigint(100) NOT NULL,
  `decorate_id` bigint(100) NOT NULL,
  `taxon` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `state` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '0',
  `begin_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `Is_not` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `standby1` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `standby2` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `standby3` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `id` int(100) NOT NULL,
  `mission_id` int(100) NOT NULL,
  `order_id` int(100) NOT NULL,
  `appraiser_id` int(100) NOT NULL,
  `grade` int(10) NOT NULL,
  `begin_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `Is_not` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `standby1` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `standby2` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `standby3` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mission
-- ----------------------------
DROP TABLE IF EXISTS `mission`;
CREATE TABLE `mission`  (
  `Id` int(100) NOT NULL AUTO_INCREMENT,
  `user_id` int(100) NOT NULL,
  `area` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `longitude` double(11, 8) NULL DEFAULT NULL,
  `latitude` double(11, 8) NULL DEFAULT NULL,
  `sort` int(100) NULL DEFAULT NULL,
  `title` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `describel` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `img` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `contact` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `c_phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `order_id` int(100) NULL DEFAULT NULL,
  `evaluate` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `state` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '0',
  `begin_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `Is_not` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `standby1` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '0个人1企业',
  `standby2` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '0电力服务1水力服务',
  `standby3` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '工作时间',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mission
-- ----------------------------
INSERT INTO `mission` VALUES (2, 1, NULL, '信阳市高新区XXXXX', NULL, NULL, 0, '电灯坏了', '家里电网莫名坏了', NULL, NULL, NULL, 0, NULL, '0', '2019-12-17 14:39:37', NULL, '\0', '0', '电力服务', '2019-12-15');
INSERT INTO `mission` VALUES (4, 1, NULL, '信阳市高新区XXXXX', NULL, NULL, 0, '水管破损', '家里水管爆了速来', NULL, NULL, NULL, 0, NULL, '0', '2019-12-17 14:41:25', NULL, '\0', '0', '水力服务', '2019-12-15');
INSERT INTO `mission` VALUES (6, 1, NULL, '信阳市高新区XXXXX', NULL, NULL, 0, '小区水利管道重置', 'xx小区水利管道重置', NULL, NULL, NULL, 0, NULL, '0', '2019-12-17 14:56:46', NULL, '\0', '1', '水力服务', '约4个月');

-- ----------------------------
-- Table structure for sys_user_electric
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_electric`;
CREATE TABLE `sys_user_electric`  (
  `id` int(100) NOT NULL COMMENT 'Id(自增长无符号整数)',
  `user_id` int(100) NOT NULL COMMENT '用户表id',
  `electric_user_no` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用电户用户号',
  `meter_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电表编号',
  `area_code` varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属台区编码',
  `area_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属台区名称',
  `electric_user_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用电户类型(规范数据项：1.家庭 2.单位)',
  `unit_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位名称(用电户类型为单位时填写)',
  `master_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位负责人或家庭户主姓名',
  `master_id` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位负责人或家庭户主身份证号码',
  `master_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位负责人或家庭户主电话号码',
  `registrant_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册人姓名',
  `registrant_id` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册人个人身份证号',
  `registrant_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册人联系电话',
  `electric_fee_list_sample_url` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电费单样例照片存放位置',
  `registrant_photo_url` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册人照片文件存放位置',
  `begin_time` datetime(0) NOT NULL COMMENT '数据插入时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '数据更改时间',
  `is_not` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否删除(默认0正常1删除)',
  `standby1` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段1',
  `standby2` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `standby3` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`, `meter_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_firm
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_firm`;
CREATE TABLE `sys_user_firm`  (
  `id` int(100) NOT NULL,
  `user_id` int(100) NOT NULL COMMENT '用户表id',
  `frim_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '企业名称',
  `frim_img` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '企业营业执照',
  `intro` varchar(70) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '企业简介',
  `begin_time` datetime(0) NULL DEFAULT NULL COMMENT '数据插入时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '数据更改时间',
  `is_not` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否删除(默认0正常1删除)',
  `standby1` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段1',
  `standby2` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `standby3` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  `standby4` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `standby5` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `standby6` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_name
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_name`;
CREATE TABLE `sys_user_name`  (
  `id` int(100) NOT NULL COMMENT 'Id(主键，自增长无符号整数)',
  `user_id` int(100) NOT NULL COMMENT '用户表id',
  `id_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `begin_time` datetime(0) NOT NULL COMMENT '数据插入时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '数据更改时间',
  `is_not` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否删除(默认0正常1删除)',
  `standby1` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段1',
  `standby2` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `standby3` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_name
-- ----------------------------
INSERT INTO `sys_user_name` VALUES (0, 1, '411522166666', '程', '2019-12-17 14:51:35', NULL, '\0', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_user_profession
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_profession`;
CREATE TABLE `sys_user_profession`  (
  `id` int(100) NOT NULL COMMENT 'Id(主键，自增长无符号整数)',
  `user_id` int(100) NOT NULL COMMENT '用户表id',
  `profession_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职业名称',
  `img` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '证件图片',
  `deadline` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '证件有效期间',
  `begin_time` datetime(0) NOT NULL COMMENT '数据插入时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '数据更改时间',
  `is_not` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否删除(默认0正常1删除)',
  `standby1` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段1',
  `standby2` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `standby3` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_profession1
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_profession1`;
CREATE TABLE `sys_user_profession1`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NULL DEFAULT NULL,
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `user_cid` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `introduce` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `service_area` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `state` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_profession1
-- ----------------------------
INSERT INTO `sys_user_profession1` VALUES (2, 0, '123', '22222', '低昂', '10年', '666', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(100) NOT NULL AUTO_INCREMENT COMMENT 'uuid主键',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账户名(登录号默认手机号)',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickname` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称(默认为手机号活号)',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别(0男1女)',
  `age` int(5) NULL DEFAULT NULL COMMENT '年龄',
  `head_img` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `profession` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业(多职业用逗号隔开)',
  `real_name` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否实名(默认0未认证1认证)',
  `real_enterprise` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否企业认证(默认0未认证1认证中2已认证)',
  `real_electro` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否用电信息认证(默认0未认证1认证中2已认证)',
  `real_occupation` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业认证(职业)',
  `begin_time` datetime(0) NOT NULL COMMENT '数据插入时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '数据更改时间',
  `is_not` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否删除(默认0正常1删除)',
  `standby1` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段1',
  `standby2` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `standby3` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '阿鑫', '1234', '15617105157', '784717017@qq', '阿鑫', '1', 18, '1', '电工', '0', '0', '0', '0', '2019-12-14 08:43:17', '2019-12-17 15:29:20', '\0', NULL, NULL, NULL);
INSERT INTO `user` VALUES (2, NULL, '123', '18790103833', '545@qq.com', '阿想', '\0', 0, NULL, NULL, '0', '0', '0', '0', '2019-12-17 14:32:25', NULL, '\0', NULL, NULL, NULL);
INSERT INTO `user` VALUES (6, NULL, '123456', '31123412341', '123456@qq.com', 'nick', '\0', 0, NULL, NULL, '0', '0', '0', '0', '2019-12-19 20:42:23', NULL, '\0', NULL, NULL, NULL);
INSERT INTO `user` VALUES (8, NULL, '123456', '123456', '123456@qq.com', '123456', '\0', 0, NULL, NULL, '0', '0', '0', '0', '2019-12-19 20:51:52', NULL, '\0', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
