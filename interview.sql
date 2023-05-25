/*
 Navicat Premium Data Transfer

 Source Server         : hello
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : interview

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 25/05/2023 12:03:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for collection_info
-- ----------------------------
DROP TABLE IF EXISTS `collection_info`;
CREATE TABLE `collection_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `titleId` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of collection_info
-- ----------------------------
BEGIN;
INSERT INTO `collection_info` (`id`, `userId`, `titleId`) VALUES (22, 10, 21);
INSERT INTO `collection_info` (`id`, `userId`, `titleId`) VALUES (23, 10, 20);
COMMIT;

-- ----------------------------
-- Table structure for remark
-- ----------------------------
DROP TABLE IF EXISTS `remark`;
CREATE TABLE `remark` (
  `id` int NOT NULL AUTO_INCREMENT,
  `comment_content` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `comment_time` datetime DEFAULT NULL,
  `comment_img` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `thumbs` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `title_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of remark
-- ----------------------------
BEGIN;
INSERT INTO `remark` (`id`, `comment_content`, `comment_time`, `comment_img`, `thumbs`, `user_id`, `title_id`) VALUES (1, 'dsad', '2023-05-07 05:37:00', 'https://srbtest1.oss-cn-beijing.aliyuncs.com/commentImg/2023/05/07/7970c3df-fb07-4008-80e9-612b12ece4ea.jpg', 1, 10, 14);
INSERT INTO `remark` (`id`, `comment_content`, `comment_time`, `comment_img`, `thumbs`, `user_id`, `title_id`) VALUES (2, '', '2023-05-07 05:57:51', '', 0, 10, 14);
INSERT INTO `remark` (`id`, `comment_content`, `comment_time`, `comment_img`, `thumbs`, `user_id`, `title_id`) VALUES (3, '213213', '2023-05-07 05:58:34', 'https://srbtest1.oss-cn-beijing.aliyuncs.com/commentImg/2023/05/07/fecc39cc-5da2-4384-9236-6136e0dbb907.jpeg', 0, 10, 14);
INSERT INTO `remark` (`id`, `comment_content`, `comment_time`, `comment_img`, `thumbs`, `user_id`, `title_id`) VALUES (4, 'sdasd', '2023-05-07 06:04:30', 'https://srbtest1.oss-cn-beijing.aliyuncs.com/commentImg/2023/05/07/99db2f80-940c-49fb-b2c1-5a5730de80a6.webp', 0, 10, 14);
INSERT INTO `remark` (`id`, `comment_content`, `comment_time`, `comment_img`, `thumbs`, `user_id`, `title_id`) VALUES (5, '的撒的', '2023-05-07 06:08:04', 'https://srbtest1.oss-cn-beijing.aliyuncs.com/commentImg/2023/05/07/3a21f492-0dd7-4975-9802-6dcea9d4bdf7.jpg', 3, 10, 21);
INSERT INTO `remark` (`id`, `comment_content`, `comment_time`, `comment_img`, `thumbs`, `user_id`, `title_id`) VALUES (6, '点点滴滴', '2023-05-07 06:13:01', 'https://srbtest1.oss-cn-beijing.aliyuncs.com/commentImg/2023/05/07/674968d3-a6e6-4afb-952e-ebca6d3d20ec.jpg', 0, 10, 21);
INSERT INTO `remark` (`id`, `comment_content`, `comment_time`, `comment_img`, `thumbs`, `user_id`, `title_id`) VALUES (7, '大声点', '2023-05-07 06:14:37', 'https://srbtest1.oss-cn-beijing.aliyuncs.com/commentImg/2023/05/07/5431eb15-dfe1-448c-9702-dbf6fc3cfe14.jpg', 2, 10, 21);
INSERT INTO `remark` (`id`, `comment_content`, `comment_time`, `comment_img`, `thumbs`, `user_id`, `title_id`) VALUES (8, '大声点', '2023-05-07 06:15:47', 'https://srbtest1.oss-cn-beijing.aliyuncs.com/commentImg/2023/05/07/62cce7d8-8d65-46a0-b2eb-435f6de5bc7e.jpg', 0, 10, 21);
INSERT INTO `remark` (`id`, `comment_content`, `comment_time`, `comment_img`, `thumbs`, `user_id`, `title_id`) VALUES (9, '', '2023-05-07 07:46:46', '', 1, 10, 21);
INSERT INTO `remark` (`id`, `comment_content`, `comment_time`, `comment_img`, `thumbs`, `user_id`, `title_id`) VALUES (10, NULL, '2023-05-07 07:57:13', NULL, 0, NULL, NULL);
INSERT INTO `remark` (`id`, `comment_content`, `comment_time`, `comment_img`, `thumbs`, `user_id`, `title_id`) VALUES (11, '百度百科的答案', '2023-05-21 05:33:32', 'https://srbtest1.oss-cn-beijing.aliyuncs.com/commentImg/2023/05/21/6684133f-556f-4fc8-a9e8-924e3203e6ad.png', 1, 10, 28);
COMMIT;

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `id` int NOT NULL AUTO_INCREMENT,
  `reply_content` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `reply_time` datetime DEFAULT NULL,
  `remark_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of reply
-- ----------------------------
BEGIN;
INSERT INTO `reply` (`id`, `reply_content`, `reply_time`, `remark_id`) VALUES (1, 'dsad', '2023-05-07 07:59:00', 9);
INSERT INTO `reply` (`id`, `reply_content`, `reply_time`, `remark_id`) VALUES (2, 'sadsad', '2023-05-07 08:25:54', 8);
INSERT INTO `reply` (`id`, `reply_content`, `reply_time`, `remark_id`) VALUES (3, '321321', '2023-05-07 08:26:47', 8);
INSERT INTO `reply` (`id`, `reply_content`, `reply_time`, `remark_id`) VALUES (4, '4324324234', '2023-05-07 08:27:50', 8);
INSERT INTO `reply` (`id`, `reply_content`, `reply_time`, `remark_id`) VALUES (5, '4324324234', '2023-05-07 08:27:59', 8);
INSERT INTO `reply` (`id`, `reply_content`, `reply_time`, `remark_id`) VALUES (6, '4324324234', '2023-05-07 08:28:04', 8);
INSERT INTO `reply` (`id`, `reply_content`, `reply_time`, `remark_id`) VALUES (7, '大声点说', '2023-05-07 08:39:15', 8);
INSERT INTO `reply` (`id`, `reply_content`, `reply_time`, `remark_id`) VALUES (8, 'dsadsa', '2023-05-07 08:40:35', 9);
INSERT INTO `reply` (`id`, `reply_content`, `reply_time`, `remark_id`) VALUES (9, 'dsad', '2023-05-07 08:42:00', 6);
INSERT INTO `reply` (`id`, `reply_content`, `reply_time`, `remark_id`) VALUES (10, 'rewruoiewr', '2023-05-08 09:53:00', 5);
INSERT INTO `reply` (`id`, `reply_content`, `reply_time`, `remark_id`) VALUES (11, '是这样子的', '2023-05-21 05:33:49', 11);
COMMIT;

-- ----------------------------
-- Table structure for test_paper
-- ----------------------------
DROP TABLE IF EXISTS `test_paper`;
CREATE TABLE `test_paper` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tags` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `img` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `view_num` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of test_paper
-- ----------------------------
BEGIN;
INSERT INTO `test_paper` (`id`, `tags`, `title`, `img`, `user_id`, `create_time`, `view_num`) VALUES (1, 'java,前端,', 'dads', 'https://srbtest1.oss-cn-beijing.aliyuncs.com/testPaper/2023/05/09/8716f8da-99da-4b6a-9d1e-6003a2f0bb14.jpg', NULL, '2023-05-09 13:14:23', 0);
INSERT INTO `test_paper` (`id`, `tags`, `title`, `img`, `user_id`, `create_time`, `view_num`) VALUES (2, 'python,前端,', 'ddd', 'https://srbtest1.oss-cn-beijing.aliyuncs.com/testPaper/2023/05/09/2f55fb33-3315-43f6-8aff-0dfa1248eb13.jpg', 10, '2023-05-09 13:16:33', 0);
INSERT INTO `test_paper` (`id`, `tags`, `title`, `img`, `user_id`, `create_time`, `view_num`) VALUES (4, '前端,', '121', 'https://srbtest1.oss-cn-beijing.aliyuncs.com/testPaper/2023/05/13/c9bea856-2b55-4964-802f-591c0ededb0a.pdf', 10, '2023-05-13 10:13:06', 0);
COMMIT;

-- ----------------------------
-- Table structure for title
-- ----------------------------
DROP TABLE IF EXISTS `title`;
CREATE TABLE `title` (
  `id` int NOT NULL AUTO_INCREMENT,
  `question_type` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `difficulty` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tag` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `title_name` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `explains` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `remarks` varchar(10000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `page_views` int DEFAULT NULL,
  `collection_number` int DEFAULT NULL,
  `message_number` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of title
-- ----------------------------
BEGIN;
INSERT INTO `title` (`id`, `question_type`, `difficulty`, `tag`, `title_name`, `explains`, `remarks`, `user_id`, `create_time`, `page_views`, `collection_number`, `message_number`) VALUES (9, '单选', '中等', '选项4', '<p>dsad</p>', NULL, 'sada', 10, '2023-05-03 04:21:39', 0, 0, 0);
INSERT INTO `title` (`id`, `question_type`, `difficulty`, `tag`, `title_name`, `explains`, `remarks`, `user_id`, `create_time`, `page_views`, `collection_number`, `message_number`) VALUES (10, '单选', '中等', '选项2', '<p>dasd</p>', NULL, 'dasdas', 10, '2023-05-03 04:23:06', 0, 0, 0);
INSERT INTO `title` (`id`, `question_type`, `difficulty`, `tag`, `title_name`, `explains`, `remarks`, `user_id`, `create_time`, `page_views`, `collection_number`, `message_number`) VALUES (11, '单选', '中等', '选项2', '<p>dasd</p>', NULL, 'dasdas', 10, '2023-05-03 04:23:39', 0, 0, 0);
INSERT INTO `title` (`id`, `question_type`, `difficulty`, `tag`, `title_name`, `explains`, `remarks`, `user_id`, `create_time`, `page_views`, `collection_number`, `message_number`) VALUES (12, '单选', '中等', '选项2', '<p>dasd</p>', NULL, 'dasdas', 10, '2023-05-03 04:24:06', 0, 0, 0);
INSERT INTO `title` (`id`, `question_type`, `difficulty`, `tag`, `title_name`, `explains`, `remarks`, `user_id`, `create_time`, `page_views`, `collection_number`, `message_number`) VALUES (13, '单选', '中等', '选项4', '<p>dsad</p>', '<p>dasd</p>', 'dsad', 10, '2023-05-03 04:29:33', 1, 0, 0);
INSERT INTO `title` (`id`, `question_type`, `difficulty`, `tag`, `title_name`, `explains`, `remarks`, `user_id`, `create_time`, `page_views`, `collection_number`, `message_number`) VALUES (15, '单选', '中等', 'C++', '<p>大声点</p>', '<p>大声点</p>', '大声点', 10, '2023-05-03 04:53:47', 0, 0, 0);
INSERT INTO `title` (`id`, `question_type`, `difficulty`, `tag`, `title_name`, `explains`, `remarks`, `user_id`, `create_time`, `page_views`, `collection_number`, `message_number`) VALUES (16, '单选', '中等', '前端', '<p>dsad</p>', '<p>das</p>', 'dsadas', 10, '2023-05-03 04:55:46', 0, 0, 0);
INSERT INTO `title` (`id`, `question_type`, `difficulty`, `tag`, `title_name`, `explains`, `remarks`, `user_id`, `create_time`, `page_views`, `collection_number`, `message_number`) VALUES (17, '单选', '中等', '选项6', '<p>dsaddsa</p>', '<p>dsa</p>', 'ssss', 10, '2023-05-03 04:56:04', 0, 0, 0);
INSERT INTO `title` (`id`, `question_type`, `difficulty`, `tag`, `title_name`, `explains`, `remarks`, `user_id`, `create_time`, `page_views`, `collection_number`, `message_number`) VALUES (18, '单选', '中等', '选项6', '<p>大声点</p>', '<p>打算</p>', '大大说', 10, '2023-05-03 04:59:48', 1, 0, 0);
INSERT INTO `title` (`id`, `question_type`, `difficulty`, `tag`, `title_name`, `explains`, `remarks`, `user_id`, `create_time`, `page_views`, `collection_number`, `message_number`) VALUES (20, '单选', '中等', 'Java', '<p style=\"text-indent: 0px; text-align: start;\"><span style=\"color: rgb(16, 18, 20); background-color: rgb(255, 255, 255); font-size: 14px;\">ConcurrentLinkedQueue的数据结构?</span></p>', '<p>ConcurrentLinkedQueue的数据结构与LinkedBlockingQueue的数据结构相同，都是使用的链表结构</p>', 'wu', 10, '2023-05-03 09:44:49', 37, 4, 0);
INSERT INTO `title` (`id`, `question_type`, `difficulty`, `tag`, `title_name`, `explains`, `remarks`, `user_id`, `create_time`, `page_views`, `collection_number`, `message_number`) VALUES (21, '单选', '中等', 'Java', '<p style=\"text-indent: 0px; text-align: start;\"><span style=\"color: rgb(16, 18, 20); background-color: rgb(255, 255, 255); font-size: 14px;\">ConcurrentLinkedQueue底层原理?</span></p>', '<p>说明: 属性中包含了head域和tail域，表示链表的头节点和尾结点，同时，ConcurrentLinkedQueue也使用了反射机制和CAS机制来更新头节点和尾结点，保证原子性。</p><h4><a href=\"https://pdai.tech/md/interview/x-interview.html#concurrentlinkedqueue%E7%9A%84%E6%A0%B8%E5%BF%83%E6%96%B9%E6%B3%95%E6%9C%89%E5%93%AA%E4%BA%9B\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"color: var(--c-text-accent);\">#</a></h4><h4><br></h4><p><br></p>', '无', 10, '2023-05-03 09:45:46', 91, 9, 0);
INSERT INTO `title` (`id`, `question_type`, `difficulty`, `tag`, `title_name`, `explains`, `remarks`, `user_id`, `create_time`, `page_views`, `collection_number`, `message_number`) VALUES (28, '简答', '简单', 'Java', '<p><strong>什么是函数式编程？Lambda表达式？</strong></p>', '<ul><li><strong>函数式编程</strong></li></ul><p>面向对象编程是对数据进行抽象；函数式编程是对行为进行抽象。</p><p>核心思想: 使用不可变值和函数，函数对一个值进行处理，映射成另一个值。</p><ul><li><strong>Lambda表达式</strong></li></ul><p>lambda表达式仅能放入如下代码: 预定义使用了 <code>@Functional</code> 注释的函数式接口，自带一个抽象函数的方法，或者SAM(Single Abstract Method 单个抽象方法)类型。这些称为lambda表达式的目标类型，可以用作返回类型，或lambda目标代码的参数。例如，若一个方法接收Runnable、Comparable或者 Callable 接口，都有单个抽象方法，可以传入lambda表达式。类似的，如果一个方法接受声明于 java.util.function 包内的接口，例如 Predicate、Function、Consumer 或 Supplier，那么可以向其传lambda表达式</p><p><br></p>', '函数编程', 10, '2023-05-21 05:30:54', 4, 0, 0);
INSERT INTO `title` (`id`, `question_type`, `difficulty`, `tag`, `title_name`, `explains`, `remarks`, `user_id`, `create_time`, `page_views`, `collection_number`, `message_number`) VALUES (29, '简答', '简单', 'Java', '<p><span style=\"color: rgb(48, 49, 51); background-color: rgb(255, 255, 255); font-size: 19px;\"><strong>Lambda表达式的作用</strong></span></p>', '<p>	<span style=\"color: rgb(51, 51, 51);\">Lambda&nbsp;</span>	<a href=\"https://baike.baidu.com/item/%E8%A1%A8%E8%BE%BE%E5%BC%8F/7655228?fromModule=lemma_inlink\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"color: rgb(19, 110, 194);\">表达式</a>	<span style=\"color: rgb(51, 51, 51);\">（lambda expression）是一个</span>	<a href=\"https://baike.baidu.com/item/%E5%8C%BF%E5%90%8D%E5%87%BD%E6%95%B0/4337265?fromModule=lemma_inlink\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"color: rgb(19, 110, 194);\">匿名函数</a>	<span style=\"color: rgb(51, 51, 51);\">，Lambda表达式基于数学中的λ演算得名，直接对应于其中的lambda抽象（lambda abstraction），是一个</span>	<a href=\"https://baike.baidu.com/item/%E5%8C%BF%E5%90%8D%E5%87%BD%E6%95%B0/4337265?fromModule=lemma_inlink\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"color: rgb(19, 110, 194);\">匿名函数</a>	<span style=\"color: rgb(51, 51, 51);\">，即没有函数名的函数。Lambda表达式可以表示闭包，和传统数学上的意义有区别。</span></p>', 'Lambda表达式的作用', 10, '2023-05-21 06:35:16', 1, 0, 0);
INSERT INTO `title` (`id`, `question_type`, `difficulty`, `tag`, `title_name`, `explains`, `remarks`, `user_id`, `create_time`, `page_views`, `collection_number`, `message_number`) VALUES (30, '简答', '简单', 'Java', '<p>大大说的撒的大声点</p>', '<p>点点的撒的撒操作手册</p>', '相对', 10, '2023-05-21 07:31:08', 0, 0, 0);
INSERT INTO `title` (`id`, `question_type`, `difficulty`, `tag`, `title_name`, `explains`, `remarks`, `user_id`, `create_time`, `page_views`, `collection_number`, `message_number`) VALUES (31, '简答', '简单', 'Java', '<p>如何基础的理解数据结构？</p>', '<p><strong>数组</strong>的下标寻址十分迅速，但计算机的内存是有限的，故数组的长度也是有限的，实际应用当中的数据往往十分庞大；而且无序数组的查找最坏情况需要遍历整个数组；后来人们提出了二分查找，二分查找要求数组的构造一定有序，二分法查找解决了普通数组查找复杂度过高的问题。任何一种数组无法解决的问题就是插入、删除操作比较复杂，因此，在一个增删查改比较频繁的数据结构中，数组不会被优先考虑</p><p><strong>普通链表</strong>由于它的结构特点被证明根本不适合进行查找</p><p><strong>哈希表</strong>是数组和链表的折中，同时它的设计依赖散列函数的设计，数组不能无限长、链表也不适合查找，所以也不适合大规模的查找</p><p><strong>二叉查找树</strong>因为可能退化成链表，同样不适合进行查找</p><p><strong>AVL树</strong>是为了解决二叉查找树可能退化成链表问题。<strong>AVL树是严格的平衡二叉树</strong>，平衡条件必须满足（所有节点的左右子树高度差的绝对值不超过1）。不管我们是执行插入还是删除操作，只要不满足上面的条件，就要通过旋转来保持平衡，而旋转是非常耗时的，由此我们可以知道AVL树适合用于插入与删除次数比较少，但查找多的情况。</p><p><strong>红黑树</strong>是二叉查找树和AVL树的折中。它是一种弱平衡二叉树，但在每个节点增加一个存储位表示节点的颜色，可以是红或黑（非红即黑）。通过对任何一条从根到叶子的路径上各个节点着色的方式的限制，红黑树确保没有一条路径会比其它路径长出两倍，因此，<strong>红黑树是一种弱平衡二叉树</strong>（由于是弱平衡，可以看到，在相同的节点情况下，AVL树的高度低于红黑树），相对于要求严格的AVL树来说，它的旋转次数少，所以对于搜索，插入，删除操作较多的情况下，我们就用红黑树。</p><p>著作权归@pdai所有 原文链接：https://pdai.tech/md/interview/x-interview.html</p>', '数据结构', 10, '2023-05-21 07:33:01', 1, 0, 0);
INSERT INTO `title` (`id`, `question_type`, `difficulty`, `tag`, `title_name`, `explains`, `remarks`, `user_id`, `create_time`, `page_views`, `collection_number`, `message_number`) VALUES (32, '简答', '简单', 'Java', '<p>如何基础的理解数据结构？</p>', '<p><strong>数组</strong>的下标寻址十分迅速，但计算机的内存是有限的，故数组的长度也是有限的，实际应用当中的数据往往十分庞大；而且无序数组的查找最坏情况需要遍历整个数组；后来人们提出了二分查找，二分查找要求数组的构造一定有序，二分法查找解决了普通数组查找复杂度过高的问题。任何一种数组无法解决的问题就是插入、删除操作比较复杂，因此，在一个增删查改比较频繁的数据结构中，数组不会被优先考虑</p><p><strong>普通链表</strong>由于它的结构特点被证明根本不适合进行查找</p><p><strong>哈希表</strong>是数组和链表的折中，同时它的设计依赖散列函数的设计，数组不能无限长、链表也不适合查找，所以也不适合大规模的查找</p><p><strong>二叉查找树</strong>因为可能退化成链表，同样不适合进行查找</p><p><strong>AVL树</strong>是为了解决二叉查找树可能退化成链表问题。<strong>AVL树是严格的平衡二叉树</strong>，平衡条件必须满足（所有节点的左右子树高度差的绝对值不超过1）。不管我们是执行插入还是删除操作，只要不满足上面的条件，就要通过旋转来保持平衡，而旋转是非常耗时的，由此我们可以知道AVL树适合用于插入与删除次数比较少，但查找多的情况。</p><p><strong>红黑树</strong>是二叉查找树和AVL树的折中。它是一种弱平衡二叉树，但在每个节点增加一个存储位表示节点的颜色，可以是红或黑（非红即黑）。通过对任何一条从根到叶子的路径上各个节点着色的方式的限制，红黑树确保没有一条路径会比其它路径长出两倍，因此，<strong>红黑树是一种弱平衡二叉树</strong>（由于是弱平衡，可以看到，在相同的节点情况下，AVL树的高度低于红黑树），相对于要求严格的AVL树来说，它的旋转次数少，所以对于搜索，插入，删除操作较多的情况下，我们就用红黑树。</p><p>著作权归@pdai所有 原文链接：https://pdai.tech/md/interview/x-interview.html</p>', '数据结构', 10, '2023-05-21 07:33:53', 2, 0, 0);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sex` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `head_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `score` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `member` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `interest` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `introduction` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `collection_count` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `username`, `password`, `sex`, `head_url`, `score`, `member`, `create_time`, `interest`, `email`, `introduction`, `collection_count`) VALUES (2, 'zxc123', 'e10adc3949ba59abbe56e057f20f883e', NULL, 'https://srbtest1.oss-cn-beijing.aliyuncs.com/interview/head/WechatIMG37.jpeg', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `sex`, `head_url`, `score`, `member`, `create_time`, `interest`, `email`, `introduction`, `collection_count`) VALUES (3, 'z12345678', 'e10adc3949ba59abbe56e057f20f883e', NULL, 'https://srbtest1.oss-cn-beijing.aliyuncs.com/interview/head/WechatIMG37.jpeg', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `sex`, `head_url`, `score`, `member`, `create_time`, `interest`, `email`, `introduction`, `collection_count`) VALUES (4, 'z1234568', 'e10adc3949ba59abbe56e057f20f883e', NULL, 'https://srbtest1.oss-cn-beijing.aliyuncs.com/interview/head/WechatIMG37.jpeg', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `sex`, `head_url`, `score`, `member`, `create_time`, `interest`, `email`, `introduction`, `collection_count`) VALUES (5, 'z12345689', 'e10adc3949ba59abbe56e057f20f883e', NULL, 'https://srbtest1.oss-cn-beijing.aliyuncs.com/interview/head/WechatIMG37.jpeg', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `sex`, `head_url`, `score`, `member`, `create_time`, `interest`, `email`, `introduction`, `collection_count`) VALUES (6, 'z1234561', 'e10adc3949ba59abbe56e057f20f883e', NULL, 'https://srbtest1.oss-cn-beijing.aliyuncs.com/interview/head/WechatIMG37.jpeg', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `sex`, `head_url`, `score`, `member`, `create_time`, `interest`, `email`, `introduction`, `collection_count`) VALUES (7, 'z12345698', 'fcea920f7412b5da7be0cf42b8c93759', NULL, 'https://srbtest1.oss-cn-beijing.aliyuncs.com/interview/head/WechatIMG37.jpeg', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `sex`, `head_url`, `score`, `member`, `create_time`, `interest`, `email`, `introduction`, `collection_count`) VALUES (8, 'z123456986', 'fcea920f7412b5da7be0cf42b8c93759', NULL, 'https://srbtest1.oss-cn-beijing.aliyuncs.com/interview/head/WechatIMG37.jpeg', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `sex`, `head_url`, `score`, `member`, `create_time`, `interest`, `email`, `introduction`, `collection_count`) VALUES (9, 'z12345643', 'e10adc3949ba59abbe56e057f20f883e', NULL, 'https://srbtest1.oss-cn-beijing.aliyuncs.com/interview/head/WechatIMG37.jpeg', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `sex`, `head_url`, `score`, `member`, `create_time`, `interest`, `email`, `introduction`, `collection_count`) VALUES (10, 'z123456', 'e10adc3949ba59abbe56e057f20f883e', '男', 'https://srbtest1.oss-cn-beijing.aliyuncs.com/headUrl/2023/04/30/67eb3678-ae05-429a-bdb9-23ea0f8b04bf.jpg', NULL, NULL, '2023-04-30 05:25:18', '唱跳rap、篮球', '2248079439@qq.com', '一个真正的man', 17);
INSERT INTO `user` (`id`, `username`, `password`, `sex`, `head_url`, `score`, `member`, `create_time`, `interest`, `email`, `introduction`, `collection_count`) VALUES (11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for view_record
-- ----------------------------
DROP TABLE IF EXISTS `view_record`;
CREATE TABLE `view_record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `title_id` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of view_record
-- ----------------------------
BEGIN;
INSERT INTO `view_record` (`id`, `user_id`, `title_id`, `create_time`, `update_time`) VALUES (1, 10, 20, '2023-05-15 13:08:32', '2023-05-24 11:58:22');
INSERT INTO `view_record` (`id`, `user_id`, `title_id`, `create_time`, `update_time`) VALUES (3, 10, 14, '2023-05-21 05:01:42', '2023-05-21 05:01:42');
INSERT INTO `view_record` (`id`, `user_id`, `title_id`, `create_time`, `update_time`) VALUES (4, 10, 21, '2023-05-21 05:28:07', '2023-05-25 01:31:19');
INSERT INTO `view_record` (`id`, `user_id`, `title_id`, `create_time`, `update_time`) VALUES (5, 10, 28, '2023-05-21 05:31:03', '2023-05-21 06:35:33');
INSERT INTO `view_record` (`id`, `user_id`, `title_id`, `create_time`, `update_time`) VALUES (6, 10, 29, '2023-05-21 06:35:25', '2023-05-21 06:35:25');
INSERT INTO `view_record` (`id`, `user_id`, `title_id`, `create_time`, `update_time`) VALUES (7, 10, 31, '2023-05-21 07:33:09', '2023-05-21 07:33:09');
INSERT INTO `view_record` (`id`, `user_id`, `title_id`, `create_time`, `update_time`) VALUES (8, 10, 32, '2023-05-21 07:36:16', '2023-05-24 12:43:54');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
