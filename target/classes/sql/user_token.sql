CREATE TABLE `user_token` (
                              `id` varchar(20) NOT NULL COMMENT '主键ID',
                              `user_id` varchar(20) NOT NULL COMMENT '用户ID',
                              `token` varchar(512) NOT NULL COMMENT '令牌',
                              `token_type` tinyint NOT NULL COMMENT '令牌类型(access/refresh)',
                              `expire_time` datetime NOT NULL COMMENT '过期时间',
                              `status` tinyint COMMENT '状态',
                              `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `idx_token` (`token`),
                              KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户令牌表';