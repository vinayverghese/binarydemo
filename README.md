# Aircraft Queue Management System

Problem Statement -> [View](/resources/Exercise.txt)

Postman Collection -> [View](resources/binarydemo.postman_collection.json)

Database Script-> [View](resources/script.sql)

## Server Details

In order to define hostname and port, following properties are required (Port can be changed)

```
server.servlet.contextPath=/binary
server.port=9091
```

## Database Details
```
spring.datasource.url=jdbc:mysql://localhost:8889/binary
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```
## API Endpoints

  - **Add to Queue:**
  
    To add an AC to queue, call request with following parameters in the body based on:
     
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
   
      To view ACs in Queue, call below request without any parameter

     **_Request_** `PUT http://localhost:9091/binary/dequeue`

      To dequeue ACs based on precedence, call request with number of ACs (number=1,2,..) to be dequeued as path parameter

      **_Request_** `PUT http://localhost:9091/binary/dequeue/{number}`
 
   - **State of Queue:**

      To view state of queue, call request based on following query parameters:
      
      aircraftId (Id of AC in Queue)
      
      queueType = E (Emergency), V (VIP), P (Passenger), C (Cargo)
      
      queueSize = L (Large), S (Small)

      **_Request_** `GET http://localhost:9091/binary/list?queueType=V&queueSize=S&aircraftId=1`
