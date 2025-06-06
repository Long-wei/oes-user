CREATE TABLE `permission` (
                              `id` varchar(20) NOT NULL COMMENT '权限ID',
                              `name` varchar(64) NOT NULL COMMENT '权限名称',
                              `code` varchar(128) NOT NULL COMMENT '权限编码',
                              `type` tinyint NOT NULL COMMENT '权限类型(1-菜单 2-按钮 3-API)',
                              `parent_id` varchar(20) DEFAULT 0 COMMENT '父权限ID',
                              `path` varchar(256) COMMENT '路由路径',
                              `icon` varchar(64) COMMENT '图标',
                              `sort` int DEFAULT 0 COMMENT '排序',
                              `description` varchar(256) COMMENT '描述',
                              `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `idx_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限表';