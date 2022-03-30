
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- 管理员表
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin_user`;
CREATE TABLE `tb_admin_user` (
    `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '管理员id',
    `user_name` varchar(50) NOT NULL COMMENT '管理员名称',
    `password` varchar(50) NOT NULL COMMENT '管理员密码',
    `nick_name` varchar(50) NOT NULL COMMENT '管理员昵称',
    `avatar` varchar(200) COMMENT '管理员头像',
    `phone` varchar(11) COMMENT '手机号',
    `email` varchar(50) COMMENT '邮箱',
    `locked` tinyint DEFAULT '0' COMMENT '是否锁定（0-未锁定，1-已锁定）',
    PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic COMMENT='管理员表';

INSERT INTO `tb_admin_user`
    (`user_id`, `user_name`, `password`, `nick_name`, `avatar`, `phone`, `email`, `locked`)
VALUES
	(1, 'admin', '123','pxx1', 'https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png', '16666666666', '123456@qq.com', 0),
	(2, 'admin1', '123','pxx2', 'https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png', '17777777777', '789456@qq.com', 0);

-- ----------------------------
-- 管理员token(deprecated)
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin_user_token`;
CREATE TABLE `tb_admin_user_token` (
    `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '管理员id',
    `token` varchar(200) NOT NULL COMMENT 'token值',
    `update_time` datetime NOT NULL COMMENT '更新时间',
    `expired_time` datetime NOT NULL COMMENT '过期时间',
    PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic COMMENT='管理员token表';

