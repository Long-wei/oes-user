CREATE TABLE `login_log` (
                             `id` varchar(64) NOT NULL COMMENT '主键ID',
                             `user_id` varchar(64) COMMENT '用户ID',
                             `username` varchar(64) COMMENT '用户名',
                             `ip` varchar(64) COMMENT 'IP地址',
                             `location` varchar(128) COMMENT '登录地点',
                             `device` varchar(256) COMMENT '登录设备',
                             `browser` varchar(128) COMMENT '浏览器类型',
                             `os` varchar(128) COMMENT '操作系统',
                             `status` tinyint COMMENT '登录状态(0-失败 1-成功)',
                             `msg` varchar(256) COMMENT '提示消息',
                             `login_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登录时间',
                             PRIMARY KEY (`id`),
                             KEY `idx_user_id` (`user_id`),
                             KEY `idx_login_time` (`login_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='登录日志表';