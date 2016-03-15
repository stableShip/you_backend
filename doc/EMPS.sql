/*
Navicat MySQL Data Transfer

Source Server         : LOCALHOST
Source Server Version : 50546
Source Host           : localhost:3306
Source Database       : epms

Target Server Type    : MYSQL
Target Server Version : 50546
File Encoding         : 65001

Date: 2016-03-15 19:51:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_accounts
-- ----------------------------
DROP TABLE IF EXISTS `t_accounts`;
CREATE TABLE `t_accounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(40) NOT NULL COMMENT '管理员账号',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `name` varchar(40) NOT NULL COMMENT '用户名',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `last_update_date` datetime NOT NULL COMMENT '最近修改时间',
  `last_update_login` datetime NOT NULL COMMENT '最近登录时间',
  PRIMARY KEY (`id`),
  KEY `index` (`account`,`password`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='账号基础表';

-- ----------------------------
-- Records of t_accounts
-- ----------------------------
INSERT INTO `t_accounts` VALUES ('1', 'qingsong', '8d7e182a707ddaf0cc55455fc7ff4308', '系统管理员', '1', '2013-09-03 21:26:50', '2016-03-15 19:45:52', '2013-09-03 21:26:50');
INSERT INTO `t_accounts` VALUES ('5', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '管理员', '8', '2016-03-15 19:48:46', '2016-03-15 19:48:46', '2016-03-15 19:48:46');

-- ----------------------------
-- Table structure for t_accounts_informations
-- ----------------------------
DROP TABLE IF EXISTS `t_accounts_informations`;
CREATE TABLE `t_accounts_informations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL COMMENT '账号ID',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `mobile_phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `qq_number` varchar(20) DEFAULT NULL COMMENT 'QQ',
  `company_id` int(11) NOT NULL COMMENT '公司ID',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='账号信息表';

-- ----------------------------
-- Records of t_accounts_informations
-- ----------------------------
INSERT INTO `t_accounts_informations` VALUES ('1', '1', '', '', '', '0', null);
INSERT INTO `t_accounts_informations` VALUES ('5', '5', '', '', '', '0', '');

-- ----------------------------
-- Table structure for t_base_glaze
-- ----------------------------
DROP TABLE IF EXISTS `t_base_glaze`;
CREATE TABLE `t_base_glaze` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) DEFAULT NULL COMMENT '备注',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `water_content` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COMMENT='基础釉';

-- ----------------------------
-- Records of t_base_glaze
-- ----------------------------

-- ----------------------------
-- Table structure for t_companies
-- ----------------------------
DROP TABLE IF EXISTS `t_companies`;
CREATE TABLE `t_companies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '公司名称',
  `telephone` varchar(20) DEFAULT NULL COMMENT '公司电话',
  `fax` varchar(20) DEFAULT NULL COMMENT '传真',
  `address` varchar(100) DEFAULT NULL COMMENT '公司地址',
  `email` varchar(50) DEFAULT NULL COMMENT '公司邮箱',
  `description` varchar(1024) DEFAULT NULL COMMENT '公司简介',
  `homepage` varchar(255) DEFAULT NULL COMMENT '公司主页',
  `segment1` varchar(255) DEFAULT NULL COMMENT '预留字段',
  `last_update_date` datetime NOT NULL COMMENT '最近修改时间',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `index` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='公司信息表';

-- ----------------------------
-- Records of t_companies
-- ----------------------------

-- ----------------------------
-- Table structure for t_language
-- ----------------------------
DROP TABLE IF EXISTS `t_language`;
CREATE TABLE `t_language` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '语言名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='语言表';

-- ----------------------------
-- Records of t_language
-- ----------------------------
INSERT INTO `t_language` VALUES ('1', '中文');
INSERT INTO `t_language` VALUES ('2', '英文');

-- ----------------------------
-- Table structure for t_permissions
-- ----------------------------
DROP TABLE IF EXISTS `t_permissions`;
CREATE TABLE `t_permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `page_mark` varchar(50) NOT NULL COMMENT '页面标识',
  `page_desc` varchar(50) NOT NULL COMMENT '页面说明',
  `show_index` int(11) NOT NULL COMMENT '显示顺序',
  `isUsed` tinyint(1) NOT NULL COMMENT '是否生效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='界面权限表';

-- ----------------------------
-- Records of t_permissions
-- ----------------------------
INSERT INTO `t_permissions` VALUES ('1', 'companyPermission', '客户设置', '1', '1');
INSERT INTO `t_permissions` VALUES ('2', 'accountPermission', '账号设置', '2', '1');
INSERT INTO `t_permissions` VALUES ('3', 'rolePermission', '权限设置', '3', '1');
INSERT INTO `t_permissions` VALUES ('4', 'baseGlazePermission', '基础釉权限', '4', '1');
INSERT INTO `t_permissions` VALUES ('5', 'sampleGlazePermission', '样品釉权限', '5', '1');
INSERT INTO `t_permissions` VALUES ('6', 'productOrderPermission', '投料单权限', '6', '1');
INSERT INTO `t_permissions` VALUES ('7', 'tonerPermission', '色料权限', '7', '1');

-- ----------------------------
-- Table structure for t_product_order
-- ----------------------------
DROP TABLE IF EXISTS `t_product_order`;
CREATE TABLE `t_product_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sample_glaze_id` int(11) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `content` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_product_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_roles
-- ----------------------------
DROP TABLE IF EXISTS `t_roles`;
CREATE TABLE `t_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `is_internal` tinyint(1) DEFAULT NULL COMMENT '是否内部',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色表';

-- ----------------------------
-- Records of t_roles
-- ----------------------------
INSERT INTO `t_roles` VALUES ('1', '系统管理员', '1');
INSERT INTO `t_roles` VALUES ('8', '管理员', '1');

-- ----------------------------
-- Table structure for t_roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS `t_roles_permissions`;
CREATE TABLE `t_roles_permissions` (
  `role_id` int(11) NOT NULL COMMENT '账号ID',
  `permission_id` int(11) NOT NULL COMMENT '权限ID',
  `permission_level` tinyint(4) NOT NULL COMMENT '权限类型(0:无权限,1:只读,2:可读写)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色权限表';

-- ----------------------------
-- Records of t_roles_permissions
-- ----------------------------
INSERT INTO `t_roles_permissions` VALUES ('1', '14', '2');
INSERT INTO `t_roles_permissions` VALUES ('1', '13', '2');
INSERT INTO `t_roles_permissions` VALUES ('1', '3', '2');
INSERT INTO `t_roles_permissions` VALUES ('1', '2', '2');
INSERT INTO `t_roles_permissions` VALUES ('1', '11', '2');
INSERT INTO `t_roles_permissions` VALUES ('1', '15', '2');
INSERT INTO `t_roles_permissions` VALUES ('1', '16', '2');
INSERT INTO `t_roles_permissions` VALUES ('1', '1', '2');
INSERT INTO `t_roles_permissions` VALUES ('1', '6', '2');
INSERT INTO `t_roles_permissions` VALUES ('1', '4', '2');
INSERT INTO `t_roles_permissions` VALUES ('1', '5', '2');
INSERT INTO `t_roles_permissions` VALUES ('1', '7', '2');
INSERT INTO `t_roles_permissions` VALUES ('1', '8', '2');
INSERT INTO `t_roles_permissions` VALUES ('1', '12', '2');
INSERT INTO `t_roles_permissions` VALUES ('1', '9', '2');
INSERT INTO `t_roles_permissions` VALUES ('8', '1', '2');
INSERT INTO `t_roles_permissions` VALUES ('8', '2', '0');
INSERT INTO `t_roles_permissions` VALUES ('8', '3', '0');
INSERT INTO `t_roles_permissions` VALUES ('8', '4', '2');
INSERT INTO `t_roles_permissions` VALUES ('8', '5', '2');
INSERT INTO `t_roles_permissions` VALUES ('8', '6', '2');
INSERT INTO `t_roles_permissions` VALUES ('8', '7', '2');

-- ----------------------------
-- Table structure for t_sample_glaze
-- ----------------------------
DROP TABLE IF EXISTS `t_sample_glaze`;
CREATE TABLE `t_sample_glaze` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `fineness` int(11) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_sample_glaze
-- ----------------------------

-- ----------------------------
-- Table structure for t_sample_glaze_base_glaze
-- ----------------------------
DROP TABLE IF EXISTS `t_sample_glaze_base_glaze`;
CREATE TABLE `t_sample_glaze_base_glaze` (
  `sample_glaze_id` int(11) NOT NULL,
  `base_glaze_id` int(11) DEFAULT NULL,
  `content` int(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_sample_glaze_base_glaze
-- ----------------------------

-- ----------------------------
-- Table structure for t_sample_glaze_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_sample_glaze_customer`;
CREATE TABLE `t_sample_glaze_customer` (
  `sample_glaze_id` int(11) DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_sample_glaze_customer
-- ----------------------------

-- ----------------------------
-- Table structure for t_sample_glaze_toner
-- ----------------------------
DROP TABLE IF EXISTS `t_sample_glaze_toner`;
CREATE TABLE `t_sample_glaze_toner` (
  `sample_glaze_id` int(11) DEFAULT NULL,
  `toner_id` int(11) DEFAULT NULL,
  `content` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_sample_glaze_toner
-- ----------------------------

-- ----------------------------
-- Table structure for t_toner
-- ----------------------------
DROP TABLE IF EXISTS `t_toner`;
CREATE TABLE `t_toner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_toner
-- ----------------------------
