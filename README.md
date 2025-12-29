# 就业咨询预约系统

> 一个基于 Spring Boot + Vue.js + MySQL 的就业咨询预约管理系统

## 📋 项目简介

本系统为学生提供就业咨询师预约服务，支持学生信息管理、咨询师信息查看、预约创建、咨询记录完善及多格式导出等功能。

### 核心功能

- 👨‍🏫 **咨询师信息管理**：查看大学咨询师和企业咨询师信息，支持类型筛选和关键词搜索
- 👨‍🎓 **学生信息管理**：添加学生基本信息，支持列表展示和搜索
- 📅 **咨询预约**：创建咨询预约，支持模糊搜索学生、咨询师和咨询室
- 📝 **咨询记录管理**：完善咨询记录，支持导出为 JSON/XML/TXT 格式
- 🔍 **模糊搜索**：所有列表页面支持实时搜索和过滤

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

- **JDK 17+**
- **Maven 3.6+**
- **MySQL 8.0+**

### 安装步骤

#### 1. 克隆项目

```bash
git clone <repository-url>
cd appointsystem
```

#### 2. 创建数据库

```sql
CREATE DATABASE employment_consult DEFAULT CHARACTER SET utf8mb4;
```

#### 3. 配置数据库

修改 `src/main/resources/application.yaml`：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/employment_consult
    username: root        # 修改为你的 MySQL 用户名
    password: 123456      # 修改为你的 MySQL 密码
```

#### 4. 初始化数据库表

系统启动时会自动执行 `src/main/resources/db/schema.sql` 创建表结构。

#### 5. 启动项目

```bash
# 使用 Maven 启动
mvn spring-boot:run

# 或打包后启动
mvn clean package
java -jar target/appointsystem-0.0.1-SNAPSHOT.jar
```

#### 6. 访问系统

打开浏览器访问：[http://localhost:8080](http://localhost:8080)

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

**问题**：`Port 8080 was already in use`

**解决**：

```bash
# Windows
netstat -ano | findstr :8080
taskkill /PID <进程ID> /F

# Linux/Mac
lsof -i :8080
kill -9 <进程ID>
```

### 2. 数据库连接失败

**问题**：`Access denied for user 'root'@'localhost'`

**解决**：
- 检查 `application.yaml` 中的用户名和密码
- 确认 MySQL 服务已启动
- 确认数据库 `employment_consult` 已创建

### 3. 前端页面空白

**问题**：页面加载后无数据显示

**解决**：
- 打开浏览器开发者工具查看控制台错误
- 检查后端接口是否正常启动
- 清除浏览器缓存后重试

### 4. CSV 数据加载失败

**问题**：启动日志显示 CSV 加载错误

**解决**：
- 检查 CSV 文件编码是否为 UTF-8
- 检查 CSV 文件格式是否正确
- 查看日志中的详细错误信息

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

## 📄 许可证

MIT License

## 👥 贡献

欢迎提交 Issue 和 Pull Request！

## 📧 联系方式

如有问题，请联系项目维护者。

---

**最后更新时间**：2025-12-29