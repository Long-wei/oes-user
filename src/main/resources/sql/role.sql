CREATE TABLE `role` (
                        `id` varchar(20) NOT NULL COMMENT '角色ID',
                        `name` varchar(64) NOT NULL COMMENT '角色名称',
                        `code` varchar(64) NOT NULL COMMENT '角色编码',
                        `description` varchar(256) COMMENT '角色描述',
                        `status` tinyint DEFAULT 1 COMMENT '状态(0-禁用 1-正常)',
                        `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `idx_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';