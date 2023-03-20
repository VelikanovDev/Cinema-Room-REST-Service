# Cinema Room REST Service
A simple Spring REST service that helps manage a small movie theatre. Handle HTTP requests in controllers, create services and respond with JSON objects.

Project from the Java Backend Developer course by <a href="https://hyperskill.org/projects/189">JetBrains Academy</a>.

The /seats endpoint handles GET requests and returns the information about the movie theatre.
<img width="860" alt="image" src="https://user-images.githubusercontent.com/125138065/226221972-7b60ff19-3f8a-4514-b603-fb2560827ad0.png">

The /purchase endpoint handles POST requests and marks a booked ticket as purchased.

A request contain the following data:

    ● row — the row number
    ● column — the column number
    
These variables check if the specified ticket is available. If the ticket is booked, the seat will be marked as purchased and will not be shown it in the list.

<img width="860" alt="image" src="https://user-images.githubusercontent.com/125138065/226221549-32463dc0-b5bf-44d7-813c-4bd138e61402.png">


The /return endpoint, which will handle POST requests and allow customers to refund their tickets.

The request should have the token feature that identifies the ticket in the request body. Once you have the token, the ticket it relates to is identified and marked as available.
<img width="860" alt="image" src="https://user-images.githubusercontent.com/125138065/226221612-7c980637-6a79-48a2-b108-c5aaa499e531.png">


The /stats endpoint handles POST requests with URL parameters. If the URL parameters contain a password key with a super_secret value, the movie theatre statistics is returned in the following format:
<img width="860" alt="image" src="https://user-images.githubusercontent.com/125138065/226223207-734f1c8c-e3f5-4848-9fb2-7a586ce0e264.png">


If the parameters don't contain a password key or a wrong value has been passed, the program respond with a 401 (Unauthorized) status code. The response body should contain the following:
<img width="860" alt="image" src="https://user-images.githubusercontent.com/125138065/226223450-8c0d0557-a886-4b52-a1be-564e39dd3092.png">



