/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : 119.29.134.117:3306
 Source Schema         : pinxixi_mall

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 05/04/2022 23:20:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_admin_user 管理员表
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin_user`;
CREATE TABLE `tb_admin_user` (
                                 `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '管理员id',
                                 `user_name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '管理员名称',
                                 `password` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '管理员密码',
                                 `nick_name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '管理员昵称',
                                 `avatar` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '管理员头像',
                                 `phone` varchar(11) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号',
                                 `email` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
                                 `locked` tinyint DEFAULT '0' COMMENT '是否锁定（0-未锁定，1-已锁定）',
                                 PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='管理员表';

-- ----------------------------
-- Records of tb_admin_user
-- ----------------------------
BEGIN;
INSERT INTO `tb_admin_user` VALUES (1, 'admin', '123', 'pxx1', 'https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png', '16666666666', '123456@qq.com', 0);
INSERT INTO `tb_admin_user` VALUES (2, 'admin1', '123', 'pxx2', 'https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png', '17777777777', '789456@qq.com', 0);
COMMIT;

-- ----------------------------
-- Table structure for tb_admin_user_token
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin_user_token`;
CREATE TABLE `tb_admin_user_token` (
                                       `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '管理员id',
                                       `token` varchar(200) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'token值',
                                       `update_time` datetime NOT NULL COMMENT '更新时间',
                                       `expired_time` datetime NOT NULL COMMENT '过期时间',
                                       PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='管理员token表';

