# Aircraft Queue Management System

Problem Statement -> [View](/resources/Exercise.txt)

**Database Details**
```
spring.datasource.url=jdbc:mysql://localhost:8889/binary
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

Database Script-> [View](resources/script.sql)

**API Endpoints**
 - **Request**
```
POST http://localhost:9091/binary/updatequeue
```
 - **Body**
```
{
    "enqueueType": "E",
    "enqueueSize": "S",
    "position" : 9
}
```
