Online Library Management System


Project Description

The Online Library Management System is a web application that facilitates library administrators in managing book checkouts, book returns, tracking book statuses, and monitoring the borrowing history of members. Users (members) can borrow available books and track them based on return dates. Library administrators or staff can add, update, delete books, and manage the checkout process.

This project is developed using Spring Boot and offers a RESTful API for managing books, checkout transactions, and members. The goal is to provide a system for managing library operations in a digital environment.

Key Features:

1-)Management of books, members, and checkout transactions.

2-)Book borrowing, returning, and status tracking.

3-)Ability to switch between checkout history and available books.

4-)Different operations for users and administrators (adding, updating, deleting books, borrowing, etc.).

Technologies Used

This project is developed using the following technologies:

Backend

1-)Java: Main language for backend development.

2-)Spring Boot: To create RESTful APIs and manage business logic.

3-)Spring Data JPA (Hibernate): ORM (Object Relational Mapping) for database operations.

4-)H2 Database: Lightweight, in-memory database (a different database can be used in production).

5-)Maven: Dependency management and build tool.


Project Structure

Backend (Spring Boot)

1-)Controller: Defines REST API endpoints and handles data exchange with the frontend.

2-)Service: Contains business logic and manages database operations.

3-)Repository: Used for database access and CRUD operations.

4-)Entity: Represents database tables (e.g., Loan, Book, Member).


API Endpoints:

Below are the API endpoints available in the system:

A-)GET /api/loans

1-)Lists all loan transactions.

2-)Response: A list of loan transactions in JSON format.





B-)GET /api/loans/{id}

1-)Retrieves a specific loan transaction by ID.

2-)Response: The specific loan transaction in JSON format.





C-)POST /api/loans






1-)Starts a new loan transaction (with book and member information).

Request Body:


{

  "book": { "id": 1 },

  "member": { "id": 1 },
  
  "loanDate": "2024-01-07T00:00:00.000Z",
  
  "status": "BORROWED",
  
  "availableCopies": 1
}





2-)Response: The created loan transaction in JSON format.





D-)PUT /api/loans/{id}

1-)Updates a specific loan transaction.

2-)Request Body: Updated loan transaction data (book, member, loan date, return date, status).

3-)Response: The updated loan transaction in JSON format.






E-)DELETE /api/loans/{id}

1-)Deletes a specific loan transaction.

2-)Response: If the deletion is successful, returns a 204 No Content status.







F-)GET /api/books

1-)Lists all books.

2-)Response: A list of books in JSON format.







G-)GET /api/members

1-)Lists all members.

2-)Response: A list of members in JSON format.




ENTİTİES:

1. Book Entity

1-)ID: Unique identifier for the book.

2-)Title: Title of the book.

3-)Author: Author of the book.

4-)ISBN: International Standard Book Number (unique identifier for the book).

5-)Publish Date: The date when the book was published.

6-)Category: The genre or category of the book (e.g., Fiction, Non-fiction, Science, etc.).




2. Member Entity:

1-)ID: Unique identifier for the member.

2-)First Name: The first name of the member.

3-)Last Name: The last name of the member.

4-)Email: The email address of the member.

5-)Phone Number: The phone number of the member.

6-)Membership Date: The date when the member joined the library.



3. Loan Entity:
   

1-)ID: Unique identifier for the loan transaction.

2-)Book: The borrowed book (related to the Book Entity).

3-)Member: The member who borrowed the book (related to the Member Entity).

4-)Loan Date: The date the book was borrowed.

5-)Return Date: The date the book is due for return.

6-)Status: The status of the loan (e.g., "BORROWED").

7-)Available Copies: Number of available copies of the book.








