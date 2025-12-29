# 就业咨询预约系统

> 一个基于 Spring Boot + Vue.js + MySQL 的就业咨询预约管理系统

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.8-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Vue.js](https://img.shields.io/badge/Vue.js-3.5.25-brightgreen.svg)](https://vuejs.org/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

## 📋 项目简介

本系统为学生提供就业咨询师预约服务，支持学生信息管理、咨询师信息查看、预约创建、咨询记录完善及多格式导出等功能。采用前后端分离架构，后端基于 Spring Boot 提供 RESTful API，前端使用 Vue.js 构建响应式界面。

### 核心功能

- 👨‍🏫 **咨询师信息管理**：查看大学咨询师和企业咨询师信息，支持类型筛选和关键词搜索
- 👨‍🎓 **学生信息管理**：添加学生基本信息，支持列表展示和实时搜索
- 📅 **咨询预约**：创建咨询预约，支持模糊搜索学生、咨询师和咨询室，自动生成预约ID
- 📝 **咨询记录管理**：完善咨询记录，填写咨询问题和结论，支持导出为 JSON/XML/TXT 格式
- 🔍 **模糊搜索**：所有列表页面支持实时搜索和过滤，提升用户体验
- 📊 **数据统计**：实时显示记录数量，方便数据管理

### 系统特色

✅ **前后端分离架构** - 清晰的代码结构，便于维护和扩展  
✅ **响应式设计** - 基于 Bootstrap 5，适配多种设备  
✅ **数据自动初始化** - 系统启动时自动从 CSV 文件加载初始数据  
✅ **安全认证** - 集成 Spring Security，支持用户登录认证  
✅ **多格式导出** - 支持 JSON、XML、TXT 三种格式的数据导出  

## 🛠️ 技术栈

### 后端

- **Spring Boot 3.5.8** - 核心框架
- **Spring Security** - 安全认证
- **MyBatis** - ORM 框架
- **MySQL 8.0** - 数据库
- **OpenCSV 5.7.1** - CSV 文件解析
- **Maven 3.9.11** - 项目构建

### 前端

- **Vue.js 3.5.25** - 渐进式框架
- **Bootstrap 5.3.0** - UI 框架
- **Axios** - HTTP 客户端
- **xml-js** - XML 处理库

## 📦 项目结构

```
appointsystem/
├── src/main/
│   ├── java/com/school/appointsystem/
│   │   ├── config/           # 配置类（CORS、Security）
│   │   ├── controller/       # 控制器层
│   │   ├── entity/          # 实体类
│   │   ├── exception/       # 异常处理
│   │   ├── mapper/          # MyBatis Mapper
│   │   ├── service/         # 服务层
│   │   └── util/            # 工具类
│   └── resources/
│       ├── db/              # 数据库脚本
│       ├── mapper/xml/      # MyBatis XML 映射文件
│       ├── static/          # 静态资源
│       │   ├── css/        # 样式文件
│       │   ├── js/         # JavaScript 文件
│       │   └── pages/      # HTML 页面
│       ├── application.yaml # 配置文件
│       ├── consultant.csv  # 咨询师初始数据
│       └── room.csv        # 咨询室初始数据
└── pom.xml                 # Maven 配置
```

## 🚀 快速开始

### 环境要求

在开始之前，请确保你的系统已安装以下环境：

| 环境 | 版本要求 | 说明 |
|------|----------|------|
| JDK | 17+ | 推荐 JDK 17 或 JDK 21 |
| Maven | 3.6+ | 用于项目构建和依赖管理 |
| MySQL | 8.0+ | 数据库服务 |
| 浏览器 | 现代浏览器 | 推荐 Chrome、Firefox、Edge |

### 安装步骤

#### 1️⃣ 克隆项目

```bash
git clone <repository-url>
cd appointsystem
```

#### 2️⃣ 配置数据库

**创建数据库：**

```sql
-- 连接 MySQL
mysql -u root -p

-- 创建数据库
CREATE DATABASE employment_consult DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 退出 MySQL
exit;
```

**初始化数据表：**

```bash
# Windows
mysql -u root -p employment_consult < src/main/resources/db/schema.sql

# Linux/Mac
mysql -u root -p employment_consult < src/main/resources/db/schema.sql
```

或者可以手动执行 SQL 脚本：

```sql
-- 在 MySQL 客户端中执行
mysql -u root -p employment_consult
source src/main/resources/db/schema.sql;
```

#### 3️⃣ 修改配置文件

编辑 `src/main/resources/application.yaml`，修改数据库连接信息：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/employment_consult?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8
    username: root        # ⭐ 修改为你的 MySQL 用户名
    password: 123456      # ⭐ 修改为你的 MySQL 密码
```

#### 4️⃣ 启动项目

**方式一：使用 Maven 直接运行（推荐开发环境）**

```bash
mvn spring-boot:run
```

**方式二：打包后运行（推荐生产环境）**

```bash
# 打包项目
mvn clean package -DskipTests

# 运行 jar 文件
java -jar target/appointsystem-0.0.1-SNAPSHOT.jar
```

#### 5️⃣ 访问系统

等待启动成功后，打开浏览器访问：

- **系统首页**：[http://localhost:8080](http://localhost:8080)
- **登录页面**：[http://localhost:8080/login.html](http://localhost:8080/login.html)

🔑 **默认登录账户：**
- 用户名：`admin`
- 密码：`123456`

## 💡 使用说明

### 初始数据加载

系统启动时会自动从以下 CSV 文件加载初始数据：
- `consultant.csv` - 咨询师信息（4 条）
- `room.csv` - 咨询室信息（5 条）

### 功能页面

| 页面 | 路径 | 功能 |
|------|------|------|
| 首页 | `/index.html` | 系统导航和功能概览 |
| 咨询师信息 | `/pages/consultant.html` | 查看咨询师列表，支持筛选 |
| 学生信息管理 | `/pages/student.html` | 添加学生，查看学生列表 |
| 咨询预约 | `/pages/reserve.html` | 创建预约，查看预约列表 |
| 咨询记录管理 | `/pages/record.html` | 完善记录，导出数据 |

### 工作流程

1. **添加学生** → 在学生信息管理页面添加学生基本信息
2. **创建预约** → 在咨询预约页面选择学生、咨询师、咨询室和时间
3. **完善记录** → 在咨询记录管理页面填写咨询问题和结论
4. **导出数据** → 将咨询记录导出为 JSON/XML/TXT 格式

## 🔧 配置说明

### 端口配置

默认端口为 `8080`，可在 `application.yaml` 中修改：

```yaml
server:
  port: 8080  # 修改为其他端口
```

### CSV 文件路径

```yaml
spring:
  csv:
    consultant-path: classpath:consultant.csv
    room-path: classpath:room.csv
```

### MyBatis 日志

开发环境可查看 SQL 日志，生产环境建议关闭：

```yaml
mybatis:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl  # 删除此行关闭 SQL 日志
```

## 📊 数据库表结构

### 主要数据表

- `student` - 学生信息表
- `consultant` - 咨询师信息表
- `room` - 咨询室信息表
- `consult_record` - 咨询记录表
- `csv_load_log` - CSV 加载日志表

详细表结构请查看 `src/main/resources/db/schema.sql`

## 🐛 常见问题

### 1. 启动失败：端口被占用

**问题描述**：`Port 8080 was already in use`

**解决方法**：

```bash
# Windows
netstat -ano | findstr :8080
taskkill /PID <进程ID> /F

# Linux/Mac
lsof -i :8080
kill -9 <进程ID>
```

**或者修改端口**：

在 `application.yaml` 中修改：
```yaml
server:
  port: 8081  # 改为其他未占用的端口
```

### 2. 数据库连接失败

**问题 A**：`Access denied for user 'root'@'localhost'`

**解决方法**：
- 检查 `application.yaml` 中的用户名和密码是否正确
- 确认 MySQL 服务已启动
- 检查 MySQL 用户权限

**问题 B**：`Unknown database 'employment_consult'`

**解决方法**：
- 确认数据库 `employment_consult` 已创建
- 执行创建数据库命令：
  ```sql
  CREATE DATABASE employment_consult DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
  ```

**问题 C**：`Table 'employment_consult.student' doesn't exist`

**解决方法**：
- 执行 SQL 初始化脚本：
  ```bash
  mysql -u root -p employment_consult < src/main/resources/db/schema.sql
  ```

### 3. 前端页面空白或无数据

**问题描述**：页面加载后无数据显示或显示“暂无数据”

**解决步骤**：

1. **打开浏览器开发者工具**（F12）
   - 查看 Console 选项卡是否有错误信息
   - 查看 Network 选项卡 API 请求是否成功

2. **检查后端服务**
   - 确认后端应用已启动
   - 访问 API 接口测试：`http://localhost:8080/api/consultants`

3. **清除浏览器缓存**
   - 按 `Ctrl + Shift + Delete` 清除缓存
   - 或使用隐私模式浏览

4. **检查数据库数据**
   ```sql
   USE employment_consult;
   SELECT * FROM consultant;
   SELECT * FROM student;
   ```

### 4. CSV 数据加载失败

**问题描述**：启动日志显示 CSV 加载错误

**解决方法**：

1. **检查文件编码**
   - CSV 文件必须为 UTF-8 编码
   - 使用 Notepad++ 或 VS Code 检查并转换编码

2. **检查文件格式**
   - 确保每行字段数量正确
   - 检查是否有特殊字符导致解析错误

3. **查看详细日志**
   - 启动应用时查看控制台输出
   - 查看 `csv_load_log` 表中的错误信息

### 5. Maven 构建警告

**问题描述**：`WARNING: 'dependencies.dependency' must be unique`

**解决方法**：
- 这是 Lombok 依赖重复的警告，已经修复
- 如果仍有问题，执行：
  ```bash
  mvn clean install -U
  ```

### 6. 登录无法跳转到首页

**问题描述**：登录成功后仍然在登录页

**解决方法**：
- 检查 SecurityConfig 配置是否正确
- 确认静态资源路径配置正确
- 检查浏览器 Cookie 设置

### 7. 其他问题

如果遇到其他问题，请：

1. 查看控制台完整错误日志
2. 检查数据库连接和表结构
3. 确认所有依赖已正确安装
4. 尝试清理后重新构建：`mvn clean install`

## 📝 开发说明

### 代码规范

- 后端：遵循 Spring Boot 标准分层架构
- 前端：使用 Vue 3 组合式 API
- 命名：驼峰命名法（Java）、kebab-case（HTML/CSS）

### API 接口

所有接口路径前缀：`/api`

| 接口 | 方法 | 功能 |
|------|------|------|
| `/api/students` | GET | 获取所有学生 |
| `/api/students` | POST | 添加学生 |
| `/api/consultants` | GET | 获取所有咨询师 |
| `/api/rooms` | GET | 获取所有咨询室 |
| `/api/reserves` | POST | 创建预约 |
| `/api/records` | GET | 获取所有记录 |
| `/api/records/{id}` | PUT | 更新记录 |
| `/api/records/count` | GET | 获取记录总数 |

## 🔐 安全说明

- 当前版本使用 Spring Security 基础配置
- 生产环境建议启用 CSRF 保护
- 建议使用 HTTPS 协议
- 密码应使用 BCrypt 加密存储



**最后更新时间**：2025-12-29