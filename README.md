# Aircraft Queue Management System

Problem Statement -> [View](/resources/Exercise.txt)

Postman Collection -> [View](resources/binarydemo.postman_collection.json)

Database Script-> [View](resources/script.sql)

**Database Details**
```
spring.datasource.url=jdbc:mysql://localhost:8889/binary
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```
**API Endpoints**

  **Add to Queue:**
  **Request:** `PUT http://localhost:9091/binary/updatequeue`
   
   **Body**
   
    {
        "enqueueType": "E",
        "enqueueSize": "S",
        "position" : 9
    }
    
   **Remove from Queue:**
   To view ACs in Queue, pass without parameter
   **Request:** `PUT http://localhost:9091/binary/dequeue`
    
   To dequeue ACs based on precedence, pass number of ACs (number=1,2,..) to be dequeued as path parameter
   **Request:** `PUT http://localhost:9091/binary/dequeue/{number}`
 
   **State of Queue**
   To view state of queue, based on following parameters:
   aircraftId (Id of AC in Queue)
   queueType = E (Emergency), V (VIP), P (Passenger), C (Cargo)
   queueSize = L (Large), S (Small)
   **Request:** `GET http://localhost:9091/binary/list?queueType=V&queueSize=S&aircraftId=1`
