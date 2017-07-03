/*
Navicat MySQL Data Transfer

Source Server         : 1701
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : goods

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-07-03 18:55:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for 1701_item
-- ----------------------------
DROP TABLE IF EXISTS `1701_item`;
CREATE TABLE `1701_item` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `type` int(10) NOT NULL,
  `ondate` date DEFAULT NULL,
  `downdate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `1701_item` (`type`),
  CONSTRAINT `1701_item` FOREIGN KEY (`type`) REFERENCES `1701_item_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 1701_item
-- ----------------------------
INSERT INTO `1701_item` VALUES ('1', '橡胶', '23.00', '2', '2017-07-03', '2017-07-28');
INSERT INTO `1701_item` VALUES ('2', '香蕉', '6.00', '1', '2017-07-02', '2017-07-07');
INSERT INTO `1701_item` VALUES ('3', '薯片', '5.50', '1', '2012-03-04', '2014-05-06');
INSERT INTO `1701_item` VALUES ('4', '耳机', '788.00', '3', '2013-03-03', '2019-02-02');
INSERT INTO `1701_item` VALUES ('5', '耳机', '799.00', '3', '2013-12-02', '2017-06-09');

-- ----------------------------
-- Table structure for 1701_item_type
-- ----------------------------
DROP TABLE IF EXISTS `1701_item_type`;
CREATE TABLE `1701_item_type` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 1701_item_type
-- ----------------------------
INSERT INTO `1701_item_type` VALUES ('1', '食品');
INSERT INTO `1701_item_type` VALUES ('2', '日用品');
INSERT INTO `1701_item_type` VALUES ('3', '数码产品');

-- ----------------------------
-- Table structure for 1701_user
-- ----------------------------
DROP TABLE IF EXISTS `1701_user`;
CREATE TABLE `1701_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `passWord` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 1701_user
-- ----------------------------
INSERT INTO `1701_user` VALUES ('1', 'jiangshan', '321021', '女', '23');
