-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: hixtrip
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `category_id` bigint NOT NULL COMMENT '商品分类id',
  `price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `image` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片',
  `description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述信息',
  `status` int DEFAULT '1' COMMENT '0 停售 1 起售',
  `stock` int DEFAULT '0' COMMENT '库存',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_user` bigint DEFAULT NULL COMMENT '创建人',
  `update_user` bigint DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_product_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=642779109878784010 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`, `name`, `category_id`, `price`, `image`, `description`, `status`, `stock`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (642779109878784001,'商品1',1001,99.99,'image1.jpg','这是商品1的描述',1,100,'2023-04-25 10:00:00','2023-04-25 10:00:00',10001,10001),(642779109878784002,'商品2',1002,199.99,'image2.jpg','这是商品2的描述',1,200,'2023-04-25 10:10:00','2023-04-25 10:10:00',10002,10002),(642779109878784003,'商品3',1003,299.99,'image3.jpg','这是商品3的描述',1,300,'2023-04-25 10:20:00','2023-04-25 10:20:00',10003,10003),(642779109878784004,'商品4',1004,399.99,'image4.jpg','这是商品4的描述',1,400,'2023-04-25 10:30:00','2023-04-25 10:30:00',10004,10004),(642779109878784005,'商品5',1005,499.99,'image5.jpg','这是商品5的描述',1,500,'2023-04-25 10:40:00','2023-04-25 10:40:00',10005,10005),(642779109878784006,'商品6',1006,599.99,'image6.jpg','这是商品6的描述',1,600,'2023-04-25 10:50:00','2023-04-25 10:50:00',10006,10006),(642779109878784007,'商品7',1007,699.99,'image7.jpg','这是商品7的描述',1,700,'2023-04-25 11:00:00','2023-04-25 11:00:00',10007,10007),(642779109878784008,'商品8',1008,799.99,'image8.jpg','这是商品8的描述',1,800,'2023-04-25 11:10:00','2023-04-25 11:10:00',10008,10008),(642779109878784009,'商品9',1009,899.99,'image9.jpg','这是商品9的描述',1,900,'2023-04-25 11:20:00','2023-04-25 11:20:00',10009,10009);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_orders`
--

DROP TABLE IF EXISTS `product_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_orders` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_number` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '订单号',
  `status` int NOT NULL DEFAULT '1' COMMENT '订单状态 1待付款 2待发货 3已发货 4已完成 5已取消 6退款',
  `user_id` bigint NOT NULL COMMENT '下单用户',
  `address_id` bigint NOT NULL COMMENT '地址id',
  `product_id` bigint NOT NULL COMMENT '商品id',
  `order_time` datetime NOT NULL COMMENT '下单时间',
  `product_number` int DEFAULT NULL COMMENT '商品总数',
  `product_prices` decimal(10,2) DEFAULT NULL COMMENT '商品总价',
  `checkout_time` datetime DEFAULT NULL COMMENT '结账时间',
  `pay_method` int NOT NULL DEFAULT '1' COMMENT '支付方式 1微信,2支付宝',
  `pay_status` tinyint NOT NULL DEFAULT '0' COMMENT '支付状态 0未支付 1已支付 2退款',
  `amount` decimal(10,2) NOT NULL COMMENT '实收金额',
  `remark` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `phone` varchar(11) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号',
  `address` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地址',
  `user_name` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户名称',
  `consignee` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '收货人',
  `cancel_reason` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '订单取消原因',
  `rejection_reason` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '订单拒绝原因',
  `cancel_time` datetime DEFAULT NULL COMMENT '订单取消时间',
  `delivery_time` datetime DEFAULT NULL COMMENT '送达时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=642779109878785016 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品订单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_orders`
--

LOCK TABLES `product_orders` WRITE;
/*!40000 ALTER TABLE `product_orders` DISABLE KEYS */;
INSERT INTO `product_orders` (`id`, `order_number`, `status`, `user_id`, `address_id`, `product_id`, `order_time`, `product_number`, `product_prices`, `checkout_time`, `pay_method`, `pay_status`, `amount`, `remark`, `phone`, `address`, `user_name`, `consignee`, `cancel_reason`, `rejection_reason`, `cancel_time`, `delivery_time`) VALUES (642779109878785011,'ON202304250001',1,20001,30001,642779109878784001,'2023-04-25 12:00:00',2,199.98,NULL,1,0,199.98,'请尽快发货','13800138000','某省某市某区某街道1号','张三','张三',NULL,NULL,NULL,NULL),(642779109878785012,'ON202304250002',2,20002,30002,642779109878784002,'2023-04-25 12:10:00',1,199.99,'2023-04-25 12:15:00',2,1,199.99,'无','13900139000','某省某市某区某街道2号','李四','李四',NULL,NULL,NULL,NULL),(642779109878785013,'ON202304250003',3,20003,30003,642779109878784003,'2023-04-25 12:20:00',3,899.97,'2023-04-25 12:25:00',1,1,899.97,'发顺丰','13700137000','某省某市某区某街道3号','王五','王五',NULL,NULL,NULL,NULL),(642779109878785014,'ON202304250004',4,20004,30004,642779109878784004,'2023-04-25 12:30:00',1,399.99,'2023-04-25 12:35:00',2,1,399.99,'收件人电话错了，换成：13100131000','13100131000','某省某市某区某街道4号','赵六','赵六',NULL,NULL,NULL,'2023-04-28 10:00:00'),(642779109878785015,'ON202304250005',5,20005,30005,642779109878784005,'2023-04-25 12:40:00',5,2499.95,'2023-04-25 12:45:00',1,0,2499.95,'无','13200132000','某省某市某区某街道5号','钱七','钱七','我不想要了',NULL,'2023-04-25 13:00:00',NULL);
/*!40000 ALTER TABLE `product_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'hixtrip'
--

--
-- Dumping routines for database 'hixtrip'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-26  1:08:12