-- ----------------------------
-- 轮播图表
-- ----------------------------
DROP TABLE IF EXISTS `tb_carousel`;
CREATE TABLE `tb_carousel`(
    `carousel_id` int NOT NULL AUTO_INCREMENT COMMENT '轮播图id',
    `carousel_image` varchar(150) NOT NULL COMMENT '轮播图片地址',
    `carousel_url` varchar(150) NOT NULL DEFAULT '#' COMMENT '轮播图跳转链接',
    `carousel_sort` int NOT NULL DEFAULT 0 COMMENT '轮播图排序（越小越靠前）',
    `carousel_status` tinyint NOT NULL DEFAULT 0 COMMENT '状态（0-已下架，1-上架中）',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '删除标识（0-未删除，1-已删除）',
    `create_user` int NOT NULL COMMENT '创建人id',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_user` int COMMENT '更新人id',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`carousel_id`) USING BTREE
) ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic COMMENT='首页轮播图表';

INSERT INTO `tb_carousel`
    (`carousel_id`, `carousel_image`, `carousel_url`, `carousel_sort`, `carousel_status`, `is_deleted`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES
    (1, 'https://m15.360buyimg.com/mobilecms/jfs/t1/148977/33/22598/287939/6216cfdcE5640591c/22d25c733d2b6c3b.jpg', '##', 1, 1, 0, 1, '2022-03-01 10:15:16', 1, '2022-03-01 15:15:16'),
    (2, 'https://m15.360buyimg.com/mobilecms/jfs/t1/107338/36/23598/145196/621d8bc1E93033a37/2d5bb408a810bf91.jpg', '##', 2, 1, 0, 1, '2022-03-01 15:15:16', 1, '2022-03-01 15:15:16'),
    (3, 'https://m15.360buyimg.com/mobilecms/jfs/t1/148977/33/22598/287939/6216cfdcE5640591c/22d25c733d2b6c3b.jpg', '##', 3, 0, 0, 1, '2022-03-01 15:15:16', 1, '2022-03-01 15:15:16'),
    (4, 'https://m15.360buyimg.com/mobilecms/jfs/t1/107338/36/23598/145196/621d8bc1E93033a37/2d5bb408a810bf91.jpg', '##', 4, 1, 0, 1, '2022-03-01 15:15:16', 1, '2022-03-01 15:15:16'),
    (5, 'https://m15.360buyimg.com/mobilecms/jfs/t1/148977/33/22598/287939/6216cfdcE5640591c/22d25c733d2b6c3b.jpg', '##', 5, 0, 0, 1, '2022-03-01 15:15:16', 1, '2022-03-01 15:15:16');
	
-- ----------------------------
-- 商品表
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods` (
    `goods_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '商品id',
    `goods_name` varchar(150) NOT NULL DEFAULT '' COMMENT '商品名称',
    `goods_image` varchar(150) NOT NULL DEFAULT '' COMMENT '商品主图',
    `goods_category_id` bigint NOT NULL DEFAULT 0 COMMENT '商品分类id',
    `goods_desc` varchar(200) NOT NULL DEFAULT '' COMMENT '商品简介',
    `goods_price` float NOT NULL DEFAULT 0 COMMENT '商品价格',
    `goods_stock` int unsigned NOT NULL DEFAULT 0 COMMENT '商品库存',
    `goods_status` tinyint NOT NULL DEFAULT 1 COMMENT '商品状态（0-下架，1-上架）',
--     `goods_type` tinyint NOT NULL DEFAULT 0 COMMENT '商品类型（0-普通，1-推荐）',
    `goods_detail` text NOT NULL COMMENT '商品详情',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '删除标识（0-未删除，1-已删除）',
    `create_user` int NOT NULL DEFAULT 0 COMMENT '创建人id',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_user` int NOT NULL DEFAULT 0 COMMENT '更新人id',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic COMMENT='商品表';

INSERT INTO `tb_goods`
    (`goods_id`, `goods_name`, `goods_image`, `goods_category_id`, `goods_desc`, `goods_price`, `goods_stock`, `goods_status`, `goods_detail`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES
    (100, '(Haier)海尔双门冰箱', 'https://img10.360buyimg.com/mobilecms/s360x360_jfs/t1/147916/20/22334/454208/620f6729E5f8c2608/e77478cdc8928a7e.jpg', 36, '三门两门\/风冷无霜\/直冷超薄小型家用家电智能节能电冰箱 218升三门直冷冰箱218STPS', 1999, 999, 1, '<p><img src=\"https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/goods-detail/6bcd4bf18a7ffb3a.png\" style=\"max-width:100%;\" contenteditable=\"false\"/><img src=\"https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/goods-detail/ade4a041465d5504.png\" style=\"max-width:100%;\" contenteditable=\"false\"/><img src=\"https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/goods-detail/bed941b7f804cc35.jpg\" style=\"max-width:100%;\" contenteditable=\"false\"/><img src=\"https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/goods-detail/d660399655eb3fcd.jpg\" style=\"max-width:100%;\" contenteditable=\"false\"/><img src=\"https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/goods-detail/ae3ec76c1ec49fd5.jpg\" style=\"max-width:100%;\" contenteditable=\"false\"/><img src=\"https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/goods-detail/d844647031f6ad64.jpg\" style=\"max-width:100%;\" contenteditable=\"false\"/><img src=\"https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/goods-detail/cfe1e222444ab974.jpg\" style=\"max-width:100%;\" contenteditable=\"false\"/></p>', 1, '2022-03-01 17:01:01', 1, '2022-03-01 17:01:01'),
    (101, '(Haier)海尔十字对开门冰箱', 'https://img10.360buyimg.com/mobilecms/s360x360_jfs/t1/147916/20/22334/454208/620f6729E5f8c2608/e77478cdc8928a7e.jpg', 38, '十字对开门\/风冷无霜\/直冷超薄小型家用家电智能节能电冰箱 218升三门直冷冰箱218STPS', 1999, 999, 1, '无', 1, '2022-03-01 17:01:01', 1, '2022-03-01 17:01:01'),
    (102, '海尔（Haier）255升风冷无霜三门冰箱', 'https://img10.360buyimg.com/mobilecms/s360x360_jfs/t1/103012/21/24898/172207/6233ddc6E95a4d117/a696c56c1b3d956d.jpg', 39, '海尔 （Haier）255升风冷无霜三门冰箱干湿分储 小型中门全温区变温 DEO净味系统 彩晶玻璃面板 BCD-255WDCI', 1999, 999, 1, '无', 1, '2022-03-01 17:01:01', 1, '2022-03-01 17:01:01'),
    (103, '海尔（Haier）一级能效节能套装空调', 'https://img10.360buyimg.com/mobilecms/s360x360_jfs/t1/171169/30/26460/228069/62314e1eE7a371cc3/bdf36b7aa9dd83e6.jpg', 27, '【值空调组合套购】海尔（Haier）空调2P/3匹自清洁变频一级能效节能套装空调 【3P柜机1台】+【1.5P挂机3台】【三室一厅】', 1999, 999, 1, '无', 1, '2022-03-01 17:01:01', 1, '2022-03-01 17:01:01'),
    (104, '曼雅蒂小黄人联名手表【小黄人正版授权】黑色', 'https://img10.360buyimg.com/mobilecms/s360x360_jfs/t1/130507/6/21602/93827/62284c2eE667775e5/7ebbebf5a6312e30.jpg', 103, '曼雅蒂小黄人联名手表7儿童9男生10岁以上炫酷小学生机械防水日历 【小黄人正版授权】黑色', 1999, 999, 1, '无', 1, '2022-03-01 17:01:01', 1, '2022-03-01 17:01:01');

-- ----------------------------
-- 推荐商品表
-- ----------------------------
DROP TABLE IF EXISTS `tb_recommend_goods`;
CREATE TABLE `tb_recommend_goods` (
    `recommend_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '推荐商品id',
    `goods_id` bigint unsigned NOT NULL COMMENT '商品id',
    `recommend_desc` varchar(150) NOT NULL DEFAULT '' COMMENT '推荐商品描述',
    `recommend_sort` int NOT NULL DEFAULT 0 COMMENT '推荐排序（越小越靠前）',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '删除标识（0-未删除，1-已删除）',
    `create_user` int NOT NULL DEFAULT 0 COMMENT '创建人id',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_user` int NOT NULL DEFAULT 0 COMMENT '更新人id',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`recommend_id`) USING BTREE
) ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic COMMENT='推荐商品表';

INSERT INTO `tb_recommend_goods`
       (recommend_id, goods_id, recommend_desc, recommend_sort, is_deleted, create_user, create_time, update_user, update_time)
VALUES (1, 100, '9.9包邮~~', 1, 0, 1, '2022-03-19 12:13:14', 1, '2022-03-19 12:13:14'),
       (2, 101, '19.9包邮~~', 1, 0, 1, '2022-03-19 12:13:14', 1, '2022-03-19 12:13:14'),
       (3, 102, '29.9包邮~~', 1, 0, 1, '2022-03-19 12:13:14', 1, '2022-03-19 12:13:14'),
       (4, 103, '2P/3匹自清洁变频一级能效节能套装空调 【3P柜机1台】', 1, 0, 1, '2022-03-19 12:13:14', 1, '2022-03-19 12:13:14'),
       (5, 104, '曼雅蒂小黄人联名手表7儿童9男生10岁以上炫酷小学生机械防水日历', 1, 0, 1, '2022-03-19 12:13:14', 1, '2022-03-19 12:13:14');

-- ----------------------------
-- 商品分类
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods_category`;
CREATE TABLE `tb_goods_category` (
    `category_id` bigint NOT NULL AUTO_INCREMENT COMMENT '分类id',
    `category_name` varchar(50) NOT NULL DEFAULT '' COMMENT '分类名称',
    `category_level` tinyint NOT NULL DEFAULT '0' COMMENT '分类级别(1-一级分类，2-二级分类，3-三级分类)',
    `parent_id` bigint NOT NULL DEFAULT '0' COMMENT '父级分类id',
    `category_image` varchar(150) DEFAULT '0' COMMENT '分类图标',
    `category_sort` int NOT NULL DEFAULT '0' COMMENT '排序',
    `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '删除标识(0-未删除，1-已删除)',
    `create_user` int NOT NULL DEFAULT '0' COMMENT '创建人id',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_user` int DEFAULT '0' COMMENT '更新人id',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`category_id`) USING BTREE
) ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic COMMENT='商品分类表';

INSERT INTO `tb_goods_category`
    (`category_id`, `category_name`, `category_level`, `parent_id`, `category_image`, `category_sort`, `is_deleted`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES
    (10, '手机数码', 1, 0, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (11, '热门分类', 2, 10, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (12, '华为', 3, 11, 'https://img14.360buyimg.com/focus/s140x140_jfs/t11929/135/2372293765/1396/e103ec31/5a1692e2Nbea6e136.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (13, '小米', 3, 11, 'https://img30.360buyimg.com/focus/s140x140_jfs/t13411/188/926813276/3945/a4f47292/5a1692eeN105a64b4.png', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (14, 'OPPO', 3, 11, 'https://img13.360buyimg.com/focus/s140x140_jfs/t13036/273/932026474/2570/a3517c7d/5a169254N4bbbd9fb.png', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (15, 'vivo', 3, 11, 'https://img11.360buyimg.com/focus/s140x140_jfs/t11014/359/2341377211/2777/1755c29c/5a169244Nff0179e0.png', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (16, 'iPhone', 3, 11, 'https://img20.360buyimg.com/focus/s140x140_jfs/t13759/194/897734755/2493/1305d4c4/5a1692ebN8ae73077.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (17, '手机通讯', 2, 10, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (18, '老人机', 3, 17, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (19, '手机', 3, 17, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (20, '全面屏手机', 3, 17, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (21, '拍照手机', 3, 17, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (22, '智能设备', 2, 10, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (23, '智能手环', 3, 22, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (24, '智能手表', 3, 22, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (25, '智能家居', 3, 22, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (26, '智能机器人', 3, 22, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (27, '家用电器', 1, 0, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (28, '厨房小电', 2, 27, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (29, '电压力锅', 3, 28, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (30, '电水壶', 3, 28, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (31, '电饭煲', 3, 28, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (32, '电磁炉', 3, 28, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (33, '微波炉', 3, 28, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (34, '冰箱', 2, 27, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (35, '全部', 3, 34, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (36, '双门冰箱', 3, 34, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (37, '对开门冰箱', 3, 34, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (38, '十字对开门', 3, 34, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (39, '三门冰箱', 3, 34, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (40, '单门冰箱', 3, 34, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (41, '洗衣机', 2, 27, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (42, '全部', 3, 41, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (43, '波轮洗衣机', 3, 41, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (44, '滚筒洗衣机', 3, 41, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (45, '洗烘一体机', 3, 41, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (46, '迷你洗衣机', 3, 41, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (47, '电脑办公', 1, 0, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (48, '热门分类', 2, 47, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (49, '轻薄本', 3, 48, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (50, '游戏本', 3, 48, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (51, '组装电脑', 3, 48, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (52, '移动硬盘', 3, 48, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (53, '显卡', 3, 48, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (54, '家用打印机', 3, 48, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (55, '电脑整机', 2, 47, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (56, '笔记本', 3, 55, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (57, '平板电脑', 3, 55, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (58, '一体机', 3, 55, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (59, '台式机', 3, 55, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (60, '游戏本', 3, 55, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (61, '工作站', 3, 55, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (62, '外设产品', 2, 47, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (63, '鼠标', 3, 62, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (64, '键盘', 3, 62, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (65, 'U盘', 3, 62, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (66, '手写板', 3, 62, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (67, '电脑配件', 2, 47, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (68, '显示器', 3, 67, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (69, '硬盘', 3, 67, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (70, '内存', 3, 67, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (71, 'CPU', 3, 67, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (72, '玩具乐器', 1, 0, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (73, '遥控电动', 2, 72, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (74, '机器人', 3, 73, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (75, '遥控车', 3, 73, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (76, '遥控飞机', 3, 73, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (77, '遥控船', 3, 73, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (78, '乐器', 2, 72, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (79, '口琴', 3, 78, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (80, '钢琴', 3, 78, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (81, '电子琴', 3, 78, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (82, '尤克里里', 3, 78, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (83, '吉他', 3, 78, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (84, '大提琴', 3, 78, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (85, '家居厨具', 1, 0, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (86, '家纺', 2, 85, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (87, '床垫/床褥', 3, 86, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (88, '枕套枕巾', 3, 86, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (89, '地毯', 3, 86, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (90, '电热毯', 3, 86, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (91, '床单被罩', 3, 86, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (92, '家装软饰', 2, 85, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (93, '墙贴', 3, 92, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (94, '装饰贴', 3, 92, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (95, '装饰摆件', 3, 92, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (96, '花瓶花艺', 3, 92, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (97, '字画', 3, 92, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (98, '钟表珠宝', 1, 0, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (99, '钟表', 2, 98, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (100, '瑞表', 3, 99, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (101, '国表', 3, 99, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (102, '德表', 3, 99, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (103, '儿童手表', 3, 99, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (104, '时尚饰品', 2, 98, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (105, '戒指', 3, 104, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (106, '耳饰', 3, 104, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (107, '手链', 3, 104, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09'),
    (108, '项链', 3, 104, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');

-- ----------------------------
-- 订单表
-- ----------------------------
DROP TABLE IF EXISTS `tb_client_order`;
CREATE TABLE `tb_client_order` (
    `order_id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单id',
    `order_no` varchar(20) NOT NULL DEFAULT '' COMMENT '订单号',
    `user_id` bigint NOT NULL DEFAULT '0' COMMENT '用户id',
    `order_price` float NOT NULL DEFAULT '0' COMMENT '订单价格',
    `order_coupon` float DEFAULT '0' COMMENT '优惠金额',
    `payment_status` tinyint NOT NULL DEFAULT '0' COMMENT '支付状态（0-未支付，1-支付成功，2-支付失败）',
    `order_status` tinyint NOT NULL DEFAULT '0' COMMENT '订单状态（0-待支付，1-待收货，2-交易成功，3-手动关闭，4-超时关闭，5-商家关闭，99-已删除）',
    `payment_type` tinyint NOT NULL DEFAULT '0' COMMENT '支付方式（1-支付宝，2-微信）',
    `payment_time` datetime DEFAULT NULL COMMENT '支付时间',
    `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '删除标识(0-未删除，1-已删除)',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`order_id`)
) ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic COMMENT='客户订单表';

-- ----------------------------
-- 订单商品表
-- ----------------------------
DROP TABLE IF EXISTS `tb_client_order_goods`;
CREATE TABLE `tb_client_order_goods` (
    `order_goods_id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单商品id',
    `order_id` bigint NOT NULL COMMENT '关联订单id',
    `goods_id` bigint unsigned NOT NULL COMMENT '商品id',
    `goods_name` varchar(150) NOT NULL DEFAULT '' COMMENT '商品名称',
    `goods_image` varchar(150) NOT NULL DEFAULT '' COMMENT '商品主图',
    `goods_count` int NOT NULL DEFAULT '1' COMMENT '商品数量',
    `goods_price` FLOAT NOT NULL DEFAULT '0' COMMENT '商品价格',
    `goods_desc` varchar(200) NOT NULL DEFAULT '' COMMENT '商品简介',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`order_goods_id`)
) ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic COMMENT='客户订单商品表';

