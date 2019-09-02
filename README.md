# Aircraft Queue Management System

Problem Statement -> [View](/resources/Exercise.txt)

Database Script-> [View](resources/script.sql)

**Database Details**
```
spring.datasource.url=jdbc:mysql://localhost:8889/binary
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```
**API Endpoints**

  **Request:** `PUT http://localhost:9091/binary/updatequeue`
   
   **Body**
   
    {
        "enqueueType": "E",
        "enqueueSize": "S",
        "position" : 9
    }
    
   **Request:** `GET http://localhost:9091/binary/list?queueType=V&queueSize=S&aircraftId=1`
