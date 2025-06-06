CREATE TABLE `role_permission` (
                                   `id` varchar(20) NOT NULL COMMENT '主键ID',
                                   `role_id` varchar(20) NOT NULL COMMENT '角色ID',
                                   `permission_id` varchar(20) NOT NULL COMMENT '权限ID',
                                   `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                   PRIMARY KEY (`id`),
                                   UNIQUE KEY `idx_role_permission` (`role_id`, `permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色权限关联表';