-- ----------------------------
-- 购物车表
-- ----------------------------
DROP TABLE IF EXISTS `tb_client_cart`;
CREATE TABLE `tb_client_cart` (
    `cart_id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_id` bigint NOT NULL COMMENT '用户id',
    `goods_id` bigint NOT NULL DEFAULT '0' COMMENT '商品id',
    `goods_count` int NOT NULL DEFAULT '1' COMMENT '商品数量',
    `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '删除标识（0-未删除，1-已删除）',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic COMMENT='客户购物车表';

-- ----------------------------
-- 用户表
-- ----------------------------
DROP TABLE IF EXISTS `tb_client_user`;
CREATE TABLE `tb_client_user` (
    `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
    `user_name` varchar(50) NOT NULL COMMENT '用户名称',
    `password` varchar(50) NOT NULL COMMENT '用户密码',
    `nick_name` varchar(50) NOT NULL COMMENT '用户昵称',
    `avatar` varchar(200) COMMENT '用户头像',
    `phone` varchar(11) COMMENT '手机号',
    `email` varchar(50) COMMENT '邮箱',
    `locked` tinyint DEFAULT '0' COMMENT '是否锁定（0-未锁定，1-已锁定）',
    PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic COMMENT='用户表';

INSERT INTO `tb_client_user`
(`user_id`, `user_name`, `password`, `nick_name`, `avatar`, `phone`, `email`, `locked`)
VALUES
(1, 'client1', '123','xx1', 'https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png', '16666666666', '123456@qq.com', 0),
(2, 'client2', '123','xx2', 'https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png', '17777777777', '789456@qq.com', 0);

-- ----------------------------
-- 用户地址表
-- ----------------------------
DROP TABLE IF EXISTS `tb_client_address`;
CREATE TABLE `tb_client_address` (
    `address_id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_id` bigint NOT NULL DEFAULT '0' COMMENT '用户id',
    `name` varchar(30) NOT NULL DEFAULT '' COMMENT '收货人姓名',
    `tel` varchar(11) NOT NULL DEFAULT '' COMMENT '收货人手机号',
    `is_default` tinyint NOT NULL DEFAULT '0' COMMENT '是否为默认（0-否，1-是）',
    `province` varchar(32) NOT NULL DEFAULT '' COMMENT '省',
    `city` varchar(32) NOT NULL DEFAULT '' COMMENT '市',
    `county` varchar(32) NOT NULL DEFAULT '' COMMENT '区',
    `address_detail` varchar(100) NOT NULL DEFAULT '' COMMENT '详细地址',
    `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '删除标识（0-未删除，1-已删除）',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`address_id`)
) ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic COMMENT='用户地址表';

INSERT INTO `tb_client_address`
(address_id, user_id, name, tel, is_default, province, city, county, address_detail)
VALUES
       (1, 1, '张三丰', '13666666666', 0, '440000', '440301', '440305', '深圳湾2号6栋 66 楼'),
       (2, 1, '张四丰', '13777777777', 0, '440000', '440301', '440305', '深圳湾2号7栋 68 楼');
