/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50556
 Source Host           : localhost:3306
 Source Schema         : authority

 Target Server Type    : MySQL
 Target Server Version : 50556
 File Encoding         : 65001

 Date: 10/02/2020 16:44:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `member_id` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES (1, 'PRODUCT_ADD', 1);
INSERT INTO `authority` VALUES (2, 'PRODUCT_LIST', 1);
INSERT INTO `authority` VALUES (3, 'PRODUCT_UPDATE', 1);

-- ----------------------------
-- Table structure for purview
-- ----------------------------
DROP TABLE IF EXISTS `purview`;
CREATE TABLE `purview`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of purview
-- ----------------------------
INSERT INTO `purview` VALUES (1, 'PRODUCT_ADD', '/product/add');
INSERT INTO `purview` VALUES (2, 'PRODUCT_UPDATE', '/product/update');
INSERT INTO `purview` VALUES (3, 'PRODUCT_LIST', '/product/list');
INSERT INTO `purview` VALUES (4, 'PRODUCT_DELETE', '/product/delete');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `enable` bit(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '1591313226@163.com', '123456', b'1');

SET FOREIGN_KEY_CHECKS = 1;
