/*
Navicat MySQL Data Transfer

Source Server         : zyh
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2018-10-10 10:54:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `blogarticles`
-- ----------------------------
DROP TABLE IF EXISTS `blogarticles`;
CREATE TABLE `blogarticles` (
  `blog_id` int(10) NOT NULL AUTO_INCREMENT,
  `blog_name` varchar(20) DEFAULT NULL,
  `blog_remark` varchar(5000) DEFAULT NULL,
  `blog_users` int(10) DEFAULT NULL,
  `blog_date` date DEFAULT NULL,
  `blog_memo` varchar(255) DEFAULT NULL,
  `blog_cls` int(10) DEFAULT NULL,
  `comm_count` int(255) DEFAULT NULL,
  PRIMARY KEY (`blog_id`),
  KEY `blog_cls` (`blog_cls`),
  KEY `blog_users` (`blog_users`),
  CONSTRAINT `blog_cls` FOREIGN KEY (`blog_cls`) REFERENCES `classify` (`cls_id`),
  CONSTRAINT `blog_users` FOREIGN KEY (`blog_users`) REFERENCES `users` (`users_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blogarticles
-- ----------------------------
INSERT INTO `blogarticles` VALUES ('2', '博客2', '1.1.5小结\n查询出来的结果集只有一行且一列，可以使用简单类型进行输出映射。（输出简单类型的要求）\n1.2输出pojo对象和pojo列表\n不管是输出的pojo单个对象还是一个列表（list中包括pojo），在mapper.xml中resultType指定的类型是一样的。\n在mapper.java指定的方法返回值类型不一样：\n(1)输出单个pojo对象，方法返回值是单个对象类型\n \n(2)输出pojo对象list，方法返回值是List<Pojo>\n生成的动态代理对象中是根据mapper方法的返回值类型确定是调用selectOne(返回单个对象调用)还是selectList （返回集合对象调用 ）.\n(3)输出hashmap\n输出pojo对象可以改用hashmap输出类型，将输出的字段名称作为map的key，value为字段值。如果是集合，那就是list里面套了HashMap。\n2.resultMap\nmybatis中使用resultMap完成高级输出结果映射。\n2.1resultMap使用方法\n如果查询出来的列名和pojo的属性名不一致，通过定义一个resultMap对列名和pojo属性名之间作一个映射关系。\n下面来进行实验，实验需求\n2.2将下边的sql使用User完成映射\nSELECT id id_,username username_ FROM USER WHERE id=#{value}\nUser类中属性名和上边查询列名不一致。\nresultMap使用方法:(一下属性均定义在Mapper.xml映射文件中)\r\n\r\n---------------------\r\n\r\n本文来自 光仔December 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/acmman/article/details/46509375?utm_source=copy ', '2', '2018-09-27', '博客2备注', '7', '2');
INSERT INTO `blogarticles` VALUES ('7', '博客6 ', '博客6', '3', '2018-10-03', '博客6备注', '2', '0');
INSERT INTO `blogarticles` VALUES ('8', '博客7', '博客7', '2', '2018-10-06', '博客7备注', '2', '0');
INSERT INTO `blogarticles` VALUES ('9', '我今天很开心，所以写了篇文章', '文章内容很丰富', '2', '2018-10-09', null, '5', '0');
INSERT INTO `blogarticles` VALUES ('16', '我要写文章', '文章真好', '5', '2018-10-09', null, '6', '5');
INSERT INTO `blogarticles` VALUES ('17', '今天好冷啊', '今天真的好冷', '6', '2018-10-10', null, '11', '0');
INSERT INTO `blogarticles` VALUES ('18', null, null, '6', '2018-10-10', null, null, '0');
INSERT INTO `blogarticles` VALUES ('19', null, null, '6', '2018-10-10', null, null, '0');

-- ----------------------------
-- Table structure for `classify`
-- ----------------------------
DROP TABLE IF EXISTS `classify`;
CREATE TABLE `classify` (
  `cls_id` int(10) NOT NULL AUTO_INCREMENT,
  `cls_name` varchar(255) DEFAULT NULL,
  `cls_remark` varchar(255) DEFAULT NULL,
  `cls_memo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cls_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classify
-- ----------------------------
INSERT INTO `classify` VALUES ('2', '.net', '好看', '好看');
INSERT INTO `classify` VALUES ('5', 'c', '牛啊', null);
INSERT INTO `classify` VALUES ('6', 'c++', 'aa ', null);
INSERT INTO `classify` VALUES ('7', '教学篇', 'springboot', null);
INSERT INTO `classify` VALUES ('11', '基础篇', 'rr', null);
INSERT INTO `classify` VALUES ('15', '框架', 'asdf', null);

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comm_id` int(10) NOT NULL AUTO_INCREMENT,
  `comm_users` int(10) DEFAULT NULL,
  `comm_remark` varchar(300) DEFAULT NULL,
  `comm_blog` int(10) DEFAULT NULL,
  `comm_date` date DEFAULT NULL,
  PRIMARY KEY (`comm_id`),
  KEY `comm_user_id` (`comm_users`),
  KEY `comm_blog_id` (`comm_blog`),
  CONSTRAINT `comm_blog_id` FOREIGN KEY (`comm_blog`) REFERENCES `blogarticles` (`blog_id`),
  CONSTRAINT `comm_user_id` FOREIGN KEY (`comm_users`) REFERENCES `users` (`users_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('2', '1', '阿斯蒂芬', '2', '2018-09-12');
INSERT INTO `comment` VALUES ('3', '1', 'asdf ', '2', '2018-09-28');
INSERT INTO `comment` VALUES ('4', '2', 'eqwe', '2', '2018-10-04');
INSERT INTO `comment` VALUES ('5', '2', null, '2', '2018-10-04');
INSERT INTO `comment` VALUES ('9', '5', '真好看，真精彩', '9', '2018-10-09');
INSERT INTO `comment` VALUES ('10', '5', '好看啊', '9', '2018-10-09');
INSERT INTO `comment` VALUES ('11', '5', '真好看', '9', '2018-10-09');
INSERT INTO `comment` VALUES ('12', '5', '哎呀真好', '2', '2018-10-09');
INSERT INTO `comment` VALUES ('13', '5', '阿斯蒂芬', '16', '2018-10-09');
INSERT INTO `comment` VALUES ('14', '5', '阿斯蒂芬', '16', '2018-10-09');
INSERT INTO `comment` VALUES ('15', '5', '去玩儿去玩儿我去而QWERTYQWERTYQWERTYQWERTYQWERTY去玩儿去玩儿', '16', '2018-10-09');
INSERT INTO `comment` VALUES ('16', '5', '啊啊啊啊啊', '16', '2018-10-09');
INSERT INTO `comment` VALUES ('17', '6', '写的真好', '16', '2018-10-10');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `users_id` int(10) NOT NULL AUTO_INCREMENT,
  `users_name` varchar(255) DEFAULT NULL,
  `users_pswd` varchar(255) DEFAULT NULL,
  `users_age` int(10) DEFAULT NULL,
  `users_phone` varchar(11) DEFAULT NULL,
  `users_cardid` varchar(18) DEFAULT NULL,
  `users_no` varchar(20) DEFAULT NULL,
  `users_state` int(10) NOT NULL,
  PRIMARY KEY (`users_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'Admin', '1111111', '2', '15847720987', '152725199702182710', '111', '1');
INSERT INTO `users` VALUES ('2', '武帅', '222', '1', '18686222323', '15272519970218271X', '222', '0');
INSERT INTO `users` VALUES ('3', '张亚辉', '123123', '1', '18668222337', '15272519970218271X', '103', '0');
INSERT INTO `users` VALUES ('4', '武帅', '123456', '1', '15842770987', '15272519970218271X', '105', '0');
INSERT INTO `users` VALUES ('5', '张亚辉', '333', '1', '18686222327', '140212199705281817', '333', '0');
INSERT INTO `users` VALUES ('6', '周琦', 'zhouqi123', '2', '15848646265', '15220119970108102X', 'zhouqi', '0');
