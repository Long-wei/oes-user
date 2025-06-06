CREATE TABLE `user_social` (
                               `id` varchar(20) NOT NULL COMMENT '主键ID',
                               `user_id` varchar(20) NOT NULL COMMENT '用户ID',
                               `social_type` varchar(32) NOT NULL COMMENT '社交类型(wechat/qq/weibo等)',
                               `social_id` varchar(128) NOT NULL COMMENT '社交平台ID',
                               `social_name` varchar(128) COMMENT '社交平台用户名',
                               `social_avatar` varchar(256) COMMENT '社交平台头像',
                               `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                               PRIMARY KEY (`id`),
                               UNIQUE KEY `idx_social` (`social_type`, `social_id`),
                               KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户社交账号表';