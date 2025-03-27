# digital_library_management_system
A Spring Boot-based web application for managing a digital library. This system allows users to add, update, delete, and search for books using a REST API. It is built using Spring Boot, MySQL, and Eclipse.

1.Technologies Used -
Spring Boot (Backend)
MySQL (Database)
Spring Data JPA (ORM)
Spring MVC (REST API)
JUnit & Mockito (Testing)
Eclipse/IntelliJ IDEA (IDE)
Postman (API Testing)

2.Setup Instructions - 
i.Prerequisites
Ensure you have the following installed:
Java 17+
MySQL Server
Maven
Eclipse/IntelliJ IDEA
Git

ii.Clone the Repository - 
git clone https://github.com/your-username/digital-library.git
cd digital-library

iii.Configure Database - 
Open MySQL and create a database:
CREATE DATABASE digital_library;
Update application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/digital_library
spring.datasource.username=root  # Change if needed
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

iv.Build and Run the Application -
Using Maven
mvn clean install
mvn spring-boot:run
Using Eclipse/IntelliJ IDEA
Open the project in your IDE
Run the DigitalLibraryApplication.java file

v.API Endpoints - 
Method             Endpoint            Description
GET                  /books          Fetch all books
GET               /books/{id}         book by ID
GET           /books/title/{title}   Get book by title
POST                 /books           Add a new book
PUT                /books/{id}     Update book details
DELETE             /books/{id}         Delete a book

vi.Running Tests -
To run tests using JUnit & Mockito:
