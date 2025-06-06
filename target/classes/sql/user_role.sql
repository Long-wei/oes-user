CREATE TABLE `user_role` (
                             `id` varchar(20) NOT NULL COMMENT '主键ID',
                             `user_id` varchar(20) NOT NULL COMMENT '用户ID',
                             `role_id` varchar(20) NOT NULL COMMENT '角色ID',
                             `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             PRIMARY KEY (`id`),
                             UNIQUE KEY `idx_user_role` (`user_id`, `role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关联表';