Book-Rental - Online Book Rental System
====================================

Book-Rental is a RESTful API service built with Spring Boot and Gradle for managing an online book rental system. It allows users to register, login, browse available books, rent and return books, and manage book inventory. The service is secured with Basic Authentication and role-based access control.

Features
--------

-   User Registration and Login
-   Book Management (CRUD operations)
-   Rental Management (Renting and Returning Books)
-   Basic Authentication and Authorization (USER and ADMIN roles)
-   Error Handling and Validation
-   Unit Testing
-   Logging
-   Deployment Instructions

Prerequisites
-------------

Before running the application, ensure you have the following installed:

-   Java 8 or higher
-   Gradle
-   MySQL

Installation
------------

1.  Clone the repository:

    bashCopy code

    `git clone https://github.com/adityaag530/book-rental.git`

2.  Navigate to the project directory:

    bashCopy code

    `cd book-rental`

3.  Build the project:

    bashCopy code

    `gradle build`

4.  Run the application:

    bashCopy code

    `java -jar build/libs/book-rental-0.0.1-SNAPSHOT.jar`

    Alternatively, you can run the application using Gradle:

    bashCopy code

    `gradle bootRun`

Configuration
-------------

-   Database configuration can be found in `src/main/resources/application.properties`.
-   Security configuration can be found in `src/main/java/com/crio/bookrental/config/SecurityConfig.java`.




Postman Collection
-----
You can find the Postman collection for this API here.

[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://app.getpostman.com/run-collection/12734353-00dc2df2-ce1a-411a-8872-41239566a6a3?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D12734353-00dc2df2-ce1a-411a-8872-41239566a6a3%26entityType%3Dcollection%26workspaceId%3Deb6039ff-527d-4e42-a8c0-36baf4ffd0b0)

Testing
-------

Run unit tests using Gradle:

bashCopy code

`gradle test`

Contributing
------------

Contributions are welcome! Please feel free to submit a pull request or open an issue for any bugs or feature requests.

License
-------

This project is licensed under the MIT License - see the LICENSE file for details.