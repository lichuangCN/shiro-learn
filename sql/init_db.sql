-- user
CREATE TABLE `user` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT,
  `password` VARCHAR (255) NULL DEFAULT NULL,
  `username` VARCHAR (255) NULL DEFAULT NULL,
  `account` VARCHAR (255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;

INSERT INTO `user` VALUES (1, 'root', '超级用户', 'root') ;
INSERT INTO `user` VALUES (2, 'user', '普通用户', 'user');
INSERT INTO `user` VALUES (3, 'vip', 'VIP用户', 'vip');

-- role
CREATE TABLE `role` (
  `id` INT (11) NOT NULL AUTO_INCREMENT,
  `role` VARCHAR (255) NULL DEFAULT NULL,
  `desc` VARCHAR (255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 ;

INSERT INTO `role `VALUES (1, 'admin', '超级管理员');
INSERT INTO `role` VALUES (2, 'user', '普通用户');
INSERT INTO `role` VALUES (3, 'vip_user', 'VIP用户') ;

-- permission
CREATE TABLE `permission` (
  `id` INT (11) NOT NULL AUTO_INCREMENT,
  `permission` VARCHAR (255) NULL DEFAULT NULL COMMENT '权限名称',
  `desc` VARCHAR (255) NULL DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 ;

INSERT INTO `permission` VALUES (1, 'add', '增加');
INSERT INTO `permission` VALUES (2, 'update', '更新');
INSERT INTO `permission` VALUES (3, 'select', '查看');
INSERT INTO `permission` VALUES (4, 'delete', '删除');

-- user_role
CREATE TABLE `user_role` (
  `id` INT (11) NOT NULL AUTO_INCREMENT,
  `user_id` INT (11) NULL DEFAULT NULL,
  `role_id` INT (11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 ;

INSERT INTO `user_role` VALUES (1, 1, 1);
INSERT INTO `user_role` VALUES (2, 2, 2);
INSERT INTO `user_role` VALUES (3, 3, 3);

-- role_permission

CREATE TABLE `role_permission` (
  `id` INT (11) NOT NULL AUTO_INCREMENT,
  `role_id` INT (11) NULL DEFAULT NULL,
  `permission_id` INT (255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 ;

INSERT INTO `role_permission` VALUES (1, 1, 1);
INSERT INTO `role_permission` VALUES (2, 1, 2);
INSERT INTO `role_permission` VALUES (3, 1, 3);
INSERT INTO `role_permission` VALUES (4, 1, 4);
INSERT INTO `role_permission` VALUES (5, 2, 3);
INSERT INTO `role_permission` VALUES (6, 3, 3);
INSERT INTO `role_permission` VALUES (7, 3, 2);
INSERT INTO `role_permission` VALUES (8, 2, 1);
