-- 图纸信息表
CREATE TABLE IF NOT EXISTS my_drawing (
    id VARCHAR(255) PRIMARY KEY COMMENT '唯一ID',
    drawing_no VARCHAR(255) NOT NULL DEFAULT 'LPSK-FT9224' COMMENT '编号',
    drawing_name VARCHAR(255) NOT NULL COMMENT '图名',
    material VARCHAR(255) NOT NULL COMMENT '材质',
    perimeter DECIMAL(10,2) COMMENT '周长',
    area DECIMAL(10,2) COMMENT '面积',
    standard_weight DECIMAL(10,3) COMMENT '标准重',
    net_weight DECIMAL(10,3) COMMENT '净重',
    thickness_spec VARCHAR(255) COMMENT '未标示厚度',
    usage_scene VARCHAR(255) COMMENT '用途',
    drawing_date DATE COMMENT '日期',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='图纸信息表';