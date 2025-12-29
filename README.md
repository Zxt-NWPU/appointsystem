# 就业咨询预约系统

## 项目简介

这是一个基于Spring Boot + MyBatis的就业咨询预约系统，主要用于学校就业指导中心管理咨询师信息、学生信息、咨询预约和记录等。

## 功能模块

1. **咨询师信息管理** - 管理校内外咨询师的基本信息
2. **学生信息管理** - 管理前来咨询的学生信息
3. **咨询预约管理** - 学生可以预约咨询师进行就业指导
4. **咨询记录管理** - 记录咨询过程和结果，支持导出功能

## 技术栈

- 后端：Spring Boot 3.5.8 + MyBatis
- 前端：Vue 3 + Bootstrap 5
- 数据库：MySQL
- 构建工具：Maven

## 快速开始

### 环境要求

- Java 17+
- MySQL 8.0+
- Maven 3.6+

### 数据库配置

1. 创建数据库：
```sql
CREATE DATABASE employment_consult CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

2. 修改`src/main/resources/application.yaml`中的数据库连接信息：
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/employment_consult?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true
    username: your_username
    password: your_password
```

### 初始化数据库表

执行`src/main/resources/db/schema.sql`中的SQL语句创建表结构。

### 运行项目

```bash
mvn spring-boot:run
```

或

```bash
mvn clean package
java -jar target/appointsystem-0.0.1-SNAPSHOT.jar
```

## 访问地址

- 首页：http://localhost:8080/
- 咨询师信息：http://localhost:8080/pages/consultant.html
- 学生管理：http://localhost:8080/pages/student.html
- 咨询预约：http://localhost:8080/pages/reserve.html
- 记录管理：http://localhost:8080/pages/record.html

## API接口

### 咨询师相关
- `GET /api/consultants` - 获取所有咨询师

### 学生相关
- `POST /api/students` - 添加学生

### 预约相关
- `POST /api/reserves` - 创建预约
- `PUT /api/records/{id}` - 完善预约记录

### 记录相关
- `GET /api/records` - 获取所有预约记录
- `GET /api/records/count` - 获取记录总数

## 注意事项

1. 系统启动时会自动加载`consultant.csv`和`room.csv`中的初始数据
2. 前端时间格式要求：yyyy-MM-dd HH:mm（如2024-12-01 14:30）
3. 学生学号和咨询师身份证号在系统中是唯一的