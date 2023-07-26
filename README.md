# Cinema Room REST Service
This is a Cinema Room REST Service that allows users to interact with a cinema by purchasing and returning tickets. The service provides endpoints to access the available seats in the cinema, purchase tickets, return tickets, and get statistics about the cinema.

# Technologies Used

- **Java 17**
- **Spring Boot** to simplify and configure the entire application
- **Spring Web** handles HTTP requests and responses for cinema-related operations
- **Lombok** for boilerplate code reduction
- **Jackson** for JSON serialization and deserialization
- **Maven** for build and dependency management

# Installation and Running

1. Clone the repository.
2. Build the application using Maven:
```mvn clean package```
3. Run the application using Maven:
```mvn spring-boot:run```

# Endpoints

`GET /seats`: Get information about the cinema room, including the total number of rows, columns, and available seats.
<img width="860" alt="image" src="https://user-images.githubusercontent.com/125138065/226221972-7b60ff19-3f8a-4514-b603-fb2560827ad0.png">

`POST /purchase`: Purchase a ticket by specifying the seat (row and column) to reserve. The response will include a token for the purchased ticket.

A request contain the following data:

    ● row — the row number
    ● column — the column number
    
These variables check if the specified ticket is available. If the ticket is booked, the seat will be marked as purchased and will not be shown it in the list.

<img width="860" alt="image" src="https://user-images.githubusercontent.com/125138065/226221549-32463dc0-b5bf-44d7-813c-4bd138e61402.png">


`POST /return`: Return a previously purchased ticket by providing the token associated with the ticket.

The request should have the token feature that identifies the ticket in the request body. Once you have the token, the ticket it relates to is identified and marked as available.
<img width="860" alt="image" src="https://user-images.githubusercontent.com/125138065/226221612-7c980637-6a79-48a2-b108-c5aaa499e531.png">


`POST /stats`: Get statistics related to ticket sales, including the current income, number of available seats, and number of purchased tickets.
<img width="860" alt="image" src="https://user-images.githubusercontent.com/125138065/226223207-734f1c8c-e3f5-4848-9fb2-7a586ce0e264.png">

If the parameters don't contain a password key or a wrong value has been passed, the program respond with a 401 (Unauthorized) status code. The response body should contain the following:
<img width="860" alt="image" src="https://user-images.githubusercontent.com/125138065/226223450-8c0d0557-a886-4b52-a1be-564e39dd3092.png">