-- ----------------------------
-- Records of tb_admin_user_token
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tb_carousel 轮播图表
-- ----------------------------
DROP TABLE IF EXISTS `tb_carousel`;
CREATE TABLE `tb_carousel` (
                               `carousel_id` int NOT NULL AUTO_INCREMENT COMMENT '轮播图id',
                               `carousel_image` varchar(150) COLLATE utf8mb4_general_ci NOT NULL COMMENT '轮播图片地址',
                               `carousel_url` varchar(150) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '#' COMMENT '轮播图跳转链接',
                               `carousel_sort` int NOT NULL DEFAULT '0' COMMENT '轮播图排序（越小越靠前）',
                               `carousel_status` tinyint NOT NULL DEFAULT '0' COMMENT '状态（0-已下架，1-上架中）',
                               `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '删除标识（0-未删除，1-已删除）',
                               `create_user` int NOT NULL COMMENT '创建人id',
                               `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `update_user` int DEFAULT NULL COMMENT '更新人id',
                               `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
                               PRIMARY KEY (`carousel_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='首页轮播图表';

-- ----------------------------
-- Records of tb_carousel
-- ----------------------------
BEGIN;
INSERT INTO `tb_carousel` VALUES (1, 'http://119.29.134.117:9090/upload/4be41bffb97d8a09_20220405222039.jpg', '##', 1, 0, 0, 1, '2022-04-05 22:20:46', 1, '2022-04-05 22:20:46');
INSERT INTO `tb_carousel` VALUES (2, 'http://119.29.134.117:9090/upload/168ff5869a75742f_20220405222052.jpg', '##', 3, 0, 0, 1, '2022-04-05 22:20:56', 1, '2022-04-05 22:20:56');
INSERT INTO `tb_carousel` VALUES (3, 'http://119.29.134.117:9090/upload/q70_20220405222102.jpeg', '###', 7, 0, 0, 1, '2022-04-05 22:21:11', 1, '2022-04-05 22:21:11');
INSERT INTO `tb_carousel` VALUES (4, 'http://119.29.134.117:9090/upload/ffb936a604b7ac06_20220405222117.jpg', '##', 3, 0, 0, 1, '2022-04-05 22:21:21', 1, '2022-04-05 22:21:21');
INSERT INTO `tb_carousel` VALUES (5, 'http://119.29.134.117:9090/upload/a89719cbbde0cc32_20220405222128.jpg', '###', 5, 0, 0, 1, '2022-04-05 22:21:35', 1, '2022-04-05 22:21:35');
INSERT INTO `tb_carousel` VALUES (6, 'http://119.29.134.117:9090/upload/ffb936a604b7ac06_20220405222141.png', '####', 2, 0, 0, 1, '2022-04-05 22:21:45', 1, '2022-04-05 22:21:45');
INSERT INTO `tb_carousel` VALUES (7, 'http://119.29.134.117:9090/upload/cb7cf5029afef5e3_20220405222158.jpg', '####', 8, 0, 0, 1, '2022-04-05 22:22:05', 1, '2022-04-05 22:22:05');
INSERT INTO `tb_carousel` VALUES (8, 'http://119.29.134.117:9090/upload/5305d110a541898a_20220405222222.jpg', '##', 9, 0, 0, 1, '2022-04-05 22:22:26', 1, '2022-04-05 22:22:26');
INSERT INTO `tb_carousel` VALUES (9, 'http://119.29.134.117:9090/upload/82e124c1104d14c5_20220405222246.jpg', '##', 6, 0, 0, 1, '2022-04-05 22:22:52', 1, '2022-04-05 22:22:52');
COMMIT;

-- ----------------------------
-- Table structure for tb_client_address 用户地址表
-- ----------------------------
DROP TABLE IF EXISTS `tb_client_address`;
CREATE TABLE `tb_client_address` (
                                     `address_id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                     `user_id` bigint NOT NULL DEFAULT '0' COMMENT '用户id',
                                     `name` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '收货人姓名',
                                     `tel` varchar(11) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '收货人手机号',
                                     `is_default` tinyint NOT NULL DEFAULT '0' COMMENT '是否为默认（0-否，1-是）',
                                     `province` varchar(32) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '省',
                                     `province_code` varchar(6) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '省代码',
                                     `city` varchar(32) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '市',
                                     `city_code` varchar(6) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '市代码',
                                     `county` varchar(32) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '区',
                                     `county_code` varchar(6) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '区代码',
                                     `address_detail` varchar(100) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '详细地址',
                                     `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '删除标识（0-未删除，1-已删除）',
                                     `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                     `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
                                     PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='用户地址表';

-- ----------------------------
-- Records of tb_client_address
-- ----------------------------
BEGIN;
INSERT INTO `tb_client_address` VALUES (1, 1, '张三丰', '13666666666', 1, '广东省', '440000', '深圳市', '440301', '南山区', '440305', '深圳湾2号6栋 66 楼', 0, '2022-03-31 19:47:03', '2022-03-31 19:47:03');
INSERT INTO `tb_client_address` VALUES (2, 1, '张四丰', '13777777777', 0, '广东省', '440000', '深圳市', '440301', '南山区', '440305', '深圳湾2号7栋 68 楼', 0, '2022-03-31 19:47:03', '2022-03-31 19:47:03');
COMMIT;

-- ----------------------------
-- Table structure for tb_client_cart 购物车表
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='客户购物车表';

-- ----------------------------
-- Table structure for tb_client_order 订单表
-- ----------------------------
DROP TABLE IF EXISTS `tb_client_order`;
CREATE TABLE `tb_client_order` (
                                   `order_id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单id',
                                   `order_no` varchar(20) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '订单号',
                                   `user_id` bigint NOT NULL DEFAULT '0' COMMENT '用户id',
                                   `order_price` float NOT NULL DEFAULT '0' COMMENT '订单价格',
                                   `address_id` bigint NOT NULL COMMENT '关联地址id',
                                   `order_coupon` float DEFAULT '0' COMMENT '优惠金额',
                                   `payment_status` tinyint NOT NULL DEFAULT '0' COMMENT '支付状态（0-未支付，1-支付成功，2-支付失败）',
                                   `order_status` tinyint NOT NULL DEFAULT '0' COMMENT '订单状态（0-待支付，1-待收货，2-交易成功，3-手动关闭，4-超时关闭，5-商家关闭，99-已删除）',
                                   `payment_type` tinyint NOT NULL DEFAULT '0' COMMENT '支付方式（1-支付宝，2-微信）',
                                   `payment_time` datetime DEFAULT NULL COMMENT '支付时间',
                                   `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '删除标识(0-未删除，1-已删除)',
                                   `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                   `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
                                   PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='客户订单表';

-- ----------------------------
-- Table structure for tb_client_order_goods 订单商品表
-- ----------------------------
DROP TABLE IF EXISTS `tb_client_order_goods`;
CREATE TABLE `tb_client_order_goods` (
                                         `order_goods_id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单商品id',
                                         `order_id` bigint NOT NULL COMMENT '关联订单id',
                                         `goods_id` bigint unsigned NOT NULL COMMENT '商品id',
                                         `goods_name` varchar(150) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '商品名称',
                                         `goods_image` varchar(150) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '商品主图',
                                         `goods_count` int NOT NULL DEFAULT '1' COMMENT '商品数量',
                                         `goods_price` float NOT NULL DEFAULT '0' COMMENT '商品价格',
                                         `goods_desc` varchar(200) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '商品简介',
                                         `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                         `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
                                         PRIMARY KEY (`order_goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='客户订单商品表';

-- ----------------------------
-- Table structure for tb_client_user 用户表
-- ----------------------------
DROP TABLE IF EXISTS `tb_client_user`;
CREATE TABLE `tb_client_user` (
                                  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
                                  `user_name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名称',
                                  `password` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户密码',
                                  `nick_name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户昵称',
                                  `avatar` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户头像',
                                  `phone` varchar(11) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号',
                                  `email` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
                                  `locked` tinyint DEFAULT '0' COMMENT '是否锁定（0-未锁定，1-已锁定）',
                                  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='用户表';

-- ----------------------------
-- Records of tb_client_user
-- ----------------------------
BEGIN;
INSERT INTO `tb_client_user` VALUES (1, 'xx1', '123', '2221111', 'http://127.0.0.1:9090/upload/Screen Shot 2021-08-01 at 4.30.37 PM_20220403002210.png', '16666666666', '123456@qq.com', 0);
INSERT INTO `tb_client_user` VALUES (2, 'client2', '123', 'xx2', 'https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png', '17777777777', '789456@qq.com', 0);
COMMIT;

-- ----------------------------
-- Table structure for tb_goods 商品表
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods` (
                            `goods_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '商品id',
                            `goods_name` varchar(150) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '商品名称',
                            `goods_image` varchar(150) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '商品主图',
                            `goods_category_id` bigint NOT NULL DEFAULT '0' COMMENT '商品分类id',
                            `goods_desc` varchar(200) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '商品简介',
                            `goods_price` float NOT NULL DEFAULT '0' COMMENT '商品价格',
                            `goods_stock` int unsigned NOT NULL DEFAULT '0' COMMENT '商品库存',
                            `goods_status` tinyint NOT NULL DEFAULT '1' COMMENT '商品状态（0-下架，1-上架）',
                            `goods_detail` text COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品详情',
                            `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '删除标识（0-未删除，1-已删除）',
                            `create_user` int NOT NULL DEFAULT '0' COMMENT '创建人id',
                            `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `update_user` int NOT NULL DEFAULT '0' COMMENT '更新人id',
                            `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
                            PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='商品表';

-- ----------------------------
-- Records of tb_goods
-- ----------------------------
BEGIN;
INSERT INTO `tb_goods` VALUES (1, '华为笔记本电脑MateBook', 'http://119.29.134.117:9090/upload/3567e5bf3be31ef2_20220405212511.jpg', 12, '华为笔记本电脑MateBook D 14 SE版 14英寸 11代酷睿 i5 锐炬显卡 8G+512G 轻薄本/高清护眼防眩光屏 银', 3999, 999, 1, '<p>华为笔记本电脑MateBook D 14 SE版 14英寸 11代酷睿 i5 锐炬显卡 8G+512G 轻薄本/高清护眼防眩光屏 银</p>', 0, 1, '2022-04-05 21:29:47', 1, '2022-04-05 22:11:50');
INSERT INTO `tb_goods` VALUES (2, 'HUAWEI 手环6 标准版', 'http://119.29.134.117:9090/upload/89306f92fc8bc71d_20220405213304.jpg', 23, '华为 HUAWEI 手环6 标准版 运动手环 智能手环 炫彩全面屏/2周长续航/96种运动 曜石黑 ', 249, 666, 1, '<p>HUAWEI 手环6 标准版</p>', 0, 1, '2022-04-05 21:33:08', 1, '2022-04-05 21:40:34');
INSERT INTO `tb_goods` VALUES (3, '华为智慧屏', 'http://119.29.134.117:9090/upload/36b708f49fdf828c_20220405214106.jpg', 68, '华为智慧屏 SE 55英寸 超薄电视 广色域鸿鹄画质 4K超高清智能液晶电视机 HD55DESA 2+16GB搭载 HarmonyOS 2', 1699, 122, 1, '<p>华为智慧屏</p>', 0, 1, '2022-04-05 21:42:14', 0, '2022-04-05 21:42:14');
INSERT INTO `tb_goods` VALUES (4, '苏泊尔（SUPOR）电压力锅', 'http://119.29.134.117:9090/upload/6569c280e44e85a5_20220405214418.jpg', 29, '苏泊尔（SUPOR）电压力锅 智能触控 球釜双胆 开盖收汁 一键排压 SY-50YC9001Q 5L高压锅', 369, 555, 1, '<p><span style=\"color:#e8eaed\"><span style=\"font-size:11px\"><span style=\"background-color:#202124\">苏泊尔（SUPOR）电压力锅 智能触控 球釜双胆 开盖收汁 一键排压 SY-50YC9001Q 5L高压锅</span></span></span></p>', 0, 1, '2022-04-05 21:44:20', 0, '2022-04-05 21:44:20');
INSERT INTO `tb_goods` VALUES (5, '美的（Midea）提鲜智能电压力锅', 'http://119.29.134.117:9090/upload/2ec37e0249bda4ca_20220405214525.jpg', 29, '美的（Midea）提鲜智能电压力锅高压锅5L家用多功能双胆高压快煮精控火候压力锅YL50X5-201（3-6人食用', 299, 567, 1, '<p>美的（Midea）提鲜智能电压力锅</p>', 0, 1, '2022-04-05 21:45:28', 0, '2022-04-05 21:45:27');
INSERT INTO `tb_goods` VALUES (6, 'RedmiBookPro14锐龙版', 'http://119.29.134.117:9090/upload/5282379b31f0e527_20220405214716.jpg', 49, 'RedmiBookPro14锐龙版 14英寸高性能轻薄笔记本电脑(8核R7-5700U  16+512G 2.5K全面屏  铝合金机身)深空灰  ', 4399, 777, 1, '<p><span style=\"color:#e8eaed\"><span style=\"font-size:11px\"><span style=\"background-color:#202124\">   RedmiBookPro14锐龙版 14英寸高性能轻薄笔记本电脑(8核R7-5700U  16+512G 2.5K全面屏  铝合金机身)深空灰  </span></span></span></p>', 0, 1, '2022-04-05 21:47:24', 0, '2022-04-05 21:47:23');
INSERT INTO `tb_goods` VALUES (7, 'Apple MacBook Air 13.3', 'http://119.29.134.117:9090/upload/bb2489ac5d2b4ed5_20220405215006.jpg', 56, 'Apple MacBook Air 13.3 八核M1芯片(7核图形处理器) 8G 256G SSD 深空灰 笔记本电脑 MGN63CH/A ', 7999, 10000, 1, '<p>&lt;div class=&quot;search_prolist_title&quot; data-line=&quot;2&quot; data-line-img=&quot;2&quot; rd=&quot;0-4-1&quot;&gt;  Apple&amp;nbsp;MacBook&amp;nbsp;Air&amp;nbsp;13.3&amp;nbsp;八核M1芯片(7核图形处理器)&amp;nbsp;8G&amp;nbsp;256G&amp;nbsp;SSD&amp;nbsp;深空灰&amp;nbsp;笔记本电脑&amp;nbsp;MGN63CH/A  &lt;/div&gt;</p>', 0, 1, '2022-04-05 21:50:09', 0, '2022-04-05 21:50:08');
INSERT INTO `tb_goods` VALUES (8, '小米（MI)', 'http://119.29.134.117:9090/upload/0b92f82917a9c400_20220405215145.jpg', 19, '小米（MI） Redmi Note9 Pro', 1349, 666, 1, '<p><span style=\"color:#e8eaed\"><span style=\"font-size:11px\"><span style=\"background-color:#202124\">小米（MI） Redmi Note9 Pro</span></span></span></p>', 0, 1, '2022-04-05 21:51:55', 1, '2022-04-05 21:53:16');
INSERT INTO `tb_goods` VALUES (9, 'vivo iQOO Z5x ', 'http://119.29.134.117:9090/upload/31c2c9d21686afba_20220405215256.jpg', 15, 'vivo iQOO Z5x 8GB+128GB 砂岩橙 44w闪充 5000mAh大电池 120Hz高刷屏 双模5G全网通手机iqooz5x', 1389, 888, 1, '<p>vivo iQOO Z5x </p>', 0, 1, '2022-04-05 21:53:06', 0, '2022-04-05 21:53:05');
INSERT INTO `tb_goods` VALUES (10, '4G全网通 移动联通电信老人手机', 'http://119.29.134.117:9090/upload/9a467f6b410239c4_20220405215436.jpg', 18, '纽曼 Newman 9s 星空黑 4G全网通 移动联通电信老人手机 超长待机 大字大声大按键老年机 学生儿童备用功能机  ', 129, 99999, 1, '<p><span style=\"color:#e8eaed\"><span style=\"font-size:11px\"><span style=\"background-color:#202124\">  纽曼 Newman 9s 星空黑 4G全网通 移动联通电信老人手机 超长待机 大字大声大按键老年机 学生儿童备用功能机  </span></span></span></p>', 0, 1, '2022-04-05 21:54:54', 0, '2022-04-05 21:54:54');
INSERT INTO `tb_goods` VALUES (11, 'Apple iPhone 13', 'http://119.29.134.117:9090/upload/9866663e36ed6ee8_20220405215549.jpg', 20, 'Apple iPhone 13', 5999, 333, 1, '<p><span style=\"color:#e8eaed\"><span style=\"font-size:11px\"><span style=\"background-color:#202124\">Apple iPhone 13</span></span></span></p>', 0, 1, '2022-04-05 21:56:15', 0, '2022-04-05 21:56:14');
INSERT INTO `tb_goods` VALUES (12, 'LOVO乐蜗家纺 ', 'http://119.29.134.117:9090/upload/a9684370c74a716a_20220405215932.jpg', 87, 'LOVO乐蜗家纺 被子被芯春秋被大豆纤维被空调被A类标准面料单双人四季被褥 抗菌防螨 1.5米床 200*230cm', 279, 66, 1, '<p>LOVO乐蜗家纺 </p>', 0, 1, '2022-04-05 21:59:44', 0, '2022-04-05 21:59:44');
INSERT INTO `tb_goods` VALUES (13, '雅得(ATTOP TOYS) 遥控飞机', 'http://119.29.134.117:9090/upload/346af215a1ba9565_20220405220550.jpg', 76, '雅得(ATTOP TOYS) 遥控飞机 玩具阿凡达战斗机四通道直升机航模型 YD-718', 168, 888, 1, '<p>雅得(ATTOP TOYS) 遥控飞机</p>', 0, 1, '2022-04-05 22:06:00', 0, '2022-04-05 22:06:00');
INSERT INTO `tb_goods` VALUES (14, '星海钢琴 ', 'http://119.29.134.117:9090/upload/1518c610d142e20b_20220405220735.jpg', 80, '星海钢琴 XU-120立式钢琴德国进口配件 儿童初学考级通用1-10级 88键', 18000, 45, 1, '<p>星海钢琴 </p>', 0, 1, '2022-04-05 22:07:46', 0, '2022-04-05 22:07:46');
INSERT INTO `tb_goods` VALUES (15, '宾卡达品牌手表', 'http://119.29.134.117:9090/upload/008dcb2fde1432e5_20220405220916.jpg', 101, '\n【多仓速发】宾卡达品牌手表男全自动夜光日历运动钢带防水时尚机械风格学生国表瑞士工艺情侣生日情人节礼物 【机械风格-终身质保】商务黑5003', 188, 56, 1, '<p>宾卡达品牌手表</p>', 0, 1, '2022-04-05 22:09:26', 0, '2022-04-05 22:09:25');
INSERT INTO `tb_goods` VALUES (16, 'snoopy史努比手表', 'http://119.29.134.117:9090/upload/cd0131dcb032d755_20220405221053.jpg', 101, 'snoopy史努比手表女学生运动防水夜光多功能双显电子表初中生高中学生腕表少女ins风潮流情侣男女款 磨砂抹茶绿【精准走时】', 129, 777, 1, '<p>snoopy史努比手表</p>', 0, 1, '2022-04-05 22:11:03', 0, '2022-04-05 22:11:03');
INSERT INTO `tb_goods` VALUES (17, 'Apple iPhone 13 Pro Max', 'http://119.29.134.117:9090/upload/dda8594cdee01aa8_20220405221313.jpg', 19, 'Apple iPhone 13 Pro Max (A2644) 256GB 苍岭绿色 支持移动联通电信5G 双卡双待手机', 9799, 678, 1, '<p>Apple iPhone 13 Pro Max</p>', 0, 1, '2022-04-05 22:13:25', 0, '2022-04-05 22:13:24');
INSERT INTO `tb_goods` VALUES (18, '一加 9RT', 'http://119.29.134.117:9090/upload/3dfb60db54087d45_20220405221509.jpg', 19, '一加 9RT 5G 120Hz 高刷好屏12GB+256GB 暗物质 高通骁龙888 65T快充 原神专业超广角拍照手机', 3499, 333, 1, '<p>一加 9RT 5G 120Hz 高刷好屏12GB+256GB 暗物质 高通骁龙888 65T快充 原神专业超广角拍照手机</p>', 0, 1, '2022-04-05 22:15:20', 0, '2022-04-05 22:15:19');
INSERT INTO `tb_goods` VALUES (19, '美的(Midea)606升变频一级能效', 'http://119.29.134.117:9090/upload/78f5f2e70c43dcad_20220405221706.jpg', 37, '美的(Midea)606升变频一级能效对开双门家用冰箱京东小家智能家电风冷无霜BCD-606WKPZM(E)大容量精细分储', 2899, 777, 1, '<p>美的(Midea)606升变频一级能效对开双门家用冰箱京东小家智能家电风冷无霜BCD-606WKPZM(E)大容量精细分储</p>', 0, 1, '2022-04-05 22:17:14', 0, '2022-04-05 22:17:14');
INSERT INTO `tb_goods` VALUES (20, '海尔 (Haier) 328升风冷无霜', 'http://119.29.134.117:9090/upload/d6e55f670288976a_20220405221813.jpg', 37, '海尔 (Haier) 328升风冷无霜纤薄变频四门除菌租房小冰箱多门一级能效三档变温全开抽屉节能低噪 BCD-328WDPD', 3099, 666, 1, '<p>海尔 (Haier) 328升风冷无霜</p>', 0, 1, '2022-04-05 22:18:33', 0, '2022-04-05 22:18:33');
COMMIT;

-- ----------------------------
-- Table structure for tb_goods_category 商品分类表
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods_category`;
CREATE TABLE `tb_goods_category` (
                                     `category_id` bigint NOT NULL AUTO_INCREMENT COMMENT '分类id',
                                     `category_name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '分类名称',
                                     `category_level` tinyint NOT NULL DEFAULT '0' COMMENT '分类级别(1-一级分类，2-二级分类，3-三级分类)',
                                     `parent_id` bigint NOT NULL DEFAULT '0' COMMENT '父级分类id',
                                     `category_image` varchar(150) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '分类图标',
                                     `category_sort` int NOT NULL DEFAULT '0' COMMENT '排序',
                                     `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '删除标识(0-未删除，1-已删除)',
                                     `create_user` int NOT NULL DEFAULT '0' COMMENT '创建人id',
                                     `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                     `update_user` int DEFAULT '0' COMMENT '更新人id',
                                     `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
                                     PRIMARY KEY (`category_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='商品分类表';

-- ----------------------------
-- Records of tb_goods_category
-- ----------------------------
BEGIN;
INSERT INTO `tb_goods_category` VALUES (10, '手机数码', 1, 0, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (11, '热门分类', 2, 10, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (12, '华为', 3, 11, 'https://img14.360buyimg.com/focus/s140x140_jfs/t11929/135/2372293765/1396/e103ec31/5a1692e2Nbea6e136.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (13, '小米', 3, 11, 'https://img30.360buyimg.com/focus/s140x140_jfs/t13411/188/926813276/3945/a4f47292/5a1692eeN105a64b4.png', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (14, 'OPPO', 3, 11, 'https://img13.360buyimg.com/focus/s140x140_jfs/t13036/273/932026474/2570/a3517c7d/5a169254N4bbbd9fb.png', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (15, 'vivo', 3, 11, 'https://img11.360buyimg.com/focus/s140x140_jfs/t11014/359/2341377211/2777/1755c29c/5a169244Nff0179e0.png', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (16, 'iPhone', 3, 11, 'https://img20.360buyimg.com/focus/s140x140_jfs/t13759/194/897734755/2493/1305d4c4/5a1692ebN8ae73077.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (17, '手机通讯', 2, 10, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (18, '老人机', 3, 17, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (19, '手机', 3, 17, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (20, '全面屏手机', 3, 17, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (21, '拍照手机', 3, 17, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (22, '智能设备', 2, 10, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (23, '智能手环', 3, 22, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (24, '智能手表', 3, 22, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (25, '智能家居', 3, 22, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (26, '智能机器人', 3, 22, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (27, '家用电器', 1, 0, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (28, '厨房小电', 2, 27, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (29, '电压力锅', 3, 28, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (30, '电水壶', 3, 28, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (31, '电饭煲', 3, 28, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (32, '电磁炉', 3, 28, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (33, '微波炉', 3, 28, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (34, '冰箱', 2, 27, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (35, '全部', 3, 34, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (36, '双门冰箱', 3, 34, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (37, '对开门冰箱', 3, 34, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (38, '十字对开门', 3, 34, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (39, '三门冰箱', 3, 34, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (40, '单门冰箱', 3, 34, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (41, '洗衣机', 2, 27, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (42, '全部', 3, 41, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (43, '波轮洗衣机', 3, 41, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (44, '滚筒洗衣机', 3, 41, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (45, '洗烘一体机', 3, 41, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (46, '迷你洗衣机', 3, 41, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (47, '电脑办公', 1, 0, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (48, '热门分类', 2, 47, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (49, '轻薄本', 3, 48, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (50, '游戏本', 3, 48, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (51, '组装电脑', 3, 48, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (52, '移动硬盘', 3, 48, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (53, '显卡', 3, 48, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (54, '家用打印机', 3, 48, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (55, '电脑整机', 2, 47, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (56, '笔记本', 3, 55, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (57, '平板电脑', 3, 55, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (58, '一体机', 3, 55, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (59, '台式机', 3, 55, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (60, '游戏本', 3, 55, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (61, '工作站', 3, 55, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (62, '外设产品', 2, 47, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (63, '鼠标', 3, 62, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (64, '键盘', 3, 62, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (65, 'U盘', 3, 62, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (66, '手写板', 3, 62, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (67, '电脑配件', 2, 47, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (68, '显示器', 3, 67, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (69, '硬盘', 3, 67, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (70, '内存', 3, 67, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (71, 'CPU', 3, 67, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (72, '玩具乐器', 1, 0, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (73, '遥控电动', 2, 72, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (74, '机器人', 3, 73, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (75, '遥控车', 3, 73, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (76, '遥控飞机', 3, 73, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (77, '遥控船', 3, 73, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (78, '乐器', 2, 72, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (79, '口琴', 3, 78, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (80, '钢琴', 3, 78, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (81, '电子琴', 3, 78, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (82, '尤克里里', 3, 78, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (83, '吉他', 3, 78, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (84, '大提琴', 3, 78, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (85, '家居厨具', 1, 0, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (86, '家纺', 2, 85, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (87, '床垫/床褥', 3, 86, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (88, '枕套枕巾', 3, 86, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (89, '地毯', 3, 86, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (90, '电热毯', 3, 86, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (91, '床单被罩', 3, 86, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (92, '家装软饰', 2, 85, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (93, '墙贴', 3, 92, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (94, '装饰贴', 3, 92, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (95, '装饰摆件', 3, 92, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (96, '花瓶花艺', 3, 92, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (97, '字画', 3, 92, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (98, '钟表珠宝', 1, 0, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (99, '钟表', 2, 98, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (100, '瑞表', 3, 99, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (101, '国表', 3, 99, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (102, '德表', 3, 99, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (103, '儿童手表', 3, 99, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (104, '时尚饰品', 2, 98, 'https://img20.360buyimg.com/focus/s140x140_jfs/t12025/78/1448076677/9858/5266090/5a1fd567Ncd4ac955.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (105, '戒指', 3, 104, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (106, '耳饰', 3, 104, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (107, '手链', 3, 104, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
INSERT INTO `tb_goods_category` VALUES (108, '项链', 3, 104, 'https://img10.360buyimg.com/focus/s140x140_jfs/t13252/193/948884668/3832/2cd704d4/5a17b918N0785e503.jpg', 1, 0, 1, '2022-02-02 09:09:09', 1, '2022-02-02 09:09:09');
COMMIT;

-- ----------------------------
-- Table structure for tb_recommend_goods 推荐商品表
-- ----------------------------
DROP TABLE IF EXISTS `tb_recommend_goods`;
CREATE TABLE `tb_recommend_goods` (
                                      `recommend_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '推荐商品id',
                                      `goods_id` bigint unsigned NOT NULL COMMENT '商品id',
                                      `recommend_desc` varchar(150) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '推荐商品描述',
                                      `recommend_sort` int NOT NULL DEFAULT '0' COMMENT '推荐排序（越小越靠前）',
                                      `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '删除标识（0-未删除，1-已删除）',
                                      `create_user` int NOT NULL DEFAULT '0' COMMENT '创建人id',
                                      `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                      `update_user` int NOT NULL DEFAULT '0' COMMENT '更新人id',
                                      `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
                                      PRIMARY KEY (`recommend_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='推荐商品表';

-- ----------------------------
-- Records of tb_recommend_goods
-- ----------------------------
BEGIN;
INSERT INTO `tb_recommend_goods` VALUES (1, 18, '拼西西千亿补贴 立减900', 1, 0, 0, '2022-04-05 22:23:58', 0, '2022-04-05 22:23:58');
INSERT INTO `tb_recommend_goods` VALUES (2, 19, '99%抗菌率 一级变频', 0, 0, 0, '2022-04-05 22:28:07', 0, '2022-04-05 22:28:07');
INSERT INTO `tb_recommend_goods` VALUES (3, 17, 'Apple iPhone 13 Pro Max \n满1000减100 ', 2, 0, 0, '2022-04-05 22:45:14', 0, '2022-04-05 22:45:14');
INSERT INTO `tb_recommend_goods` VALUES (4, 6, '大电池持久续航 2.5K高清护眼膜\nR78核处理器【锐龙】', 3, 0, 0, '2022-04-05 22:47:03', 0, '2022-04-05 22:47:03');
INSERT INTO `tb_recommend_goods` VALUES (5, 4, '苏泊尔电炖锅 全面开抢', 4, 0, 0, '2022-04-05 22:48:46', 0, '2022-04-05 22:48:46');
INSERT INTO `tb_recommend_goods` VALUES (6, 2, 'HUAWEI 手环6 标准版 全天候血氧监测\n高清炫彩全面屏', 4, 0, 0, '2022-04-05 22:49:51', 0, '2022-04-05 22:49:51');
INSERT INTO `tb_recommend_goods` VALUES (7, 7, 'Apple MacBook Air 13.3\n强得很', 6, 0, 0, '2022-04-05 22:51:35', 0, '2022-04-05 22:51:35');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
