
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

# 后台管理系统
--------------------------------------------------------------

# 管理员表

CREATE TABLE IF NOT EXISTS `tb_admin_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `user_name` varchar(50) NOT NULL COMMENT '管理员名称',
  `password` varchar(50) NOT NULL COMMENT '管理员密码',
  `nick_name` varchar(50) NOT NULL COMMENT '管理员昵称',
  `locked` tinyint(4) DEFAULT '0' COMMENT '是否锁定 0-未锁定 1-已锁定',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

LOCK TABLES `tb_admin_user` WRITE;

INSERT INTO `tb_admin_user` (`user_id`, `user_name`, `password`, `nick_name`, `locked`)
VALUES
	(1,'admin','123','拼夕夕01',0),
	(2,'admin1','123','拼夕夕02',0);

UNLOCK TABLES;

--------------------------------------------------------------

# 管理员token表

CREATE TABLE IF NOT EXISTS 'tb_admin_user_token' (
    'user_id' bigint(20) NOT NULL COMMENT '管理员id',
    'token' varchar(32) NOT NULL COMMENT 'token值（32位）',
    'update_time' datetime NOT NULL COMMENT '更新时间',
    'expired_time' datetime NOT NULL COMMENT '过期时间',
    PRIMARY KEY 'user_id'
) ENGINE = InnoDB DEFAULT CHARSET = utf8;




