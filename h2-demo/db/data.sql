/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : 127.0.0.1:3306
 Source Schema         : myschool

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 07/02/2021 23:24:26
*/
-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`
(
    `id`   varchar(225),
    `name` varchar(225) ,
    `age`  int(11)
);

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student`
VALUES ('0', '张三', 20);
INSERT INTO `student`
VALUES ('1', '少杰', 20);
INSERT INTO `student`
VALUES ('10', '赵子龙', NULL);
INSERT INTO `student`
VALUES ('2', '赵云', 20);
INSERT INTO `student`
VALUES ('3', '刘备', NULL);
INSERT INTO `student`
VALUES ('4', '关羽', NULL);
INSERT INTO `student`
VALUES ('5', '曹操', NULL);
INSERT INTO `student`
VALUES ('6', '司马懿', NULL);
INSERT INTO `student`
VALUES ('7', '曹植', NULL);
INSERT INTO `student`
VALUES ('8', '司马懿', NULL);
INSERT INTO `student`
VALUES ('9', '周瑜', NULL);
