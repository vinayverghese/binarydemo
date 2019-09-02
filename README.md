# Aircraft Queue Management System

Problem Statement -> [View](/resources/Exercise.txt)

Postman Collection -> [View](resources/binarydemo.postman_collection.json)

Database Script-> [View](resources/script.sql)

## Database Details
```
spring.datasource.url=jdbc:mysql://localhost:8889/binary
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```
## API Endpoints

  - **Add to Queue:**
  
    To add to queue, pass AC with parameters based on:
     
     enqueueType = E (Emergency), V (VIP), P (Passenger), C (Cargo)
     
     enqueueSize = L (Large), S (Small)
     
     position = Position in Queue
   
     **_Request_** `PUT http://localhost:9091/binary/updatequeue`

     **_Body_**
       ```   
       {
           "enqueueType": "E",
           "enqueueSize": "S",
           "position" : 9
       }
      ```
  - **Remove from Queue:**
   
      To view ACs in Queue, pass without parameter

     **_Request_** `PUT http://localhost:9091/binary/dequeue`

      To dequeue ACs based on precedence, pass number of ACs (number=1,2,..) to be dequeued as path parameter

      **_Request_** `PUT http://localhost:9091/binary/dequeue/{number}`
 
   - **State of Queue:**

      To view state of queue, based on following parameters:
      
      aircraftId (Id of AC in Queue)
      
      queueType = E (Emergency), V (VIP), P (Passenger), C (Cargo)
      
      queueSize = L (Large), S (Small)

      **_Request_** `GET http://localhost:9091/binary/list?queueType=V&queueSize=S&aircraftId=1`
