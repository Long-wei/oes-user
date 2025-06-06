CREATE TABLE `user_profile` (
                                `id` varchar(20) NOT NULL COMMENT '主键ID',
                                `user_id` varchar(20) NOT NULL COMMENT '用户ID',
                                `id_card` varchar(32) COMMENT '身份证号',
                                `education` varchar(32) COMMENT '学历',
                                `school` varchar(128) COMMENT '学校',
                                `major` varchar(128) COMMENT '专业',
                                `address` varchar(256) COMMENT '地址',
                                `introduction` text COMMENT '个人简介',
                                `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                PRIMARY KEY (`id`),
                                UNIQUE KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户档案表';