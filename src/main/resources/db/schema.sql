-- 咨询师表
CREATE TABLE IF NOT EXISTS consultant (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_card VARCHAR(18) UNIQUE NOT NULL COMMENT '身份证号',
    name VARCHAR(50) NOT NULL COMMENT '姓名',
    phone VARCHAR(11) NOT NULL COMMENT '联系电话',
    school VARCHAR(100) COMMENT '所在学校（大学咨询师）',
    company VARCHAR(100) COMMENT '单位（企业咨询师）',
    intro TEXT COMMENT '个人简介',
    type TINYINT NOT NULL COMMENT '类型：1=大学咨询师，2=企业咨询师'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='咨询师信息表';

-- 学生表
CREATE TABLE IF NOT EXISTS student (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    student_id VARCHAR(20) UNIQUE NOT NULL COMMENT '学号',
    name VARCHAR(50) NOT NULL COMMENT '姓名',
    gender VARCHAR(2) NOT NULL COMMENT '性别：男/女',
    college VARCHAR(100) NOT NULL COMMENT '学院',
    phone VARCHAR(11) NOT NULL COMMENT '联系电话',
    birthday DATE NOT NULL COMMENT '生日',
    remark TEXT COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生信息表';

-- 咨询室表
CREATE TABLE IF NOT EXISTS room (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    room_no VARCHAR(50) UNIQUE NOT NULL COMMENT '咨询室编号',
    campus VARCHAR(50) NOT NULL COMMENT '校区',
    building VARCHAR(50) NOT NULL COMMENT '楼宇',
    room_number VARCHAR(20) NOT NULL COMMENT '房间号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='咨询室信息表';

-- 咨询记录表
CREATE TABLE IF NOT EXISTS consult_record (
    id VARCHAR(50) PRIMARY KEY COMMENT '预约记录ID（前端生成）',
    student_name VARCHAR(50) NOT NULL COMMENT '学生姓名',
    consultant_name VARCHAR(50) NOT NULL COMMENT '咨询师姓名',
    room_no VARCHAR(50) NOT NULL COMMENT '咨询室编号',
    start_time DATETIME NOT NULL COMMENT '起始时间',
    end_time DATETIME COMMENT '结束时间',
    question TEXT COMMENT '咨询问题',
    conclusion TEXT COMMENT '咨询结论',
    status TINYINT NOT NULL DEFAULT 1 COMMENT '状态：1=已预约，2=已完成'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='咨询记录表';

-- CSV加载日志表
CREATE TABLE IF NOT EXISTS csv_load_log (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    file_name VARCHAR(100) NOT NULL COMMENT 'CSV文件名',
    load_time DATETIME NOT NULL COMMENT '加载时间',
    load_count INT NOT NULL DEFAULT 0 COMMENT '加载条数',
    status TINYINT NOT NULL DEFAULT 0 COMMENT '状态：1=成功，0=失败',
    error_msg TEXT COMMENT '错误信息'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='CSV加载日志表';