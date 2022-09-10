# SpringBoot Demo API

商品查询 api

项目基于 SpringBoot + MyBatis + JWT + MySQL

## Configuration

首先在 MYSQL 中创建 `shop` 数据库, 并导入 `shop.sql`

然后在 `/src/main/resources/application.properties` 中配置数据库相关信息

```properties
server.port=8081

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/shop
spring.datasource.username=root
spring.datasource.password=root

mybatis.mapper-locations=classpath:mapper/*.xml
```

## Usage

用户相关

| method | url | desc | request body |
|------|-------------|------|---------|
| POST | /user/login | 用户登录 | `{"username": "admin", "password": "admin"}` |
| POST | /user/register | 用户注册 | `{"username": "test", "password": "test"}`   |

商品相关

| method | url | desc | request body |
|-----|-----|------|-----------------|
| GET | /product/get | 查询所有商品 | 无 |
| GET | /product/get/{id} | 查询指定商品 | 无 |
| POST | /product/add | 添加商品 | `{"name": "apple", "desc": "apple desc"}` |
| GET | /product/remove/{id} | 删除商品 | 无 |
| POST | /product/update | 更新商品 | `{"id": 1, name": "apple", "desc": "apple desc"}` |

## Authorization

用户在登录成功之后会返回如下信息

```json
{"code":200,"message":"success","data":"USER_JWT_TOKEN"}
```

其中 data 处为 jwt token

请求 product 相关操作时需添加如下 header

```
Authorization: USER_JWT_TOKEN
```