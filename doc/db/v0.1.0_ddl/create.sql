
SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

CREATE DATABASE IF NOT EXISTS easymall default charset utf8 COLLATE utf8_general_ci;

-- ----------------------------
--  Table structure for `u_resources`
-- ----------------------------
DROP TABLE IF EXISTS `u_resources`; COMMENT '资源表'
CREATE TABLE `u_resources` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL COMMENT '标识编号',
  `parent_code` VARCHAR(255) DEFAULT NULL COMMENT '父编号',
  `type` INT DEFAULT null COMMENT '类型，1：菜单；2：按钮；3：API接口',
  `path` varchar(500) DEFAULT NULL COMMENT '路径',
  `domain` varchar(255) DEFAULT NULL COMMENT '域',
  `context` VARCHAR(255) DEFAULT null COMMENT '上下文环境',
  `remark` VARCHAR(3000) DEFAULT null COMMENT '备注',
  `is_delete` int DEFAULT null COMMENT '正常数据为null 删除为非null',
  `create_time` date,
  `create_user` bigint,
  `create_user_name` varchar(255),
  `modify_time` date,
  `modify_user` bigint,
  `modify_user_name` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `u_role`
-- ----------------------------
DROP TABLE IF EXISTS `u_role`;
CREATE TABLE `u_role`(
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `remark` VARCHAR(3000) DEFAULT null COMMENT '备注',
  `is_delete` int DEFAULT null COMMENT '正常数据为null 删除为非null',
  `create_time` date,
  `create_user` bigint,
  `create_user_name` varchar(255),
  `modify_time` date,
  `modify_user` bigint,
  `modify_user_name` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT '角色表';

-- ----------------------------
--  Table structure for `u_role_resources`
-- ----------------------------
DROP TABLE IF EXISTS `u_role_resources`;
CREATE TABLE `u_role_resources` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `resource_id` bigint(20) DEFAULT NULL,
  `is_delete` int DEFAULT null COMMENT '正常数据为null 删除为非null',
  `create_time` date,
  `create_user` bigint,
  `create_user_name` varchar(255),
  `modify_time` date,
  `modify_user` bigint,
  `modify_user_name` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '角色资源关系表';

-- ----------------------------
--  Table structure for `u_admin`
-- ----------------------------
DROP TABLE IF EXISTS `u_admin`;
CREATE TABLE `u_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '用户密码',
  `salt` VARCHAR(255) not null COMMENT '加密盐',
  `is_delete` int DEFAULT null COMMENT '正常数据为null 删除为非null',
  `create_time` date,
  `create_user` bigint,
  `create_user_name` varchar(255),
  `modify_time` date,
  `modify_user` bigint,
  `modify_user_name` varchar(255),
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
--  Table structure for `u_admin_role`
-- ----------------------------
DROP TABLE IF EXISTS `u_admin_role`;
CREATE TABLE `u_admin_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `is_delete` int DEFAULT null COMMENT '正常数据为null 删除为非null',
  `create_time` date,
  `create_user` bigint,
  `create_user_name` varchar(255),
  `modify_time` date,
  `modify_user` bigint,
  `modify_user_name` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户角色关系';


DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `real_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(255) DEFAULT NULL COMMENT '电话',
  `password` varchar(64) DEFAULT NULL COMMENT 'MD5密码',
  `salt` varchar(255) DEFAULT NULL COMMENT '加密盐',
  `is_delete` int DEFAULT null COMMENT '正常数据为null 删除为非null',
  `create_time` date,
  `create_user` bigint,
  `create_user_name` varchar(255),
  `modify_time` date,
  `modify_user` bigint,
  `modify_user_name` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='c端用户表';


DROP TABLE IF EXISTS `u_user_cookie`;
CREATE TABLE `u_user_cookie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int not null COMMENT='2. 是admin 1.是c端用户',
  `cookie_name` VARCHAR(255) NOT NULL ,
  `cookie_value` VARCHAR(512) NOT NULL ,
  `device_type` int NOT NULL  COMMENT='设备类型, ',
  `expired_time` VARCHAR(14) NOT NULL COMMENT='有效期',
  `status` int NOT NULL COMMENT='1 正常 2 退出',
  `is_delete` int DEFAULT null COMMENT '正常数据为null 删除为非null',
  `create_time` date,
  `create_user` bigint,
  `create_user_name` varchar(255),
  `modify_time` date,
  `modify_user` bigint,
  `modify_user_name` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户cookie';

DROP TABLE IF EXISTS `p_attribute_name`;
CREATE TABLE `p_attribute_name` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,

  `is_delete` int DEFAULT null COMMENT '正常数据为null 删除为非null',
  `create_time` date,
  `create_user` bigint,
  `create_user_name` varchar(255),
  `modify_time` date,
  `modify_user` bigint,
  `modify_user_name` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='属性名';

DROP TABLE IF EXISTS `p_attribute_value`;
CREATE TABLE `p_attribute_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,

  `is_delete` int DEFAULT null COMMENT '正常数据为null 删除为非null',
  `create_time` date,
  `create_user` bigint,
  `create_user_name` varchar(255),
  `modify_time` date,
  `modify_user` bigint,
  `modify_user_name` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='属性值';



DROP TABLE IF EXISTS `p_category_attribute_name`;
CREATE TABLE `p_category_attribute_name` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,

  `is_delete` int DEFAULT null COMMENT '正常数据为null 删除为非null',
  `create_time` date,
  `create_user` bigint,
  `create_user_name` varchar(255),
  `modify_time` date,
  `modify_user` bigint,
  `modify_user_name` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='类目属性';


DROP TABLE IF EXISTS `p_product_attribute_name`;
CREATE TABLE `p_product_attribute_name` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,

  `is_delete` int DEFAULT null COMMENT '正常数据为null 删除为非null',
  `create_time` date,
  `create_user` bigint,
  `create_user_name` varchar(255),
  `modify_time` date,
  `modify_user` bigint,
  `modify_user_name` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='类目属性';


DROP TABLE IF EXISTS `p_product`;
CREATE TABLE `p_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,

  `is_delete` int DEFAULT null COMMENT '正常数据为null 删除为非null',
  `create_time` date,
  `create_user` bigint,
  `create_user_name` varchar(255),
  `modify_time` date,
  `modify_user` bigint,
  `modify_user_name` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品';


DROP TABLE IF EXISTS `p_product_picture`;
CREATE TABLE `p_product_picture` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,

  `is_delete` int DEFAULT null COMMENT '正常数据为null 删除为非null',
  `create_time` date,
  `create_user` bigint,
  `create_user_name` varchar(255),
  `modify_time` date,
  `modify_user` bigint,
  `modify_user_name` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品图片表';


DROP TABLE IF EXISTS `p_picture`;
CREATE TABLE `p_picture` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,

  `is_delete` int DEFAULT null COMMENT '正常数据为null 删除为非null',
  `create_time` date,
  `create_user` bigint,
  `create_user_name` varchar(255),
  `modify_time` date,
  `modify_user` bigint,
  `modify_user_name` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片表';


DROP TABLE IF EXISTS `p_product_describe`;
CREATE TABLE `p_product_describe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,

  `is_delete` int DEFAULT null COMMENT '正常数据为null 删除为非null',
  `create_time` date,
  `create_user` bigint,
  `create_user_name` varchar(255),
  `modify_time` date,
  `modify_user` bigint,
  `modify_user_name` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品文描';


DROP TABLE IF EXISTS `p_category`;
CREATE TABLE `p_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,

  `is_delete` int DEFAULT null COMMENT '正常数据为null 删除为非null',
  `create_time` date,
  `create_user` bigint,
  `create_user_name` varchar(255),
  `modify_time` date,
  `modify_user` bigint,
  `modify_user_name` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='类目表';


DROP TABLE IF EXISTS `p_category_node`;
CREATE TABLE `p_category_node` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,

  `is_delete` int DEFAULT null COMMENT '正常数据为null 删除为非null',
  `create_time` date,
  `create_user` bigint,
  `create_user_name` varchar(255),
  `modify_time` date,
  `modify_user` bigint,
  `modify_user_name` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='类目表';

DROP TABLE IF EXISTS `p_brand`;
CREATE TABLE `p_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,

  `is_delete` int DEFAULT null COMMENT '正常数据为null 删除为非null',
  `create_time` date,
  `create_user` bigint,
  `create_user_name` varchar(255),
  `modify_time` date,
  `modify_user` bigint,
  `modify_user_name` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='品牌表';

SET FOREIGN_KEY_CHECKS = 1;
